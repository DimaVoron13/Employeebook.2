package Employeebook2.Homework;

import java.util.List;
import java.util.Set;

public interface DepartmentService {
    List<Employee> employeeInDepartment(Integer depId);

    int salarySum(Integer depId);

    Employee salaryMax(Integer depId);

    Employee salaryMin(Integer depId);

    Set<Employee> allEmployees();
}
