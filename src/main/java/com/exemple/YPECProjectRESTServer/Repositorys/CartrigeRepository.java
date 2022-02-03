package com.exemple.YPECProjectRESTServer.Repositorys;

import com.exemple.YPECProjectRESTServer.Entitys.Cartridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartrigeRepository extends JpaRepository<Cartridge,String> {
    @Query("FROM Cartridge WHERE id_status IN ('INSTOCK','INACTIVE')")
    List<Cartridge> findActivePrinter();
}
