package Employeebook2.Homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    Set<Employee> employee = Set.of(new Employee("Aa", "Bb", 1, 1000),
            new Employee("Cc", "Dd", 1, 2000),
            new Employee("Ee", "Ff", 2, 3000));

    @Mock
    private EmployeeServiceImpl employeeServ;

    @InjectMocks
    private DepartmentServiceImpl depServ;

    @Test
    public void salaryMax() {
        when(employeeServ.getEmployees()).thenReturn(employee);
        Employee expected = employee
                .stream()
                .filter(x -> x.getDepartmentNo().equals(1))
                .max(Comparator.comparingInt(y -> y.getSalary()))
                .get();
        Employee actual = depServ.salaryMax(1);
        assertEquals(actual, expected);
        verify(employeeServ, times(1)).getEmployees();
    }

    @Test
    public void salaryMin() {
        when(employeeServ.getEmployees()).thenReturn(employee);
        Employee expected = employee
                .stream()
                .filter(x -> x.getDepartmentNo().equals(1))
                .min(Comparator.comparingInt(y -> y.getSalary()))
                .get();
        Employee actual = depServ.salaryMin(1);

        assertEquals(actual, expected);
        verify(employeeServ, times(1)).getEmployees();
    }

    @Test
    public void salarySum() {
        when(employeeServ.getEmployees()).thenReturn(employee);
        int expected = Math.toIntExact(employee
                .stream()
                .filter(x -> x.getDepartmentNo().equals(1))
                .mapToInt(y -> y.getSalary()).sum());
        int actual = depServ.salarySum(1);
        assertEquals(expected, actual);
        verify(employeeServ, times(1)).getEmployees();
    }

    @Test
    public void employeeInDepartment() {
        when(employeeServ.getEmployees()).thenReturn(employee);
        List<Employee> expected = employee
                .stream()
                .filter(x -> x.getDepartmentNo().equals(1))
                .collect(Collectors.toList());
        List<Employee> actual = depServ.employeeInDepartment(1);
        assertEquals(expected, actual);
        verify(employeeServ, times(1)).getEmployees();
    }

    @Test
    public void allEmployees() {
        when(employeeServ.getEmployees()).thenReturn(employee);
        Set<Employee> expected = employee;
        Set<Employee> actual = depServ.allEmployees();
        assertEquals(expected, actual);
        verify(employeeServ, times(1)).getEmployees();
    }
}
