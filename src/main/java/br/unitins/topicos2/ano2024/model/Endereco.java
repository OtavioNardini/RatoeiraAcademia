package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Entity
public class Endereco extends DefaultEntity {

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    @NotBlank
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "CEP deve estar no formato 'XXXXX-XXX'.")
    @Column(nullable = false)
    private String cep;


    @Column(length = 8, nullable = false)
    @Positive(message = "O CEP não pode ser 0 ou negativo")
    private Integer numero;

    @NotBlank(message = "Informe o bairro")
    @Column(length = 60, nullable = false)
    private String bairro;

    @NotBlank(message = "Informe o logradouro")
    @Column(length = 60, nullable = false)
    private String logradouro;

    @Column(length = 50)
    private String complemento;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }


    
}
