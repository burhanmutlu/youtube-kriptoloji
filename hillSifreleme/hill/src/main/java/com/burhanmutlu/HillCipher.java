package com.burhanmutlu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

public class HillCipher {

    private int[][] key;

    public HillCipher() {

    }

    public int[][] getKey() {
        return key;
    }

    public void setKey(int[][] key) {
        this.key = key;
    }

    public int[] encrypt(int[] data) {
        int[] data2 = editData(data);
        int[] encryptedValue = new int[data2.length];
        int size = data2.length;
        int temp=0;
        for (int k = 0; k < (size /getKeySize()); k++) {
            for (int i = 0; i < getKeySize(); i++) {
                for (int j = 0; j < getKeySize(); j++) {
                    temp += key[i][j] * data2[j+ (k*getKeySize())];
                }
                temp = temp % data.length;
                encryptedValue[i+(k*getKeySize())] = temp;
                temp = 0;
            }
        }
        return encryptedValue;
    }

    public int[] decrypt(int[] data) {


        return null;
    }

    private int getKeySize() {
        return key.length;
    }

    private int[] editData(int[] data) {
        if(data.length % getKeySize() == 0) {
            return data;
        } else {
            int val = getKeySize() - (data.length % getKeySize());
            int newSize = data.length + val;
            int[] newData = new int[newSize];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }

            for(int i=0; i<val; i++) {
                newData[newSize-val+i] = 3;
            }

            return newData;
        }
    }

    public String encodeImageToBase64(String imagePath) throws IOException {
        File imageFile = new File(imagePath);

        byte[] imageData = new byte[(int) imageFile.length()];
        try (FileInputStream fileInputStream = new FileInputStream(imageFile)) {
            fileInputStream.read(imageData);
        }

        return Base64.getEncoder().encodeToString(imageData);
    }

}
