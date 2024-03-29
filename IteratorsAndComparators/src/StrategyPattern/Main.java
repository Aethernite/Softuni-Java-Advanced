package StrategyPattern;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static BufferedReader reader;
    private static Set<Person> sortedByNameLength;
    private static Set<Person> sortedByAge;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        sortedByNameLength = new TreeSet<Person>(new ComparePersonByNameLength());
        sortedByAge = new TreeSet<Person>(new ComparePersonByAge());
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            sortedByNameLength.add(person);
            sortedByAge.add(person);
        }

        sortedByNameLength.forEach(System.out::println);
        sortedByAge.forEach(System.out::println);
    }
}