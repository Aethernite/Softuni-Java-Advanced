package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximalSum4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        int[][] array = new int[r][c];
        for(int i=0; i<r; i++){
            int[] row = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for(int j=0; j<c; j++){
                array[i][j] = row[j];
            }
        }

       maxSum(array);
    }

    public static void maxSum(int[][] array){
        int bestSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol= 0;

        for(int row=0; row<array.length-2;row++){
            for(int col=0; col<array[row].length - 2; col++){
                int sum = array[row][col] + array[row][col+1] + array[row][col+2] +
                        array[row + 1][col] + array[row+1][col+1] + array[row+1] [col+2]+
                        array[row + 2][col] + array[row+2][col+1] + array[row+2][col+2];

                if (sum > bestSum) {
                    bestSum = sum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }
        System.out.println("Sum = " + bestSum);

        for(int i=resultRow, count=0; count != 3; i++,count++){
            for(int j=resultCol, count2=0; count2 !=3; j++,count2++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
