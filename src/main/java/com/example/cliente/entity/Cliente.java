package com.example.cliente.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cliente")
@NoArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "celular", nullable = false)
    private String celular;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "datacadastro", nullable = false)
    private String datacadastro;

    @Column(name = "name", nullable = false, unique = true)
    private String documento;

    @Column(name = "CEP", nullable = false)
    private String CEP;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "complemento", nullable = false)
    private String complemento;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "cidade", nullable = false)
    private String cidade;

    @Column(name = "UF", nullable = false)
    private String UF;


    @Builder
    public Cliente(String name, String celular, String email, String datacadastro,
                   String documento, String CEP, String endereco, String numero,
                   String complemento, String bairro, String cidade, String UF) {
        this.name = name;
        this.celular = celular;
        this.email = email;
        this.datacadastro = datacadastro;
        this.documento = documento;
        this.CEP = CEP;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
    }
}
