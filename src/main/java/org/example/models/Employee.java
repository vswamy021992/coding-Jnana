package org.example.models;

import java.util.Objects;

public class Employee{

    private String empName;
    private String gender;
    private String city;
    private Long salary;

    public Employee(String empName, String gender, String city, Long salary){
        this.empName = empName;
        this.gender = gender;
        this.city = city;
        this.salary = salary;
    }

    public String getEmpName(){
        return empName;
    }
    public String getGender(){
        return gender;
    }

    public String getCity(){
        return city;
    }

    public Long getSalary(){
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(empName, employee.empName) && Objects.equals(gender, employee.gender) && Objects.equals(city, employee.city) && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empName, gender, city, salary);
    }
}

