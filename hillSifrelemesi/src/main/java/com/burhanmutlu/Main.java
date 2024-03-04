package com.burhanmutlu;

public class Main {

    public static int calculateDeterminant(int[][] matrix) {
        int length = matrix.length;
        if (length == 2) return calculateMode(calculate2DMatrix(matrix), 26);
        else if (length == 3) {
            int right, left;
            int valueToCollected = 0, valueToExtracted = 0;
            for (int i = 0; i < length; i++) {
                right = 1;
                left = 1;
                for (int j = 0; j < length; j++) {
                    left *= matrix[i % length][3 - j - 1];
                    right *= matrix[i++ % length][j];
                }
                valueToCollected += right;
                valueToExtracted += left;
                i -= 3;
            }
            return calculateMode(valueToCollected - valueToExtracted, 26);
        } else {

            return 0;
        }
    }

    public static int calculate2DMatrix(int[][] matrix) {
        return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
    }

    public static int calculateMode(int num, int modeValue) {
        if (num >= 0) num %= modeValue;
        else while (num < 0) num += modeValue;
        return num;
    }

    public static void printMatrix(int[][] matrix) { // kare matrix
        System.out.println("----");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----");
    }

    public static void main(String[] args) {

        int[][] key = {
                {6, 24, 1},
                {13, 16, 10},
                {20, 17, 15}
        };

        /*StringBuilder value = new StringBuilder();
        value.append("burhanmutlu");
        if(value.length() % key.length != 0) {
            int donguSayisi = key.length - value.length() % key.length;
            for (int i = 0; i < donguSayisi; i++) {
                value.append("a");
            }
        }
        int toplam = 0;
        for (int k = 0; k < (value.length()/ key.length); k++) { // kelimede kac tane 3 luk bolum var
            for (int i = 0; i < key.length; i++) { // matrisin degeri : 3
                    for (int j = 0; j < key.length; j++) { // kare oldugu icin : 3
                        toplam += key[i][j] * (int)(value.charAt(j + k*key.length) -97);
                    }
                    toplam = toplam % 26;
                System.out.print((char)(toplam+97));
                toplam = 0;
            }
        }*/

        String textToEncrypt = "tflgkrdqgkwxfuvvqc";

        int det = calculateDeterminant(key);

        // matrisin cofunu bulma
        int v = 0;
        while (true) {
            if ((det * v) % 26 == 1) {
                System.out.println(v);
                break;
            }
            v += 1;
        }

        int[][] newKeyCof = new int[key.length - 1][key.length - 1];
        int[][] newKey = new int[key.length][key.length];
        int cof = 0;
        int a, b;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                a = 0; b = 0;
                for (int ii = 0; ii < key.length; ii++) {
                    for (int jj = 0; jj < key.length; jj++) {
                        if (ii != i && jj != j) {
                            newKeyCof[a][b++] = key[ii][jj];
                            if (b == 2){
                                a++;
                                b = 0;
                            }
                        }
                    }
                }
                cof = (int) Math.pow(-1, i + j) * calculate2DMatrix(newKeyCof);
                newKey[i][j] = calculateMode(cof, 26);
            }
        }

        // matrisin transpozunu bulma
        int temp = 0;
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if(i<j) {
                    temp = newKey[i][j];
                    newKey[i][j] = newKey[j][i];
                    newKey[j][i] = temp;
                }
                newKey[i][j] = calculateMode(v*newKey[i][j], 26);
            }
        }
        printMatrix(newKey);

        int toplam = 0;
        for (int k = 0; k < (textToEncrypt.length()/ key.length); k++) { // kelimede kac tane 3 luk bolum var
            for (int i = 0; i < key.length; i++) { // matrisin degeri : 3
                for (int j = 0; j < key.length; j++) { // kare oldugu icin : 3
                    toplam += newKey[i][j] * (int) (textToEncrypt.charAt(j + k * key.length) - 97);
                }
                toplam = toplam % 26;
                System.out.print((char) (toplam + 97));
                toplam = 0;
            }
        }


    }
}
