package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int commands = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        ArrayDeque<Integer> trackStack = new ArrayDeque<Integer>();


        for(int i=0; i<commands;i++){
            String[] input = sc.nextLine().split("\\s+");
            switch(input[0]) {
                case "1":
                    int n = Integer.parseInt(input[1]);
                    stack.push(n);
                    if(trackStack.peek() == null || n >trackStack.peek()){
                        trackStack.push(n);
                    }
                    else{
                        trackStack.push(trackStack.peek());
                    }
                    break;
                case "2":
                    stack.pop();
                    trackStack.pop();
                    break;
                case "3":
                    System.out.println(trackStack.peek());
                    break;
            }
        }
    }
}
