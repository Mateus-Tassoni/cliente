package com.example.cliente.controller;

import com.example.cliente.dto.request.ClienteRequestDTO;
import com.example.cliente.dto.response.ClienteResponseDTO;
import com.example.cliente.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping(value = "/id")
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok().body(clienteService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> findAll(){
        return ResponseEntity.ok().body(clienteService.findAll());
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> register (@RequestBody ClienteRequestDTO clienteDTO,
                                                         UriComponentsBuilder uriBuilder){

        ClienteResponseDTO clienteResponseDTO = clienteService.register(clienteDTO);

        URI uri = uriBuilder.path("/cliente/id").buildAndExpand(clienteResponseDTO.getId()).toUri();
        
        return ResponseEntity.created(uri).body(clienteResponseDTO);
    }

    @PutMapping(value = "/id")
    public ResponseEntity<ClienteResponseDTO> update(@RequestBody ClienteRequestDTO clienteDTO,@PathVariable(name = "id")Long id) {
        return ResponseEntity.ok().body(clienteService.update(id, clienteDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete (@PathVariable(value = "id")Long id){
        return ResponseEntity.ok().body(clienteService.delete(id));
    }
}
