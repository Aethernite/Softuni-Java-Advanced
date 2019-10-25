package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class PoisonousPlant10 {
    public static ArrayList<Integer> list = new ArrayList<Integer>();
    public static ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
    public static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for(int i=0;i<number; i++){
            list.add(input[i]);
        }
        System.out.println(recursion());

    }

    public static int recursion() {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i-1)){
                stack.push(i);
            }
        }
        if (stack.isEmpty()) {
            return days;
        }
        while (!stack.isEmpty()) {
            list.remove((int)stack.pop());
        }
        days++;
        return recursion();
    }
}

