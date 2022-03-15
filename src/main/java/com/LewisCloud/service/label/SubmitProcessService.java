package com.LewisCloud.service.label;

import com.LewisCloud.common.exception.BaseException;
import com.LewisCloud.service.PathService;
import com.LewisCloud.vo.coco.Annotation;
import com.LewisCloud.vo.coco.Image;
import com.LewisCloud.vo.coco.Info;
import com.LewisCloud.vo.coco.Instances;
import com.LewisCloud.vo.raw.Classification;
import com.LewisCloud.vo.raw.Submit;
import com.LewisCloud.vo.raw.Svg;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.Inet4Address;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Service
public class SubmitProcessService {
    @Autowired
    private PathService pathService;

    public void getSubmit(String submitJson) throws IOException {
        Submit submit = JSON.parseObject(submitJson, Submit.class);
        String photosPath = pathService.getPhotosPath(submit.getProjectId());
        String cocoPath = pathService.getCocoPath(submit.getProjectId());
        Instances instances = null;

        File instancesFile = new File(cocoPath, "instances.json");

        if (!instancesFile.exists()) {
            boolean isCreated = instancesFile.createNewFile();
            instances = new Instances();

            instances.setInfo(new Info("COCO dataset", Inet4Address.getLocalHost().getHostAddress(),
                    "1.0", Calendar.getInstance().get(Calendar.YEAR), "host",
                    submit.getCreatedAt().split("\\s+")[0]));

            List<Image> newImages = new ArrayList<>();
            newImages.add(new Image(0, submit.getImageName(),
                    Inet4Address.getLocalHost().getHostAddress() + photosPath + "\\" + submit.getImageName(),
                    submit.getImageHeight(), submit.getImageWidth(), submit.getImageId()));
            instances.setImages(newImages);

            Annotation newAnnotation = parseAnnotation(submit);
            List<Annotation> newAnnotations = new ArrayList<>();
            newAnnotations.add(newAnnotation);
            instances.setAnnotations(newAnnotations);

            String instancesJSON = JSON.toJSONString(instances);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(instancesFile));
            out.write(instancesJSON.getBytes(StandardCharsets.UTF_8));
            out.close();

        } else {
            instances = JSON.parseObject(new BufferedInputStream(new FileInputStream(instancesFile)), Instances.class);

            instances.addImage(new Image(0, submit.getImageName(),
                    Inet4Address.getLocalHost().getHostAddress() + photosPath + "\\" + submit.getImageName(),
                    submit.getImageHeight(), submit.getImageWidth(), submit.getImageId()));

            instances.addAnnotation(parseAnnotation(submit));

            String instancesJSON = JSON.toJSONString(instances);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(instancesFile));
            out.write(instancesJSON.getBytes(StandardCharsets.UTF_8));
            out.close();
        }


//        System.out.println(submit);
    }

    private Annotation parseAnnotation(Submit submit) {
        List<Double> doubles = new ArrayList<>();
        Svg svg = submit.getData().getSvgArr().get(0);
        Classification classification = submit.getData().getClassifications().get(0);
        for (HashMap<String, Double> data : svg.getSegmentation()) {
            doubles.addAll(data.values());
        }
        List<List<Double>> segmentation = new ArrayList<>();
        segmentation.add(doubles);
        double l = doubles.get(2) - doubles.get(0);
        double h = doubles.get(5) - doubles.get(3);
        double area = l * h;
        return new Annotation(segmentation, area, svg.isCrowd() ? 1 : 0, submit.getImageId(),
                classification.getClassId(), 0);
    }
}
