package com.example.cliente.service;


import com.example.cliente.dto.request.ClienteRequestDTO;
import com.example.cliente.dto.response.ClienteResponseDTO;

import java.util.List;

public interface ClienteService {
    ClienteResponseDTO findById(Long Id);

    List<ClienteResponseDTO> findAll();

    ClienteResponseDTO register(ClienteRequestDTO clienteDTO);

    ClienteResponseDTO update( Long id, ClienteRequestDTO clienteDTO);

    String delete(Long id);




}
