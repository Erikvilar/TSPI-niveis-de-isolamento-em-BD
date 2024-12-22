package com.niveisisolamento.project.controller.MetodoOtimista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalhePedidoOtimistaRepository extends JpaRepository<DetalhesPedidoOtimista,Integer> {
    
}
