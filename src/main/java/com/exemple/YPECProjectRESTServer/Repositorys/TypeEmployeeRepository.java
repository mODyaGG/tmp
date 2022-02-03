package com.exemple.YPECProjectRESTServer.Repositorys;

import com.exemple.YPECProjectRESTServer.Entitys.TypeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeEmployeeRepository extends JpaRepository<TypeEmployee,String> {

}
