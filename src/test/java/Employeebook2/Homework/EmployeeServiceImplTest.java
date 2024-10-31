package Employeebook2.Homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    private EmployeeServiceImpl emplServ = new EmployeeServiceImpl();

    Employee empl = new Employee("Ee", "Ff", 1, 3000);

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void addEmployee() {
        String expected = "Success, сотрудник " + empl.toString() + ", id = " + empl.getDepartmentNo() + " добавлен.";
        String actual = emplServ.addEmployee(empl.getName(), empl.getSecondName(), 1, 3000);
        assertEquals(expected, actual);
        assertThrows(FirstNameOrLastNameIsEmptyException.class,
                () -> emplServ.addEmployee("", "", 1, 0),
                "FirstNameOrLastNameException");
    }

    @Test
    public void delEmployee() {
        assertThrows(EmployeeNotExistException.class,
                () -> emplServ.delEmployee("Aa", "Bb"),
                "EmployeeNotExistException");
    }

    @Test
    public void findEmployee() {
        Employee emp = new Employee("Ivanov", "Ivan", 1, 1);
        String expected = "Сотрудник " + emp.getName() + " " + emp.getSecondName()
                + ", id = " + emp.getDepartmentNo() + " находится в штате.";
        String actual = emplServ.findEmployee(emp.getName(), emp.getSecondName());
        assertEquals(expected, actual);
        assertThrows(EmployeeNotExistException.class,
                () -> emplServ.findEmployee("Aa", "Bb"),
                "EmployeeNotExistException");
    }
}
