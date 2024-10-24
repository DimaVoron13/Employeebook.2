package Employeebook2.Homework;

import org.springframework.stereotype.Repository;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Repository
public class EmployeeServiceImpl implements EmployeeService {

    public List<Employee> getListOfEmployee(Set<Employee> employees, Integer depId) {
        List<Employee> emplo = employees
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentNo(), depId))
                .toList();
        return emplo;
    }

    @Override
    public int salarySum(Set<Employee> employees, Integer depId) {
        int sum = 0;
        for (Employee temp : employees) {
            if (temp.getDepartmentNo().equals(depId)) {
                sum = sum + temp.getSalary();
            }
        }
        return sum;
    }

    @Override
    public Employee salaryMax(Set<Employee> employees, Integer depId) {
        Employee employeeInDepartment = employees
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentNo(), depId))
                .max(comparing(Employee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return employeeInDepartment;
    }

    @Override
    public Employee salaryMin(Set<Employee> employees, Integer depId) {
        Employee employeeInDepartment = employees
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentNo(), depId))
                .min(comparing(Employee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return employeeInDepartment;
    }

    @Override
    public Map<Integer, List<Employee>> allEmployees(Set<Employee> employees) {
        Map<Integer, List<Employee>> temp = employees
                .stream()
                .collect(groupingBy(Employee::getDepartmentNo));
        return Collections.unmodifiableMap(temp);
    }
}
