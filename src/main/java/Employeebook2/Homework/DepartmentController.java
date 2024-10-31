package Employeebook2.Homework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    public final EmployeeService employeeServ;
    public final DepartmentService serv;

    public DepartmentController(EmployeeService employeeServ, DepartmentService serv) {
        this.employeeServ = employeeServ;
        this.serv = serv;
    }

    @GetMapping("/{depId}/employees")
    public String employeeInDepartment(@PathVariable Integer depId) {
        return "List of employees in dep# " + depId + " = " + serv.employeeInDepartment(depId).toString();
    }

    @GetMapping("/{depId}/salary/sum")
    public String salarySum(@PathVariable Integer depId) {
        return "Sum of salary in dep# " + depId + " = " + serv.salarySum(depId);
    }

    @GetMapping("/{depId}/salary/max")
    public String salaryMax(@PathVariable Integer depId) {
        return "Max salary in dep# " + depId + " = " + serv.salaryMax(depId).toString();
    }

    @GetMapping("/{depId}/salary/min")
    public String salaryMin(@PathVariable Integer depId) {
        return "Min salary in dep# " + depId + " = " + serv.salaryMin(depId).toString();
    }

    @GetMapping("/employees")
    public String allEmployees() {
        return "All employees = " + serv.allEmployees().toString();
    }

    @GetMapping("/add")
    public String addPerson(@RequestParam("firstName") String Name,
                            @RequestParam("lastName") String secondName,
                            @RequestParam("depId") int depId,
                            @RequestParam("salary") int salary) {
        try {
            return employeeServ.addEmployee(Name, secondName, depId, salary);
        } catch (EmployeeAlreadyAddedException e) {
            return "Такой сотрудник уже существует.";
        } catch (FirstNameOrLastNameIsEmptyException e) {
            return "firstName or lastName is empty";
        } catch (BadRequestException e) {
            return "400BadRequestException";
        }
    }

    @GetMapping("/del")
    public String delPerson(@RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName) {
        try {
            return employeeServ.delEmployee(firstName, lastName);
        } catch (EmployeeNotExistException e) {
            return "Такого сотрудника в штате нет.";
        }
    }

    @GetMapping("/find")
    public String findPerson(@RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName) {
        try {
            return employeeServ.findEmployee(firstName, lastName);
        } catch (EmployeeNotExistException e) {
            return "Такого сотрудника в штате нет.";
        }
    }

    @GetMapping("/list")
    public Set listEmployee() {
        return employeeServ.getEmployees();
    }
}
