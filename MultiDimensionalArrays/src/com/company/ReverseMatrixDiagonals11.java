package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ReverseMatrixDiagonals11 {
    public static int R,C;
    public static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split("\\s");
        R = Integer.parseInt(dimensions[0]);
        C = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[R][C];
        //FILLING THE MATRIX
        for(int i=0; i<matrix.length; i++){
            String[] input = br.readLine().split("\\s+");
            for(int j=0; j<matrix[0].length; j++){
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }

        printMatrixDiagonals(matrix);
        Collections.reverse(list);
        for(String str: list){
            System.out.println(str);
        }


    }
    public static void printMatrixDiagonals(int[][] matrix) {
        int c = 0;
        int count = matrix.length + matrix[0].length -1;
        int i = 0, j = 0;
        //There can be at most  m + n -1 diagonals to be printed
        while (c < count) {
            //Start printing diagonals from i and j
            printDiagonal(i, j, matrix);
            if (i < matrix.length -1) {
                //We increment row index until we reach the max number of rows
                i++;
            } else if (j < matrix[0].length - 1) {
                //We are at maximum index of row; so its time to increment col index
                //We increment column index until we reach the max number of columns
                j++;
            }
            c++;
        }
    }
    private static void printDiagonal(int i, int j, int[][] m) {
        StringBuilder sb = new StringBuilder();
        while (i >=0 && j< m[0].length ) {
            sb.append(m[i][j] + " ");
            //System.out.print(m[i][j] + " ");
            i--;
            j++;
        }
        //System.out.println("");
        list.add(sb.toString());
    }

}