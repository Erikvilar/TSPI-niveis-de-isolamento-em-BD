package com.niveisisolamento.project.repositories.pessimist;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import com.niveisisolamento.project.model.Produto;

import jakarta.persistence.LockModeType;


import org.springframework.stereotype.Repository;
@Repository
public interface ProdutoPessimistaRespository extends JpaRepository<Produto, Integer> {
    


    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Produto> findById(Integer produtoID);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Produto save(Produto produto);

}
