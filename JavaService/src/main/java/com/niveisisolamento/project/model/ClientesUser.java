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
@Table(name = "tb_clientes")
public class ClientesUser {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long clienteID;
    private String nome;
    private String cargo;
    private String endereco;
    private String cidade;
    private String cep;
    private String pais;
    private String telefone;
    private String fax;

}
