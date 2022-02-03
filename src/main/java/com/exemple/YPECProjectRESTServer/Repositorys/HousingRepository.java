package com.exemple.YPECProjectRESTServer.Repositorys;

import com.exemple.YPECProjectRESTServer.Entitys.Housing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousingRepository extends JpaRepository<Housing, String> {
}
