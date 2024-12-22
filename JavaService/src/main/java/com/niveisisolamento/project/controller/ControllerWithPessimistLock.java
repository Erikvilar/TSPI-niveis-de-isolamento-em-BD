package com.niveisisolamento.project.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niveisisolamento.project.service.CriarCliente;
import com.niveisisolamento.project.service.ServicePedidos;
import com.niveisisolamento.project.service.DTO.ClienteDTO;
import com.niveisisolamento.project.service.DTO.CriarPedidoDTO;
import com.niveisisolamento.project.service.DTO.ProdutoDTO;
import com.niveisisolamento.project.service.ServicoPessimista.ServicePedidosPessimista;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@CrossOrigin(origins= "*")
@RestController
@RequestMapping("pedido_pessimista")
@RequiredArgsConstructor
public class ControllerWithPessimistLock {
   private final ServicePedidosPessimista servicePedidosPessimista;

   private final ServicePedidos servicePedidos;

    private final CriarCliente criarCliente;

    @PostMapping("/novo")
    public ResponseEntity<?> criarPedido(@RequestBody CriarPedidoDTO criarPedidoDTO) {
        return servicePedidosPessimista.CriarPedido(criarPedidoDTO);
    }

    // CENARIO DE TESTE DE ENDPOINT DE PRODUTOS
    @PostMapping("/produto")
    public ResponseEntity<String> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return servicePedidos.cadastrarProduto(produtoDTO);
    }

    @PostMapping("/cliente")
    public ResponseEntity<String> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        return criarCliente.criarCliente(clienteDTO);
    }

}
