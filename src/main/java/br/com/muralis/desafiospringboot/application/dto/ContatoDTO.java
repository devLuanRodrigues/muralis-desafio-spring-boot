package br.com.muralis.desafiospringboot.application.dto;

public class ContatoDTO {
    private Long id;
    private String tipo;
    private String texto;

    public ContatoDTO() {}

    public ContatoDTO(Long id, String tipo, String texto) {
        setId(id);
        setTipo(tipo);
        setTexto(texto);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

