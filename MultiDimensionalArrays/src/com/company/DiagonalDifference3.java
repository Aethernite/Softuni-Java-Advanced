package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DiagonalDifference3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];
        for(int i=0; i<n; i++){
            int[] input = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<n; j++){
                array[i][j] = input[j];
            }
        }
        System.out.println(sum(array));
    }

    public static int sum(int[][] array){
        int primary = 0;
        int secondary = 0;
        for(int i=0; i<array.length; i++){
            primary += array[i][i];
            secondary += array[i][array.length-1-i];
        }


        return Math.abs(primary - secondary);
    }
}
