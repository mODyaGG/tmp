package com.exemple.YPECProjectRESTServer.Repositorys;

import com.exemple.YPECProjectRESTServer.Entitys.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ArtifactRepository extends JpaRepository<Artifact,String> {
    @Query("FROM Artifact WHERE id_printer = ?1")
    List<Artifact> findByPrinterId(String printerId);
    @Query("FROM Artifact WHERE id_cartridge = ?1")
    List<Artifact> findByIdCartridge(String cartridgeId);
}
