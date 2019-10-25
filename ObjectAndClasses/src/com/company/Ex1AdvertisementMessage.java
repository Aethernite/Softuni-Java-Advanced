package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Ex1AdvertisementMessage {
   static String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
   static String[] events = {"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
   static String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
   static String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<num; i++){
            genMSG();
        }
    }
    public static void genMSG(){
        int r1 = ThreadLocalRandom.current().nextInt(0, phrases.length);
        int r2 = ThreadLocalRandom.current().nextInt(0, events.length);
        int r3 = ThreadLocalRandom.current().nextInt(0, authors.length);
        int r4 = ThreadLocalRandom.current().nextInt(0, cities.length);

        System.out.println(phrases[r1] + " " + events[r2] + " " + authors[r3] + " - " + cities[r4]);

    }
}

