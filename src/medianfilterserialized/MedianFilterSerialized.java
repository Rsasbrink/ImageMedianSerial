/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medianfilterserialized;

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

class MedianFilterSerialized {

    //PICTURES http://people.sc.fsu.edu/~jburkardt/data/pgma/pgma.html
    public static void main(String[] a) throws Throwable {
        final String fileType = "png";
        final String file = "/Users/rowanvi/Desktop/balloons_noisy-color.png";
        final String outputFile = "/Users/rowanvi/Desktop/output4.png";
        long startTime = System.nanoTime();
        final Image image = new Image(file, outputFile, fileType);
        BufferedImage outputImage = null;
        image.applyMedianFilterOnOtherImages();
        ImageIO.write(image.getImg(), image.getFileType(), image.getOutputCreatedFile());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Duration " + duration);
        //NOT IN USE FOR NOW
//        if(fileType == "PGM"){
//            md.applyMedianFilterOnPGM(file, outputFile);
//        }else{
//            md.applyMedianFilterOnOtherImages(file, outputFile, fileType);
//        }
    }
}
