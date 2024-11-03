package Employeebook2.Homework;

import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Comparator.comparing;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService serv;

    public DepartmentServiceImpl(EmployeeService serv) {
        this.serv = serv;
    }

    @Override
    public int salarySum(Integer depId) {
        int result = 0;
        for (Employee temp : serv.getEmployees()) {
            if (temp.getDepartmentNo() == depId) {
                result = result + temp.getSalary();
            }
        }
        return result;
    }

    @Override
    public Employee salaryMax(Integer depId) {
        Employee employeeInDepartment = serv.getEmployees()
                .stream()
                .filter(x -> x.getDepartmentNo().equals(depId))
                .max(comparing(x -> x.getSalary()))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return employeeInDepartment;
    }

    @Override
    public Employee salaryMin(Integer depId) {
        Employee employeeInDepartment = serv.getEmployees()
                .stream()
                .filter(x -> x.getDepartmentNo().equals(depId))
                .min(comparing(x -> x.getSalary()))
                .orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
        return employeeInDepartment;
    }

    @Override
    public Set<Employee> allEmployees() {
        return serv.getEmployees();
    }

    @Override
    public List<Employee> employeeInDepartment(Integer depId) {
        List<Employee> temp = new ArrayList<>();
        for (Employee t : serv.getEmployees()) {
            if (Objects.equals(t.getDepartmentNo(), depId)) {
                temp.add(t);
            }
        }
        return Collections.unmodifiableList(temp);
    }
}
