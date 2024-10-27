package Employeebook2.Homework;

import java.util.*;

public interface EmployeeService {

    Set<Employee> getSetEmployees();

    List<Employee> getListOfEmployee(Set<Employee> employees, Integer depId);

    int salarySum(Set<Employee> employees, Integer depId);

    Employee salaryMax(Set<Employee> employees, Integer depId);

    Employee salaryMin(Set<Employee> employees, Integer depId);

    Map<Integer, List<Employee>> allEmployees();
}
