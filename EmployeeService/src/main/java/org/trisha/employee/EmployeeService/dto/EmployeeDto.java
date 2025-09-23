package org.trisha.employee.EmployeeService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class EmployeeDto {
    private  long empid;

    private  String firstname;
    private String lastname;
    @Email(message = "Invalid Email Format")
    @NotNull(message = "Please, Enter the Email")
    private String email;
    private String address;
    private  Long salary;
    @NotNull(message = "Please,Enter the Phone Number")
    @Size(min=10,max = 12,message = "Please, Enter the valid Phone Number")
    private Long mobileno;
}
