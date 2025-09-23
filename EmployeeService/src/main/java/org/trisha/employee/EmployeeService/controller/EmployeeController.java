package org.trisha.employee.EmployeeService.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.trisha.employee.EmployeeService.dto.EmployeeDto;
import org.trisha.employee.EmployeeService.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/auth/emp")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public EmployeeDto createNewEmployee(@RequestBody EmployeeDto dto)
    {
       return employeeService.createNewEmployee(dto);
    }

    @GetMapping("/viewall")
    public List<EmployeeDto> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id)
    {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public EmployeeDto updateEmployeeById(@PathVariable Long id,@RequestBody EmployeeDto dto)
    {
        return employeeService.updateEmployeeById(id, dto);
    }

}
