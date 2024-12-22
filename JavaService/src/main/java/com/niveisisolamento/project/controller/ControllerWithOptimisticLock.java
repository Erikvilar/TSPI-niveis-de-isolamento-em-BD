package com.niveisisolamento.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niveisisolamento.project.service.CriarCliente;
import com.niveisisolamento.project.service.DTO.ClienteDTO;
import com.niveisisolamento.project.service.DTO.CriarPedidoDTO;
import com.niveisisolamento.project.service.DTO.ProdutoDTO;
import com.niveisisolamento.project.service.servicoOtimista.ServicePedidosOtimista;

import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("pedido_otimista")
@RequiredArgsConstructor
public class ControllerWithOptimisticLock {

      private final ServicePedidosOtimista servicePedidosOtimista;

      private final CriarCliente criarCliente;
    

    @PostMapping("/novo")
    public ResponseEntity<?> criarPedido(@RequestBody CriarPedidoDTO criarPedidoDTO) {
        return servicePedidosOtimista.CriarPedido(criarPedidoDTO);
    }

    @PostMapping("/produto")
    public ResponseEntity<String> cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        return servicePedidosOtimista.cadastrarProduto(produtoDTO);
    }
       @PostMapping("/cliente")
    public ResponseEntity<String> criarCliente(@RequestBody ClienteDTO clienteDTO) {
        return criarCliente.criarCliente(clienteDTO);
    }
}
