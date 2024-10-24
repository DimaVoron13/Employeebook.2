package Employeebook2.Homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    Employee emp1 = new Employee("Aa", "Bb", 1, 1000);
    Employee emp2 = new Employee("Cc", "Dd", 1, 2000);
    Set<Employee> employee = new HashSet<>();

    @Mock
    private EmployeeServiceImpl employeeServ;

    @InjectMocks
    private DepartmentServiceImpl depServ;

    @Test
    public void salaryMax() {
        employee = Set.of(emp1, emp2);
        when(depServ.salaryMax(1)).thenReturn(emp2);
        assertEquals(employeeServ.salaryMax(employee, 1), emp2);
    }

    @Test
    public void salaryMin() {
        when(employeeServ.salaryMin(employee, 1)).thenReturn(emp1);
        assertEquals(employeeServ.salaryMin(employee, 1), emp1);
        verify(employeeServ, times(1)).salaryMin(employee, 1);
    }

    @Test
    public void salarySum() {
        employee = Set.of(emp1, emp2);
        when(employeeServ.salarySum(employee, 1)).thenReturn(3000);
        assertEquals(employeeServ.salarySum(employee, 1), 3000);
        verify(employeeServ, times(1)).salarySum(employee, 1);
    }
}
