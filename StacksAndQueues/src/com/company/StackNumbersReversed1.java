package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class StackNumbersReversed1 {

    public static void main(String[] args) {
	ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
	Scanner scanner = new Scanner(System.in);
	String input = scanner.nextLine();
	List<Integer> ints = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

	for(Integer n: ints){
	    stack.push(n);
        }
	for(Integer n: stack){
	    System.out.print(stack.pop().toString() + " ");
    }
    }
}
