package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiDimensionalPatterns1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(", ");
        int size = Integer.parseInt(input[0]);
        if(input[1].equals("A")){
            print(A(size));
        }else{
            print(B(size));
        }

    }

 public static int[][] A(int size) {
     int[][] array = new int[size][size];
     int count = 1;
     for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
             array[j][i] = count++;
         }
     }
     return array;
 }

 public static int[][] B(int size){
        int[][] array = new int[size][size];
        int count = 1;
        for(int i=0, q=0;i<size ; i++){
            if(i%2==0) {
                for (int j = 0; j < size; j++) {
                    array[j][i] = count++;
                }
            } else{
                for (int j = size-1; j >=0; j--) {
                    array[j][i] = count++;
                }
            }
        }
        return array;
 }

 public static void print(int[][] array){
        for(int i=0;i<array[0].length; i++){
            for(int j=0; j<array.length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
 }
}
