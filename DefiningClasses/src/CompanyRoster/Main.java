package CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedHashMap<String, Department> map = new LinkedHashMap<>();
        ArrayList<Employee> list;
        for(int i=0; i<n; i++){
            String[] input = br.readLine().split("\\s+");
            Employee emp;
            if(input.length == 6) {
                emp = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4], Integer.parseInt(input[5]));
            }else if(input.length == 5) {
                int age = -1;
                boolean isWithEmail = false;
                try {
                    age = Integer.parseInt(input[4]);
                } catch(Exception e){
                    isWithEmail = true;
                }
                if(isWithEmail) {
                    emp = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4], age);
                }else{
                    emp = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], null, age);
                }
            }
            else{
                emp = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], null, -1);
            }
                String department = emp.getDepartment();
                if(!map.containsKey(department)){
                    Department dep = new Department(department);
                    dep.addEmployee(emp);
                    map.put(department, dep);
                }else{
                    Department dep = map.get(department);
                    dep.addEmployee(emp);
                    map.put(department,dep);
                }
            }

        ArrayList<Department> listDeps = new ArrayList<>();
        map.forEach((k,v) ->{
           listDeps.add(v);
        });
        String highPayedDepartment = listDeps.get(0).getDepartment();
        double max = listDeps.get(0).highestAvgSalary();
        for(Department dep: listDeps){
            if(dep.highestAvgSalary() > max){
                max = dep.highestAvgSalary();
                highPayedDepartment = dep.getDepartment();
            }
        }
        list = map.get(highPayedDepartment).getList();
        list.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(list);
        System.out.println("Highest Average Salary: " + highPayedDepartment);
        for(Employee emp: list){
            System.out.println(String.format("%s %.2f %s %d", emp.getName(), emp.getSalary(), emp.getEmail(), emp.getAge()));
        }



        }
    }
