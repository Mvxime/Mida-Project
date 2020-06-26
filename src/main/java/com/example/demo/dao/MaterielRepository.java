package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Materiel;

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long>{

}
