package org.trisha.employee.EmployeeService.advise;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
public class ApiError {

    private LocalDate date;
    private String message;
    private HttpStatus status;

    public ApiError()
    {
        date=LocalDate.now();
    }
    public ApiError(String message, HttpStatus status)
    {
        this();
        this.message=message;
        this.status=status;
    }
}
