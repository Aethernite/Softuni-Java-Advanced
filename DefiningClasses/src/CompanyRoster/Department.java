package CompanyRoster;

import java.util.ArrayList;

public class Department {
    String department;
    ArrayList<Employee> list = new ArrayList<>();

    public Department(String department){
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public ArrayList<Employee> getList() {
        return list;
    }

    public void setList(ArrayList<Employee> list) {
        this.list = list;
    }

    public void addEmployee(Employee e){
        list.add(e);
    }

    public double highestAvgSalary(){
        double sum = 0;
        for(Employee e: list){
            sum+=e.getSalary();
        }
        return sum/list.size();
    }

}
