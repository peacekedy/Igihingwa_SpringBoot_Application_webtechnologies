package com.seedbank.ingemwe.repository;

import com.seedbank.ingemwe.model.Imbuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository


    public interface ImbutoRepo extends JpaRepository<Imbuto, Integer> {

    @Query("SELECT m FROM Imbuto m WHERE m.names LIKE ?1%")
    List<Imbuto> searchByName(String searchName);
    }

