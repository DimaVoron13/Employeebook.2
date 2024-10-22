package Employeebook2.Homework;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> getListOfEmploye(Integer depId);

    int salarySum(Integer depId);

    Employee salaryMax(Integer depId);

    Employee salaryMin(Integer depId);

    Map<Integer, List<Employee>> allEmployees();
}
