package com.example.cliente.util;

import com.example.cliente.dto.request.ClienteRequestDTO;
import com.example.cliente.dto.response.ClienteResponseDTO;
import com.example.cliente.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {


    public Cliente toCliente(ClienteRequestDTO clienteDTO) {
        return Cliente.builder()
                .name(clienteDTO.getName())
                .celular(clienteDTO.getCelular())
                .email(clienteDTO.getEmail())
                .datacadastro(clienteDTO.getDatacadastro())
                .CEP(clienteDTO.getCEP())
                .endereco(clienteDTO.getEndereco())
                .numero(clienteDTO.getNumero())
                .complemento(clienteDTO.getComplemento())
                .bairro(clienteDTO.getBairro())
                .cidade(clienteDTO.getCidade())
                .UF(clienteDTO.getUF())

                .build();
    }

    public ClienteResponseDTO toClienteDTO(Cliente cliente){
            return new ClienteResponseDTO(cliente);

    }

    public List<ClienteResponseDTO> toClienteDTO(List<Cliente>clienteList) {
        return clienteList.stream().map(ClienteResponseDTO::new).collect(Collectors.toList());

    }

    public void updateClienteData(Cliente cliente, ClienteRequestDTO clienteRequestDTO){
        cliente.setName(cliente.getName());
        cliente.setCelular(cliente.getCelular());
        cliente.setEmail(cliente.getEmail());
        cliente.setDatacadastro(cliente.getDatacadastro());
        cliente.setCEP(cliente.getCEP());
        cliente.setEndereco(cliente.getEndereco());
        cliente.setNumero(cliente.getNumero());
        cliente.setComplemento(cliente.getComplemento());
        cliente.setBairro(cliente.getBairro());
        cliente.setCidade(cliente.getCidade());
        cliente.setUF(cliente.getUF());


    }


}
