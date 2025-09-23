package org.trisha.employee.EmployeeService.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.trisha.employee.EmployeeService.dto.EmployeeDto;
import org.trisha.employee.EmployeeService.entity.Employee;
import org.trisha.employee.EmployeeService.exception.ResouceNotFoundException;
import org.trisha.employee.EmployeeService.repository.EmployeeRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    @Override
    public EmployeeDto createNewEmployee(EmployeeDto dto) {
        Employee  employee =modelMapper.map(dto,Employee.class);
       return modelMapper.map(employeeRepo.save(employee),EmployeeDto.class);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
    return employeeRepo.findAll()
            .stream().map(Employee->modelMapper.map(Employee,EmployeeDto.class))
            .toList();
    }

    @Override
    public EmployeeDto getEmployeeById(Long id)  {
    Employee employee=employeeRepo.findById(id).orElseThrow(()->new ResouceNotFoundException("Employee Id Not Found :"+id));
    return modelMapper.map(employee,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto dto) {
        Employee employee=employeeRepo.findById(id).orElseThrow(()->new ResouceNotFoundException("Employee Id Not Found :"+id));
        dto.setEmpid(id);
        modelMapper.map(dto,employee);
        Employee updatedEmployee=employeeRepo.save(employee);
        return modelMapper.map(updatedEmployee,EmployeeDto.class);

    }
}
