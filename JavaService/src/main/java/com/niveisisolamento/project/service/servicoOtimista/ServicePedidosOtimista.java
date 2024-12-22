package com.niveisisolamento.project.service.servicoOtimista;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niveisisolamento.project.controller.MetodoOtimista.DetalhePedidoOtimistaRepository;
import com.niveisisolamento.project.controller.MetodoOtimista.DetalhesPedidoOtimista;
import com.niveisisolamento.project.controller.MetodoOtimista.ProdutoOtimista;
import com.niveisisolamento.project.controller.MetodoOtimista.ProdutoOtimistaRepository;
import com.niveisisolamento.project.model.ClientesUser;
import com.niveisisolamento.project.model.Pedidos;
import com.niveisisolamento.project.repositories.ClientesRepository;
import com.niveisisolamento.project.repositories.PedidoRepository;
import com.niveisisolamento.project.service.DTO.CriarPedidoDTO;
import com.niveisisolamento.project.service.DTO.DetalhePedidoOtimistaDTO;
import com.niveisisolamento.project.service.DTO.ProdutoDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicePedidosOtimista {

    private final PedidoRepository pedidoRepository;
    private final ClientesRepository clientesRepository;
    private final ProdutoOtimistaRepository produtoOtimistaRepository;
    private final DetalhePedidoOtimistaRepository detalhePedidoOtimistaRepository;

    @Transactional
    public ResponseEntity<?> CriarPedido(CriarPedidoDTO criarPedidoDTO) {

        ClientesUser cliente = clientesRepository.findById(criarPedidoDTO.getClienteID()).get();

        ProdutoOtimista produto = produtoOtimistaRepository.findById(criarPedidoDTO.getProdutoID()).get();
        // Criando pedido vinculando cliente
        Pedidos pedido = new Pedidos();
        pedido.setClienteID(cliente);

        DetalhesPedidoOtimista detalhesPedido = new DetalhesPedidoOtimista();
        detalhesPedido.setPedidoID(pedido);
        detalhesPedido.setProdutoID(produto);

        // Essa implementação ficou meio "go horse mas e ideia e essa"
        Double valorDeVenda = (criarPedidoDTO.getQuantidade() * produto.getPreco());

        detalhesPedido.setPrecoVenda(valorDeVenda);
        int quantidadeRestante = produto.getUnidadeEmEstoque() - criarPedidoDTO.getQuantidade();
        if (quantidadeRestante < 0) {
            return new ResponseEntity<>("PRODUTO ESGOTADO", HttpStatus.CONFLICT);
        }

        detalhesPedido.setQuantidade(quantidadeRestante);
        produto.setUnidadeEmEstoque(quantidadeRestante);
        detalhesPedido.setDesconto(criarPedidoDTO.getDesconto());

        try {
            pedidoRepository.save(pedido);
            detalhePedidoOtimistaRepository.save(detalhesPedido);
            DetalhePedidoOtimistaDTO detalhePedido = new DetalhePedidoOtimistaDTO();
            return new ResponseEntity<>(detalhePedido.toDTO(detalhesPedido, cliente), HttpStatus.CREATED);
        } catch (OptimisticLockingFailureException e) {
            log.error("conflito encontrado", e);
           throw new RuntimeException("conflito encontrado "+e);
        }
    }

    public ResponseEntity<String> cadastrarProduto(ProdutoDTO produtoDTO) {

        ProdutoOtimista produto = new ProdutoOtimista();
        produto.setCategoriaID(produtoDTO.getCategoriaID());
        produto.setImagem(produtoDTO.getImagem());
        produto.setPreco(produtoDTO.getPreco());
        produto.setProdutoNome(produtoDTO.getProdutoNome());
        produto.setUnidadeEmEstoque(produtoDTO.getUnidadeEmEstoque());
        ProdutoOtimista response = produtoOtimistaRepository.save(produto);

        return new ResponseEntity<>(
                response.getProdutoNome() + " foi cadastrado no sistema ID:" + response.getProdutoID(),
                HttpStatus.CREATED);

    }

 
}
