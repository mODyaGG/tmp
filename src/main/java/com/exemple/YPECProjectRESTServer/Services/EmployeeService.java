package com.exemple.YPECProjectRESTServer.Services;

import com.exemple.YPECProjectRESTServer.Entitys.Employee;
import com.exemple.YPECProjectRESTServer.Entitys.TypeEmployee;
import com.exemple.YPECProjectRESTServer.Repositorys.EmployeeRepository;
import com.exemple.YPECProjectRESTServer.Repositorys.TypeEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final TypeEmployeeRepository typeEmployeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository, TypeEmployeeRepository typeEmployeeRepository) {
        this.employeeRepository = employeeRepository;
        this.typeEmployeeRepository = typeEmployeeRepository;
    }

    public List<Employee> all(){
        return employeeRepository.findAll();
    }

    public HttpStatus addEmployee(Employee employee) {
        TypeEmployee typeEmployee = this.typeEmployeeRepository.findById(employee.getTypeEmployee().getId_type()).orElse(null);
        if(typeEmployee != null){
            employee.setTypeEmployee(typeEmployee);
            employeeRepository.save(employee);
            return HttpStatus.OK;
        }
        else
            return HttpStatus.CONFLICT;
    }
    public HttpStatus edit(Employee employee){
        try {
            employeeRepository.save(employee);
            return HttpStatus.OK;
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            return HttpStatus.CONFLICT;
        }
    }
    public HttpStatus delete(Employee employee){
        try {
            employeeRepository.deleteById(employee.getEmail());
            return HttpStatus.OK;
        }
        catch (RuntimeException ex){
            System.out.println(ex.getMessage());
            return HttpStatus.CONFLICT;
        }
    }
}
