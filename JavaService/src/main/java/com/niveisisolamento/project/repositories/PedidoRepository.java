package com.niveisisolamento.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niveisisolamento.project.model.Pedidos;
import org.springframework.stereotype.Repository;
@Repository
public interface PedidoRepository extends JpaRepository<Pedidos,Long>{
    
}
