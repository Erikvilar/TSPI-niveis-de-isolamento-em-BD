package com.niveisisolamento.project.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.niveisisolamento.project.model.ClientesUser;
import com.niveisisolamento.project.repositories.ClientesRepository;
import com.niveisisolamento.project.service.DTO.ClienteDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CriarCliente {

    private final ClientesRepository clientesRepository;

        
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
