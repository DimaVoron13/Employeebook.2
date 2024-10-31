package Employeebook2.Homework;

import org.springframework.stereotype.Repository;

import java.util.*;

import org.apache.commons.lang3.StringUtils;

@Repository
public class EmployeeServiceImpl implements EmployeeService {

    private final Set<Employee> empl = new HashSet<>();

    {
        empl.add(new Employee("Андрицкая", "Светлана", 1, 20_000));
        empl.add(new Employee("Соболева", "Елена", 2, 24_000));
        empl.add(new Employee("Некрасова", "Олеся", 5, 29_000));
        empl.add(new Employee("Стяжкина", "Надежда", 4, 35_000));
        empl.add(new Employee("Лампель", "Екатерина", 4, 59_000));
        empl.add(new Employee("Смирнов", "Евгений", 1, 14_000));
        empl.add(new Employee("Леуский", "Владислав", 3, 7_000));
        empl.add(new Employee("Яковлев", "Андрей", 5, 2_000));
        empl.add(new Employee("Хохлов", "Сергей", 1, 43_000));
        empl.add(new Employee("Дудоров", "Олег", 2, 25_000));
    }

    public Map<String, Employee> employees = new HashMap<>();

    {
        for (Employee temp : empl) {
            employees.put(temp.makeKey(temp), temp);
        }
    }

    @Override
    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(empl);
    }

    @Override
    public String addEmployee(String name, String secondName, int depId, int salary) {
        if (name.isEmpty() || secondName.isEmpty()) {
            throw new FirstNameOrLastNameIsEmptyException("e");
        }
        name = StringUtils.capitalize(name);
        secondName = StringUtils.capitalize(secondName);
        Employee temp = new Employee(name, secondName, depId, salary);
        String word = "";
        if (employees.containsKey(temp.makeKey(temp))) {
            throw new EmployeeAlreadyAddedException("e");
        } else {
            empl.add(temp);
            employees.put(temp.makeKey(temp), temp);
            word = "Success, сотрудник " + temp.toString() + ", id = " + temp.getDepartmentNo() + " добавлен.";
        }
        return word;
    }

    @Override
    public String findEmployee(String name, String secondName) {
        Employee e = new Employee(name, secondName, 1, 1);
        String temp = e.makeKey(e);
        if (!employees.containsKey(temp)) {
            throw new EmployeeNotExistException("ex");
        } else {
            return "Сотрудник " + name + " " + secondName + ", id = "
                    + employees.get(temp).getDepartmentNo() + " находится в штате.";
        }
    }

    @Override
    public String delEmployee(String name, String secondName) {
        Employee e = new Employee(name, secondName, 0, 0);
        String temp = e.makeKey(e);
        if (!employees.containsKey(temp)) {
            throw new EmployeeNotExistException("e");
        } else {
            employees.remove(temp);
            return "Сотрудник " + temp + " удален из списка.";
        }
    }
}
