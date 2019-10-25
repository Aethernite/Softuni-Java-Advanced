package StrategyPattern;

import java.util.Comparator;

public class ComparePersonByNameLength implements Comparator<Person> {

    @Override
    public int compare(Person personOne, Person personTwo) {
        int index = Integer.compare(personOne.getName().length(), personTwo.getName().length());
        return index != 0 ? index : Integer.compare(personOne.getName().toLowerCase().charAt(0),personTwo.getName().toLowerCase().charAt(0));
    }
}