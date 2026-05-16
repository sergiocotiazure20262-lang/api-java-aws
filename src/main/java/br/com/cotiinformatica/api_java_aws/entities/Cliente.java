package br.com.cotiinformatica.api_java_aws.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "email", nullable = false, length = 150)
    private String email;

    @Column(name = "data_hora_cadastro", nullable = false)
    private LocalDateTime dataHoraCadastro;

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String email, LocalDateTime dataHoraCadastro) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataHoraCadastro = dataHoraCadastro;
    }

    @PrePersist
    public void prePersist() {
        dataHoraCadastro = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }
}