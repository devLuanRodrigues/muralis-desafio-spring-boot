package br.com.muralis.desafiospringboot.application.dto;

import java.util.List;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String dataCadastro;
    private List<ContatoDTO> contatos;

    public ClienteDTO() {}

    public ClienteDTO(Long id, String nome, String dataCadastro, List<ContatoDTO> contatos) {
        setId(id);
        setNome(nome);
        setDataCadastro(dataCadastro);
        setContatos(contatos);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<ContatoDTO> getContatos() {
        return contatos;
    }

    public void setContatos(List<ContatoDTO> contatos) {
        this.contatos = contatos;
    }
}


