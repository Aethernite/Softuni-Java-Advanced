package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BalancedParenthesis6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] array = input.toCharArray();
        int size = array.length;
        boolean balanced = true;
       ArrayDeque<Character> stack = new ArrayDeque<Character>();
       for(int i=0; i<array.length;i++){
           switch(array[i]){
               case '{':
               case '[':
               case '(':
                   stack.push(array[i]);
                   break;
               case '}':
               case ']':
               case ')':
                 if(stack.isEmpty()) {
                     balanced = false;
                     break;
                 }
                 if(array[i] == ')' && stack.peek() == '(' || array[i] == ']' && stack.peek() == '[' || array[i] == '}' && stack.peek() == '{') {
                     stack.poll();
                     break;
                 }else{
                     balanced = false;
                 }
           }
       }
       if(balanced){
           System.out.print("YES");
       }else{
           System.out.print("NO");
       }
    }
}
