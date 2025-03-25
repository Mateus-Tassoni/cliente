package com.example.cliente.dto.response;

import com.example.cliente.entity.Cliente;
import lombok.Getter;

@Getter
public class ClienteResponseDTO {
    private Long id;


    private String name;

    private String celular;

    private String email;

    private String datacadastro;

    private String documento;

    private String CEP;

    private String endereco;

    private String numero;

    private String complemento;

    private String bairro;

    private String cidade;

    private String UF;

    public ClienteResponseDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.name = cliente.getName();
        this.celular = cliente.getCelular();
        this.email = cliente.getEmail();
        this.datacadastro = cliente.getDatacadastro();
        this.documento = cliente.getDocumento();
        this.CEP = cliente.getCEP();
        this.endereco = cliente.getEndereco();
        this.numero = cliente.getNumero();
        this.complemento = cliente.getDocumento();
        this.bairro = cliente.getBairro();
        this.cidade = cliente.getCidade();
        this.UF = cliente.getUF();

    }
}
