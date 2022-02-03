package com.exemple.YPECProjectRESTServer.Repositorys;

import com.exemple.YPECProjectRESTServer.Entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
