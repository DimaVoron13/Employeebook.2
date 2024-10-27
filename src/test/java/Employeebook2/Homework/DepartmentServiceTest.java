package Employeebook2.Homework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {


    public static final Employee empMin = new Employee("Aa", "Bb", 1, 1000);
    public static final Employee empMax = new Employee("Cc", "Dd", 1, 2000);
    public static final Set <Employee> employee = Set.of(empMin, empMax);
    public static final int departmentId = 1;
    public static final int wrongDepartmentId = 2;
    public static final int salarySum = 3000;

    @Mock
    private EmployeeService employeeServ;

    @InjectMocks
    private DepartmentServiceImpl depServ;

    @Test
    public void salaryMax() {
        when(employeeServ.allEmployees()).thenReturn((Map<Integer, List<Employee>>) employee);
        assertEquals(empMax,depServ.salaryMax(departmentId));
        verify(employeeServ, times(1)).allEmployees();
    }

    @Test
    public void salaryMaxInEmptyList() {
        when(employeeServ.allEmployees()).thenReturn((Map<Integer, List<Employee>>) emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> depServ.salaryMax(departmentId));
    }

    @Test
    public void salaryMaxInEmptyDepartment() {
        when(employeeServ.allEmployees()).thenReturn((Map<Integer, List<Employee>>) employee);
        assertThrows(DepartmentNotFoundException.class, () -> depServ.salaryMax(wrongDepartmentId));
        verify(employeeServ, times(1)).allEmployees();
    }

    @Test
    public void salaryMin() {
        when(employeeServ.allEmployees()).thenReturn((Map<Integer, List<Employee>>) employee);
        assertEquals(empMin,depServ.salaryMax(departmentId));
        verify(employeeServ, times(1)).allEmployees();
    }

    @Test
    public void salaryMinInEmptyList() {
        when(employeeServ.allEmployees()).thenReturn((Map<Integer, List<Employee>>) emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> depServ.salaryMin(departmentId));
    }

    @Test
    public void salaryMinInEmptyDepartment() {
        when(employeeServ.allEmployees()).thenReturn((Map<Integer, List<Employee>>) employee);
        assertThrows(DepartmentNotFoundException.class, () -> depServ.salaryMin(wrongDepartmentId));
        verify(employeeServ, times(1)).allEmployees();
    }

    @Test
    public void salarySum() {
        when(employeeServ.salarySum(employee, departmentId)).thenReturn(salarySum);
        assertEquals(depServ.salarySum(departmentId), salarySum);
        verify(employeeServ, times(1)).salarySum(employee, departmentId);
    }

    @Test
    public void salarySumInEmptyList() {
        when(employeeServ.allEmployees()).thenReturn((Map<Integer, List<Employee>>) emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> depServ.salarySum(departmentId));
    }

    @Test
    public void salarySumInEmptyDepartment() {
        when(employeeServ.allEmployees()).thenReturn((Map<Integer, List<Employee>>) employee);
        assertThrows(DepartmentNotFoundException.class, () -> depServ.salarySum(wrongDepartmentId));
        verify(employeeServ, times(1)).allEmployees();
    }
}
