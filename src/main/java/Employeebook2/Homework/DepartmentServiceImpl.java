package Employeebook2.Homework;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    Set<Employee> employees = new HashSet<>();
    private final EmployeeService serv;

    public DepartmentServiceImpl(EmployeeService serv) {
        this.serv = serv;
    }

    {
        employees.addAll(Employee.getSetEmployees());
    }

    @Override
    public List<Employee> employeeInDepartment(Integer depId) {
        List<Employee> result = serv.getListOfEmployee(employees, depId);
        return Collections.unmodifiableList(result);
    }

    @Override
    public int salarySum(Integer depId) {
        return serv.salarySum(employees, depId);
    }

    @Override
    public Employee salaryMax(Integer depId) {
        return serv.salaryMax(employees, depId);
    }

    @Override
    public Employee salaryMin(Integer depId) {
        return serv.salaryMin(employees, depId);
    }

    @Override
    public Map<Integer, List<Employee>> allEmployees() {
        return serv.allEmployees(employees);
    }
}
