package org.trisha.employee.EmployeeService.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table
@Setter
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long empid;

    private  String firstname;
    private String lastname;
    private String email;
    private String address;
    private  Long salary;
    private Long mobileno;


}
