package com.niveisisolamento.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niveisisolamento.project.model.DetalhesPedido;

@Repository
public interface DetalhePedidoRepository extends JpaRepository<DetalhesPedido,Integer> {
    
}
