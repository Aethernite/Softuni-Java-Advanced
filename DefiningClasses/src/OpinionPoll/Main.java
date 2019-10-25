package OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("\\s+");
            Person person = new Person(input[0],Integer.parseInt(input[1]));
            list.add(person);
        }

        list = list.stream().filter(e -> e.getAge() > 30).sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
        for(Person p: list){
            System.out.println(p.getName() + " - " + p.getAge());
        }
    }
}


