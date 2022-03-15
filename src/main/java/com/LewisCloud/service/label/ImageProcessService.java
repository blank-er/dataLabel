package com.LewisCloud.service.label;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ImageProcessService {
    public static int getWidth(File image) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new FileInputStream(image));
        return bufferedImage.getWidth();
    }

    public static int getHeight(File image) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new FileInputStream(image));
        return bufferedImage.getHeight();
    }

}
