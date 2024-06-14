package br.unitins.topicos2.ano2024.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Assinatura extends DefaultEntity {
    

    @NotBlank(message = "Informe o preço")
    @Column(length = 10, nullable = false)
    private double preco;

    private String nomeImagem;

   // @NotBlank
   // private Duracao duracao;

    @JoinColumn(name = "id_matricula")
    @ManyToOne
    private Matricula matricula;

    @NotBlank(message = "Informe a descrção")
    @Column(length = 250, nullable = false)
    private String descricao;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

   // public Duracao getDuracao() {
   //     return duracao;
   // }

   // public void setDuracao(Duracao duracao) {
    //    this.duracao = duracao;
    //}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }
}
