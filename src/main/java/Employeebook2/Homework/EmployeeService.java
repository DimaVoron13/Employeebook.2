package Employeebook2.Homework;

import java.util.*;

public interface EmployeeService {

    String addEmployee(String name, String secondName, int depId, int salary);

    String delEmployee(String name, String secondName);

    String findEmployee(String name, String secondName);

    Set<Employee> getEmployees();
}
