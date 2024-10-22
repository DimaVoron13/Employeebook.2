package Employeebook2.Homework;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    List<Employee> employeeInDepartment(Integer depId);

    int salarySum(Integer depId);

    Employee salaryMax(Integer depId);

    Employee salaryMin(Integer depId);

    Map<Integer, List<Employee>> allEmployees();
}
