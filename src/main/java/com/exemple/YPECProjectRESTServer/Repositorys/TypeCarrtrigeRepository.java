package com.exemple.YPECProjectRESTServer.Repositorys;

import com.exemple.YPECProjectRESTServer.Entitys.TypeCartridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCarrtrigeRepository extends JpaRepository<TypeCartridge,String> {
}
