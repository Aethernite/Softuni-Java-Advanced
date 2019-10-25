package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex7OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Persona> list = new ArrayList<Persona>();
        while(true){
            String[] input = scanner.nextLine().split("\\s+");
            if(input[0].toLowerCase().equals("end")){
                break;
            }
            Persona per = new Persona(input[0], input[1], Integer.parseInt(input[2]));
            list.add(per);
        }
        list = list = list.stream().sorted(Comparator.comparing(Persona::getAge)).collect(Collectors.toCollection(ArrayList<Persona>::new));
        for(Persona per: list){
            System.out.println(per);
        }
    }
}


class Persona{
    String name;
    String id;
    int age;
    @Override
    public String toString(){
        return String.format("%s with ID: %s is %d years old.",this.name, this.id, this.age);
    }
    public Persona(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
