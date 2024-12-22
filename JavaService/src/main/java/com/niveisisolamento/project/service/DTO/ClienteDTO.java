package com.niveisisolamento.project.service.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class ClienteDTO {

    
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
