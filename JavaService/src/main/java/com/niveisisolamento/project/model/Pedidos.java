package com.niveisisolamento.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;


import jakarta.persistence.CascadeType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long pedidoID;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn( name = "clienteID")
    private ClientesUser clienteID;
    
 
    private LocalDateTime dataPedido = LocalDateTime.now();

}
