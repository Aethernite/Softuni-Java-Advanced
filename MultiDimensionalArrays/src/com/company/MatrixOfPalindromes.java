package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        String[][] array = new String[r][c];
        array = fill(array);
        print(array);

    }
//97-122
    public static String[][] fill(String[][] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                StringBuilder sb = new StringBuilder();
                sb.append((char)(i+97));
                sb.append((char) (i+j+97));
                sb.append((char)(i+97));
                array[i][j] = sb.toString();
            }
        }
        return array;
    }

    public static void print(String[][] array){
        for(int i=0;i<array.length; i++){
            for(int j=0; j<array[0].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
