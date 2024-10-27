package Employeebook2.Homework;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Employee not found")
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String note) {
        super("Employee not found = " + note);
    }
}
