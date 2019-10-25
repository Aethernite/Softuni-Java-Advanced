package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecursiveFibonacii7 {
   public static long[] F = new long[50];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<F.length; i++){
           F[i] = -1;
        }
        System.out.println(getFibonacci(n));



    }
    public static long getFibonacci(int n){
        if(n==0 || n==1){
            return 1;
        }
        if(F[n] != -1) {
        return F[n];
        }
        else {
            F[n] = getFibonacci(n - 1) + getFibonacci(n - 2);
        }
        return F[n];
        }
    }

