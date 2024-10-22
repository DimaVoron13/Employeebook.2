package Employeebook2.Homework;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    Set<String> employee = new HashSet<>();
    private final EmployeeService serv;

    public DepartmentServiceImpl(EmployeeService serv) {
        this.serv = serv;
    }

    @Override
    public List<Employee> employeeInDepartment(Integer depId) {
        List<Employee> result = serv.getListOfEmploye(depId);
        return Collections.unmodifiableList(result);
    }

    @Override
    public int salarySum(Integer depId) {
        return serv.salarySum(depId);
    }

    @Override
    public Employee salaryMax(Integer depId) {
        return serv.salaryMax(depId);
    }

    @Override
    public Employee salaryMin(Integer depId) {
        return serv.salaryMin(depId);
    }

    @Override
    public Map<Integer, List<Employee>> allEmployees() {
        return serv.allEmployees();
    }
}
