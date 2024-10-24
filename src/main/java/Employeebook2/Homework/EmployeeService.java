package Employeebook2.Homework;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface EmployeeService {
    List<Employee> getListOfEmployee(Set<Employee> employees, Integer depId);

    int salarySum(Set<Employee> employees, Integer depId);

    Employee salaryMax(Set<Employee> employees, Integer depId);

    Employee salaryMin(Set<Employee> employees, Integer depId);

    Map<Integer, List<Employee>> allEmployees(Set<Employee> employees);
}
