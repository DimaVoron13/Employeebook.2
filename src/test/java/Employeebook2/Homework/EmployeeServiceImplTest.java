package Employeebook2.Homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

public class EmployeeServiceImplTest {
    private EmployeeServiceImpl serv = new EmployeeServiceImpl();
    Set<Employee> employees = new HashSet<>();
    Employee emp1;
    Employee emp2;

    @BeforeEach
    public void setUp() {
        emp1 = new Employee("Aaa", "Bbb", 1, 1000);
        emp2 = new Employee("Ccc", "Ddd", 1, 2000);
        employees.add(emp1);
        employees.add(emp2);
    }

    @Test
    @DisplayName("Correct sum")
    public void salarySum() {
        int expected = emp1.getSalary() + emp2.getSalary();
        int actual = serv.salarySum(employees, emp1.getDepartmentNo());
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Correct max")
    public void salaryMax() {
        int expected;
        if (emp1.getSalary() > emp2.getSalary()) {
            expected = emp1.getSalary();
        } else {
            expected = emp2.getSalary();
        }
        int actual = serv.salaryMax(employees, emp1.getDepartmentNo()).getSalary();
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Correct min")
    public void salaryMin() {
        int expected;
        if (emp1.getSalary() > emp2.getSalary()) {
            expected = emp2.getSalary();
        } else {
            expected = emp1.getSalary();
        }
        int actual = serv.salaryMin(employees, emp1.getDepartmentNo()).getSalary();
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Correct getListOfEmploee")
    public void getListOfEmploee() {
        List<Employee> actual = new ArrayList<>(List.of(emp2, emp1));
        List<Employee> expected = serv.getListOfEmployee(employees, emp1.getDepartmentNo());
        assertTrue(expected.contains(emp1));
        assertTrue(expected.contains(emp2));
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Correct allEmployees")
    public void allEmployees() {
        Employee emp3 = new Employee("Eee", "Fff", 2, 3000);
        Map<Integer, List<Employee>> actual = new HashMap<>();
        List<Employee> listOfEmpl = new ArrayList<>();
        listOfEmpl.add(emp2);
        listOfEmpl.add(emp1);
        actual.put(1, listOfEmpl);
        listOfEmpl = new ArrayList<>();
        listOfEmpl.add(emp3);
        actual.put(2, listOfEmpl);
        employees.add(emp3);
        Map<Integer, List<Employee>> expected = serv.allEmployees(employees);
        assertEquals(actual, expected);
    }
}
