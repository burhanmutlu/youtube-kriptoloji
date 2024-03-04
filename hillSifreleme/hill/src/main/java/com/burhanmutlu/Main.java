package com.burhanmutlu;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.*;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {

        /*int i, j;
        final int sizeOfAlphabet = 26;
        final int startAlphabetNumber = 97;

        int[][] key = {
                {6,24,1},
                {13,16,10},
                {20,17,15}};

        char[] val = {'b', 'c', 'd'};
        char[] alphabet = new char[sizeOfAlphabet];

        j = 0;
        for (i = startAlphabetNumber; i < startAlphabetNumber+sizeOfAlphabet; i++) {
            alphabet[j++] = (char)i;
            System.out.print(i-startAlphabetNumber + ":" + alphabet[i-startAlphabetNumber] + " ");
        }

        System.out.println();
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                System.out.print(key[i][j] + " ");
            }
            System.out.println();
        }

        char[] newVal = new char[3];
        int temp=0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                temp += key[i][j] * (val[j]-startAlphabetNumber);
            }
            temp = startAlphabetNumber + (temp % sizeOfAlphabet);
            newVal[i] = (char) temp;
            temp = 0;
        }

        for (char c : newVal) {
            System.out.println(c);
        }*/


        HillCipher hillCipher = new HillCipher();
        int[][] key = {
                {6,24,1},
                {13,16,10},
                {20,17,15}};
        hillCipher.setKey(key);

        File file = new File("C:\\Users\\Burhan Mutlu\\Pictures\\Camera Roll\\resim.jpg");
        try {
            byte[] imageData = new byte[(int) file.length()];
            //BufferedImage image = ImageIO.read(imageData);
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                fileInputStream.read(imageData);
            }
            String base64Image = Base64.getEncoder().encodeToString(imageData);

            System.out.println(base64Image);


            /*int width = image.getWidth();
            int height = image.getHeight();

            int[] dataX = new int[width*height]; // 0 1 2 3 4 5 6 7 8

            for(int y=0; y<width*height; y++) {
                dataX[y] = y;
            }

            int[] newDataX = hillCipher.encrypt(dataX);
            BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for(int n : newDataX) {
                System.out.println("x " +n);
            }
            int count = 0;
            for(int x=0; x<height*width; x++) {
                int pixel = image.getRGB(x/width,x/height);
                System.out.println();
                //newImage.setRGB(newDataX[x], y, pixel);
                count++;
            }


            File outputFile = new File("C:\\Users\\Burhan Mutlu\\Pictures\\Camera Roll\\output_image.png");
            ImageIO.write(newImage, "png", outputFile);

            System.out.println("İşlem tamamlandı.");*/







        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}