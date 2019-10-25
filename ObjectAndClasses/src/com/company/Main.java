package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int n = Integer.parseInt(scanner.nextLine());
        ArrayList<Employee> list = new ArrayList<Employee>();
	for(int i=0; i<n; i++){
	    String[] input = scanner.nextLine().split("\\s+");
        Employee emp = new Employee(input[0],Double.parseDouble(input[1]), input[2] + " " + input[3], input[4]);
        if(input.length==6){
            emp.setAge(Integer.parseInt(input[5]));
        }
        list.add(emp);
    }
	print(highestSalaryDep(list),list);


    }


    public static String highestSalaryDep(ArrayList<Employee> list) {
        double highestSalary = list.get(0).getSalary();
        Employee ob = list.get(0);
        for (Employee emp : list) {
            if (emp.getSalary() > highestSalary) {
                highestSalary = emp.getSalary();
                ob = emp;
            }
        }
        String[] dep = ob.getDepartment().split("\\s+");
        System.out.println("Highest Average Salary: " + dep[1]);
        return dep[1];
    }


    public static void print(String dep, ArrayList<Employee> list){
        boolean has = false;
        for(Employee ob: list){
            String[] department1 = ob.getDepartment().split("\\s+");
            if(department1[1].equals(dep)){
                has = true;
            }
        }
        if(!has){
            return;
        }
        double highestSalary = Double.MIN_VALUE;
        Employee obHS = new Employee();
        for(Employee ob: list){
           String[] department = ob.getDepartment().split("\\s+");
           if(department[1].equals(dep)){
               if(ob.getSalary()>highestSalary){
                   highestSalary = ob.getSalary();
                   obHS = ob;

               }
           }
        }
        System.out.print(obHS.getName() +" "+ obHS.getSalary()  +" "+ obHS.getEmail() + " " + obHS.getAge());
        System.out.println();
        list.remove(obHS);
        print(dep,list);
    }
}
 class Employee {
    String name;
    double salary;
    int age = -1;
    String department;
    String email = "n/a";
    public Employee(){

    }

    public Employee(String name, double salary, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.department = department;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
