package com.niveisisolamento.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niveisisolamento.project.model.Categorias;
@Repository
public interface CategoriaRepository extends JpaRepository<Categorias, Integer> {
    
}
