package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class SimpleTextEdiotor8 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Command> stack = new ArrayDeque<Command>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] command = br.readLine().split("\\s+");

            switch(command[0]){
                case "1":
                    sb.append(command[1]);
                    Command append = new Command("Append", command[1]);
                    stack.push(append);
                    break;
                case "2":
                    int index = sb.length()-Integer.parseInt(command[1]);
                    String part = sb.substring(index);
                    Command delete = new Command("Delete", part);
                    sb.delete(index,sb.length());
                    stack.push(delete);
                    break;
                case "3":
                    System.out.println(sb.charAt(Integer.parseInt(command[1])-1));
                    break;
                case "4":
                    Command undo = stack.pop();
                    String type = undo.getType();
                    switch(type){
                        case "Delete":
                            sb.append(undo.getChange());
                            break;
                        case "Append":
                            int start = sb.length() - undo.getChange().length();
                            sb.delete(start, sb.length());
                            break;
                    }
                    break;
            }

        }
    }
}
 class Command{
    String type;
    String change;

     public Command(String type, String change) {
         this.type = type;
         this.change = change;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }

     public String getChange() {
         return change;
     }

     public void setChange(String change) {
         this.change = change;
     }
 }