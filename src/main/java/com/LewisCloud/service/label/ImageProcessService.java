package com.LewisCloud.service.label;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageProcessService {
    public void readImage(File image) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new FileInputStream(image));
        bufferedImage.getWidth();
        bufferedImage.getHeight();

    }
}
