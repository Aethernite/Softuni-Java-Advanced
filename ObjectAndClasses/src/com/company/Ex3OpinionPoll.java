package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Ex3OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Person> list = new ArrayList<Person>();

        for(int i=0; i<n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Person per = new Person(input[0], Integer.parseInt(input[1]));
            list.add(per);
        }
       list = list.stream().sorted((object1, object2) -> object1.getName().compareTo(object2.getName())).collect(Collectors.toCollection(ArrayList<Person>::new));

        for(Person per: list){
            if(per.getAge()>30){
                System.out.println(per.getName() + " - " + per.getAge());
            }
        }


    }
}
class Person{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}