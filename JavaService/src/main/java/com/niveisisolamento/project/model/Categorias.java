package com.niveisisolamento.project.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_categorias")
public class Categorias {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer categoriaID;
    private String categoria;
    private String descricao;
    
}
