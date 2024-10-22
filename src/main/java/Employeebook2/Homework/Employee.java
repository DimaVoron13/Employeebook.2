package Employeebook2.Homework;

import java.util.Objects;

public class Employee {
    private String name;
    private String secondName;
    private int departmentNo;
    private int salary;

    public Employee(String name, String secondName, int departmentNo, int salary) {
        this.name = name;
        this.secondName = secondName;
        this.departmentNo = departmentNo;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.name + " " + this.secondName + ", salary " + salary + " ";
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getDepartmentNo() {
        return departmentNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String makeKey(Employee temp) {
        return (temp.getName() + temp.getSecondName()).toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee emploee = (Employee) o;
        return Objects.equals(this.name, emploee.name) &&
                Objects.equals(this.secondName, emploee.secondName) &&
                Objects.equals(this.departmentNo, emploee.departmentNo) &&
                Objects.equals(this.salary, emploee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, secondName, departmentNo, salary);
    }
}
