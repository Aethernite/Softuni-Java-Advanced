package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BasicStackOperations2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for(int num: list){
            stack.push(num);
        }
        for(int i=0; i<s; i++){
            stack.pop();
        }
        boolean inStack = false;
       int min;
       try {
           min = stack.peek();
       } catch(Exception e){
           min = 0;
       }
        while(stack.peek() != null){
            if(stack.peek() < min){
                min = stack.peek();
            }
            if(stack.pop() == x){
                inStack = true;
                System.out.println(inStack);
                return;
            }
        }
        System.out.println(min);

    }
}
