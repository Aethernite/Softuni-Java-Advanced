package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Ex5Students {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Student> list = new ArrayList<Student>();
        for(int i=0; i<n; i++){
            String[] input = scanner.nextLine().split("\\s+");
            Student stud = new Student(input[0], input[1], Double.parseDouble(input[2]));
            list.add(stud);
        }

        list = list = list.stream().sorted(Comparator.comparing(Student::getGrade)).collect(Collectors.toCollection(ArrayList<Student>::new));
        Collections.reverse(list);
        for(Student stud: list){
            System.out.println(stud);
        }
    }
}
class Student{
    String fName;
    String lName;
    double grade;

    public Student(String fName, String lName, double grade) {
        this.fName = fName;
        this.lName = lName;
        this.grade = grade;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    @Override
    public String toString(){
        return this.getfName() + " " + this.getlName() + ": " + String.format("%.2f", this.getGrade());
    }
}