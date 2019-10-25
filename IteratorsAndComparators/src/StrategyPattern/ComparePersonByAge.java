package StrategyPattern;

import java.util.Comparator;

public class ComparePersonByAge implements Comparator<Person> {


    public ComparePersonByAge(){}
    @Override
    public int compare(Person personOne, Person personTwo) {
        return personOne.getAge() - personTwo.getAge();
    }
}