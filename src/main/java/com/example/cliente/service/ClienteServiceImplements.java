package com.example.cliente.service;

import com.example.cliente.dto.request.ClienteRequestDTO;
import com.example.cliente.dto.response.ClienteResponseDTO;
import com.example.cliente.entity.Cliente;
import com.example.cliente.repository.ClienteRepository;
import com.example.cliente.util.ClienteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ClienteServiceImplements implements ClienteService  {

    private final ClienteRepository clienteRepository;

    private final ClienteMapper clienteMapper;



    @Override
    public ClienteResponseDTO findById(Long id) {

        return clienteMapper.toClienteDTO(returnCliente(id));
    }

    @Override
    public List<ClienteResponseDTO> findAll() {
        return clienteMapper.toClienteDTO(clienteRepository.findAll());
    }

    @Override
    public ClienteResponseDTO register(ClienteRequestDTO clienteDTO) {


        Cliente cliente =clienteMapper.toCliente(clienteDTO);

        return clienteMapper.toClienteDTO(clienteRepository.save(cliente));
    }

    @Override
    public ClienteResponseDTO update(Long id, ClienteRequestDTO clienteDTO) {
        Cliente cliente = returnCliente(id);

        clienteMapper.updateClienteData(cliente, clienteDTO);

        return clienteMapper.toClienteDTO(clienteRepository.save(cliente));
    }

    @Override
    public String delete(Long id) {
        clienteRepository.deleteById(id);

        return "Cliente id: "+id+" Deletado";
    }

    private Cliente returnCliente(Long id) {
       return clienteRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("Usuario não encontrado no banco de DADOS"));
    }
}
