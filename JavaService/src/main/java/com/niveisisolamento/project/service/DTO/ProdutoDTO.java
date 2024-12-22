package com.niveisisolamento.project.service.DTO;





import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProdutoDTO {

    private Integer produtoID;
    private String produtoNome;
    private Integer categoriaID;
    private Double preco;
    private Integer unidadeEmEstoque;
    private String imagem;
    
}
