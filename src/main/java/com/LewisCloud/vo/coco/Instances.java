package com.LewisCloud.vo.coco;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Instances {
    private Info info;
    private List<License> licenses;
    private List<Image> images;
    private List<Annotation> annotations;
    private List<Category> categories;

    public Instances() {
        licenses = new ArrayList<>();

        categories = new ArrayList<>();
        categories.add(new Category("person", 1, "person"));
        categories.add(new Category("vehicle", 2, "bicycle"));
        categories.add(new Category("vehicle", 3, "car"));
        categories.add(new Category("vehicle", 4, "motorcycle"));
        categories.add(new Category("vehicle", 5, "airplane"));
        categories.add(new Category("vehicle", 6, "bus"));
        categories.add(new Category("vehicle", 7, "train"));
        categories.add(new Category("vehicle", 8, "truck"));
        categories.add(new Category("vehicle", 9, "boat"));
        categories.add(new Category("outdoor", 10, "traffic light"));
        categories.add(new Category("outdoor", 11, "fire hydrant"));
        categories.add(new Category("outdoor", 13, "stop sign"));
        categories.add(new Category("outdoor", 14, "parking meter"));
        categories.add(new Category("outdoor", 15, "bench"));
        categories.add(new Category("animal", 16, "bird"));
        categories.add(new Category("animal", 17, "cat"));
        categories.add(new Category("animal", 18, "dog"));
        categories.add(new Category("animal", 19, "horse"));
        categories.add(new Category("animal", 20, "sheep"));
        categories.add(new Category("animal", 21, "cow"));
        categories.add(new Category("animal", 22, "elephant"));
        categories.add(new Category("animal", 23, "bear"));
        categories.add(new Category("animal", 24, "zebra"));
        categories.add(new Category("animal", 25, "giraffe"));
        categories.add(new Category("accessory", 27, "backpack"));
        categories.add(new Category("accessory", 28, "umbrella"));
        categories.add(new Category("accessory", 31, "handbag"));
        categories.add(new Category("accessory", 32, "tie"));
        categories.add(new Category("accessory", 33, "suitcase"));
        categories.add(new Category("accessory", 34, "frisbee"));
        categories.add(new Category("sports", 35, "skis"));
        categories.add(new Category("sports", 36, "snowboard"));
        categories.add(new Category("sports", 37, "sports ball"));
        categories.add(new Category("sports", 38, "kite"));
        categories.add(new Category("sports", 39, "baseball bat"));
        categories.add(new Category("sports", 40, "baseball glove"));
        categories.add(new Category("sports", 41, "skateboard"));
        categories.add(new Category("sports", 42, "surfboard"));
        categories.add(new Category("sports", 43, "tennis racket"));
        categories.add(new Category("kitchen", 44, "bottle"));
        categories.add(new Category("kitchen", 46, "wine glass"));
        categories.add(new Category("kitchen", 47, "cup"));
        categories.add(new Category("kitchen", 48, "fork"));
        categories.add(new Category("kitchen", 49, "knife"));
        categories.add(new Category("kitchen", 50, "spoon"));
        categories.add(new Category("kitchen", 51, "bowl"));
        categories.add(new Category("food", 52, "banana"));
        categories.add(new Category("food", 53, "apple"));
        categories.add(new Category("food", 54, "sandwich"));
        categories.add(new Category("food", 55, "orange"));
        categories.add(new Category("food", 56, "broccoli"));
        categories.add(new Category("food", 57, "carrot"));
        categories.add(new Category("food", 58, "hot dog"));
        categories.add(new Category("food", 59, "pizza"));
        categories.add(new Category("food", 60, "donut"));
        categories.add(new Category("food", 61, "cake"));
        categories.add(new Category("furniture", 62, "chair"));
        categories.add(new Category("furniture", 63, "couch"));
        categories.add(new Category("furniture", 64, "potted plant"));
        categories.add(new Category("furniture", 65, "bed"));
        categories.add(new Category("furniture", 67, "dining table"));
        categories.add(new Category("furniture", 70, "toilet"));
        categories.add(new Category("electronic", 72, "tv"));
        categories.add(new Category("electronic", 73, "laptop"));
        categories.add(new Category("electronic", 74, "mouse"));
        categories.add(new Category("electronic", 75, "remote"));
        categories.add(new Category("electronic", 76, "Keyboard"));
        categories.add(new Category("electronic", 77, "cell phone"));
        categories.add(new Category("appliance", 78, "microwave"));
        categories.add(new Category("appliance", 79, "oven"));
        categories.add(new Category("appliance", 80, "toaster"));
        categories.add(new Category("appliance", 81, "sink"));
        categories.add(new Category("appliance", 82, "refrigerator"));
        categories.add(new Category("indoor", 84, "book"));
        categories.add(new Category("indoor", 85, "clock"));
        categories.add(new Category("indoor", 86, "vase"));
        categories.add(new Category("indoor", 87, "scissors"));
        categories.add(new Category("indoor", 88, "teddy bear"));
        categories.add(new Category("indoor", 89, "hair drier"));
        categories.add(new Category("indoor", 90, "toothbrush"));
    }

    public void addLicense(License license) {
        licenses.add(license);
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public void addAnnotation(Annotation annotation) {
        annotations.add(annotation);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }
}
