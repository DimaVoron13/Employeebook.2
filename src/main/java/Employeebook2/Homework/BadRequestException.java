package Employeebook2.Homework;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Department not found")
public class BadRequestException extends RuntimeException {
    public BadRequestException(String note) {
        super("BadRequestException = " + note);
    }
}
