package MakeASalad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> products = new ArrayDeque<Integer>();
        ArrayDeque<Integer> salads = new ArrayDeque<Integer>();
        String[] input = br.readLine().split("\\s+");

        ArrayList<Integer> output = new ArrayList<Integer>();

        for(String str: input){
            switch(str) {
                case "tomato":
                    products.add(80);
                    break;
                case "potato":
                    products.add(215);
                    break;
                case "lettuce":
                    products.add(109);
                    break;
                case "carrot":
                    products.add(136);
                    break;
            }
            }


        String[] input2 = br.readLine().split("\\s+");


        for(String str: input2){
            salads.add(Integer.parseInt(str));
        }


        while(!salads.isEmpty() && !products.isEmpty()){
            int calories = salads.peekLast();
            while(calories>0 && !products.isEmpty()) {
                int product = products.pollFirst();
                calories -= product;
            }
            output.add(salads.pollLast());
            }


        if(salads.isEmpty()) {
            for (Integer n : output) {
                System.out.print(n + " ");
            }
            System.out.println();
            for (Integer n : products) {
                switch (n) {
                    case 80:
                        System.out.print("tomato ");
                        break;
                    case 136:
                        System.out.print("carrot ");
                        break;
                    case 215:
                        System.out.print("potato ");
                        break;
                    case 109:
                        System.out.print("lettuce ");
                        break;
                }
            }
        }
        else{
            for(Integer n: output){
                System.out.print(n + " ");
            }
            System.out.println();
            while(!salads.isEmpty()){
                System.out.print(salads.pollLast() + " ");
            }
        }



    }
}
