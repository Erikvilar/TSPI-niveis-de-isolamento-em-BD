package com.niveisisolamento.project.service.DTO;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CriarPedidoDTO {

    private Long clienteID;
    private Integer produtoID;
    private Double valueSpent;
    private Integer quantidade;
    private Double desconto;
    private LocalDateTime dataCompra;

 

}
