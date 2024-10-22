package Employeebook2.Homework;

import org.springframework.stereotype.Repository;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

@Repository
public class EmployeeServiceImpl implements EmployeeService {

    Set<Employee> employees = new HashSet<>();

    {
        employees.add(new Employee("Андрицкая", "Светлана", 1, 20_000));
        employees.add(new Employee("Соболева", "Елена", 2, 24_000));
        employees.add(new Employee("Некрасова", "Олеся", 5, 29_000));
        employees.add(new Employee("Стяжкина", "Надежда", 4, 35_000));
        employees.add(new Employee("Лампель", "Екатерина", 4, 59_000));
        employees.add(new Employee("Смирнов", "Евгений", 1, 14_000));
        employees.add(new Employee("Леуский", "Владислав", 3, 7_000));
        employees.add(new Employee("Яковлев", "Андрей", 5, 2_000));
        employees.add(new Employee("Хохлов", "Сергей", 1, 43_000));
        employees.add(new Employee("Дудоров", "Олег", 2, 25_000));
    }

    @Override
    public List<Employee> getListOfEmploye(Integer depId) {
        List<Employee> employe = employees
                .stream()
                .filter(employee -> Objects.equals(employee.getDepartmentNo(), depId))
                .toList();
        return employe;
    }

    @Override
    public int salarySum(Integer depId) {
        int sum = 0;
        for (Employee temp : employees) {
            if (temp.getDepartmentNo() == depId) {
                sum = sum + temp.getSalary();
            }
        }
        return sum;
    }

    @Override
    public Employee salaryMax(Integer depId) {
        Employee employeeInDepartment = employees
                .stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .max(comparing(Employee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return employeeInDepartment;
    }

    @Override
    public Employee salaryMin(Integer depId) {
        Employee employeeInDepartment = employees
                .stream()
                .filter(emploee -> Objects.equals(emploee.getDepartmentNo(), depId))
                .min(comparing(Employee::getSalary))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return employeeInDepartment;
    }

    @Override
    public Map<Integer, List<Employee>> allEmployees() {
        Map<Integer, List<Employee>> temp = employees
                .stream()
                .collect(groupingBy(Employee::getDepartmentNo));
        return Collections.unmodifiableMap(temp);
    }
}
