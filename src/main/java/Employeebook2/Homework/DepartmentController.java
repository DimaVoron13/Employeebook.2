package Employeebook2.Homework;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    public final DepartmentService serv;

    public DepartmentController(DepartmentService serv) {
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
}
