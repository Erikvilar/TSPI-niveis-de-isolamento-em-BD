package com.niveisisolamento.project.service;

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
import com.niveisisolamento.project.repositories.ProdutoRespository;
import com.niveisisolamento.project.service.DTO.ClienteDTO;
import com.niveisisolamento.project.service.DTO.CriarPedidoDTO;
import com.niveisisolamento.project.service.DTO.DetalhePedidoDTO;
import com.niveisisolamento.project.service.DTO.ProdutoDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicePedidos {

    private final PedidoRepository pedidoRepository;
    private final ClientesRepository clientesRepository;
    private final ProdutoRespository produtoRespository;
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
            return new ResponseEntity<>("PRODUTO ESGOTADO", HttpStatus.CONFLICT);
        }
        detalhesPedido.setQuantidade(quantidadeRestante);
        produto.setUnidadeEmEstoque(quantidadeRestante);
        detalhesPedido.setDesconto(criarPedidoDTO.getDesconto());

        pedidoRepository.save(pedido);
        detalhePedidoRepository.save(detalhesPedido);
        DetalhePedidoDTO detalhePedidoDTO = new DetalhePedidoDTO();
        return new ResponseEntity<>(detalhePedidoDTO.toDTO(detalhesPedido, cliente), HttpStatus.CREATED);

    }

    public ResponseEntity<String> cadastrarProduto(ProdutoDTO produtoDTO) {

        Produto produto = new Produto();
        produto.setCategoriaID(produtoDTO.getCategoriaID());
        produto.setImagem(produtoDTO.getImagem());
        produto.setPreco(produtoDTO.getPreco());
        produto.setProdutoNome(produtoDTO.getProdutoNome());
        produto.setUnidadeEmEstoque(produtoDTO.getUnidadeEmEstoque());
        Produto response = produtoRespository.save(produto);

        return new ResponseEntity<>(
                response.getProdutoNome() + " foi cadastrado no sistema ID:" + response.getProdutoID(),
                HttpStatus.CREATED);

    }

    public ResponseEntity<String> criarCliente(ClienteDTO clienteDTO) {

        ClientesUser clientesUser = new ClientesUser();
        clientesUser.setClienteID(clienteDTO.getClienteID());
        clientesUser.setNome(clienteDTO.getNome());
        clientesUser.setEndereco(clienteDTO.getEndereco());
        clientesUser.setFax(clienteDTO.getFax());
        clientesUser.setPais(clienteDTO.getTelefone());
        clientesUser.setTelefone(clienteDTO.getTelefone());
        clientesUser.setCidade(clienteDTO.getCidade());
        clientesUser.setPais(clienteDTO.getPais());
        clientesUser.setCargo(clienteDTO.getCargo());

        var response = clientesRepository.save(clientesUser);
        return new ResponseEntity<>("cliente cadastrado ID" + response.getClienteID(), HttpStatus.CREATED);

    }

}
