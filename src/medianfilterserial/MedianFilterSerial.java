/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medianfilterserial;

/**
 *
 * @author rowanvi
 *
 */
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;

class MedianFilterSerial {

    //PICTURES http://people.sc.fsu.edu/~jburkardt/data/pgma/pgma.html
    public static void main(String[] a) throws Throwable {
        final String fileType = "png";
        final String file = "input2.png";
        final String outputFile = "output2.png";
        final int chunks = 25;
  
        long startTime = System.currentTimeMillis();

        final Image image = new Image(file, outputFile, fileType);
        BufferedImage outputImage = null;
        BufferedImage splitTemp[] = new BufferedImage[chunks];       
        splitTemp = image.splitImage();
        final BufferedImage imgs[] = splitTemp;

        for (int i = 0; i < imgs.length; i++) {
            image.applyMedianFilterOnOtherImages(imgs[i]);
        }

        image.combineChunks(imgs);
        
        //ImageIO.write(image.getImg(), image.getFileType(), image.getOutputCreatedFile());
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);

        System.out.println("Duration " + duration);
    }
}
