package com.niveisisolamento.project.service.ServicoPessimista;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.niveisisolamento.project.model.ClientesUser;
import com.niveisisolamento.project.model.DetalhesPedido;
import com.niveisisolamento.project.model.Pedidos;
import com.niveisisolamento.project.model.Produto;
import com.niveisisolamento.project.repositories.ClientesRepository;
import com.niveisisolamento.project.repositories.DetalhePedidoRepository;
import com.niveisisolamento.project.repositories.PedidoRepository;
import com.niveisisolamento.project.repositories.pessimist.ProdutoPessimistaRespository;
import com.niveisisolamento.project.service.DTO.CriarPedidoDTO;
import com.niveisisolamento.project.service.DTO.DetalhePedidoDTO;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicePedidosPessimista {

    private final PedidoRepository pedidoRepository;
    private final ClientesRepository clientesRepository;
    private final ProdutoPessimistaRespository produtoRespository;
    private final DetalhePedidoRepository detalhePedidoRepository;

    public ResponseEntity<?> CriarPedido(CriarPedidoDTO criarPedidoDTO) {

        ClientesUser cliente = clientesRepository.findById(criarPedidoDTO.getClienteID()).get();

        Produto produto = produtoRespository.findById(criarPedidoDTO.getProdutoID()).get();

        // Criando pedido vinculando cliente
        Pedidos pedido = new Pedidos();
        pedido.setClienteID(cliente);

        DetalhesPedido detalhesPedido = new DetalhesPedido();
        detalhesPedido.setPedidoID(pedido);
        detalhesPedido.setProdutoID(produto);

        // Essa implementação ficou meio "go horse mas e ideia e essa"
        Double valorDeVenda = (criarPedidoDTO.getQuantidade() * produto.getPreco());

        detalhesPedido.setPrecoVenda(valorDeVenda);
        int quantidadeRestante = produto.getUnidadeEmEstoque() - criarPedidoDTO.getQuantidade();
        if (quantidadeRestante < 0) {
            log.info("quantidade esgotada");
            return new ResponseEntity<>("PRODUTO ESGOTADO", HttpStatus.CONFLICT);
        }
        log.info("QUANTIDADE RESTANTE {} CLIENTE {} COMPRPOU \\n" + //
        " ( {} vezes ){} ID {}", quantidadeRestante, cliente.getNome(), criarPedidoDTO.getQuantidade(), produto.getProdutoNome(), produto.getProdutoID());
        detalhesPedido.setQuantidade(quantidadeRestante);
        produto.setUnidadeEmEstoque(quantidadeRestante);
        detalhesPedido.setDesconto(criarPedidoDTO.getDesconto());

        pedidoRepository.save(pedido);
        detalhePedidoRepository.save(detalhesPedido);
        DetalhePedidoDTO detalhePedidoDTO = new DetalhePedidoDTO();
        return new ResponseEntity<>(detalhePedidoDTO.toDTO(detalhesPedido), HttpStatus.CREATED);

    }



}
