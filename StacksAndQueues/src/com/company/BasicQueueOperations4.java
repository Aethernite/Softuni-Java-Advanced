package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class BasicQueueOperations4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);
        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Queue<Integer> queue = new LinkedList<Integer>();

        for(Integer num: list){
            queue.add(num);
        }
        for(int i=0; i<s; i++){
            queue.poll();
        }
        int min;
        try {
            min = queue.peek();
        } catch(NullPointerException e){
            min = 0;
        }
        boolean inQueue = false;
        while(queue.peek() != null){
            if(queue.peek() < min){
                min = queue.peek();
            }
            if(queue.poll() == x){
                inQueue = true;
                System.out.println(inQueue);
                return;
            }
        }
            System.out.print(min);

    }
}
