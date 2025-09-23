package org.trisha.employee.EmployeeService.service;

import org.trisha.employee.EmployeeService.dto.EmployeeDto;
import org.trisha.employee.EmployeeService.exception.ResouceNotFoundException;


import java.util.List;

public interface EmployeeService {

    public EmployeeDto createNewEmployee(EmployeeDto dto);

    List<EmployeeDto> getAllEmployees();

    public EmployeeDto getEmployeeById(Long id) throws ResouceNotFoundException;

    public EmployeeDto updateEmployeeById(Long id, EmployeeDto dto) throws ResouceNotFoundException;
}
