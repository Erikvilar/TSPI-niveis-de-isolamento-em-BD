package com.niveisisolamento.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niveisisolamento.project.model.Produto;
import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoRespository extends JpaRepository<Produto, Integer> {
    

    
}
