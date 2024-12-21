package com.niveisisolamento.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.niveisisolamento.project.model.ClientesUser;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientesRepository extends JpaRepository<ClientesUser, Long>{
    
}
