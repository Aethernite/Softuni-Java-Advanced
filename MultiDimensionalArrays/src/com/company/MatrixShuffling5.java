package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class MatrixShuffling5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int colums = Integer.parseInt(dimensions[1]);
        String[][] matrix = new String[rows][colums];
        //FILLING THE MATRIX
        for(int i=0; i<matrix.length; i++){
            String[] input = br.readLine().split("\\s+");
            for(int j=0; j<matrix[0].length; j++){
                matrix[i][j] = input[j];
            }
        }

        while(true){
            String[] input = br.readLine().split("\\s+");
            if(input[0].equals("END")){
                break;
            }else if(input[0].equals("swap") && input.length == 5) {
                int row1 = Integer.parseInt(input[1]);
                int col1 = Integer.parseInt(input[2]);
                int row2 = Integer.parseInt(input[3]);
                int col2 = Integer.parseInt(input[4]);
                try {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    print(matrix);
                } catch(ArrayIndexOutOfBoundsException e){
                    System.out.println("Invalid input!");
                }
            }else{
                System.out.println("Invalid input!");
            }
        }
    }
    public static void print(String[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
