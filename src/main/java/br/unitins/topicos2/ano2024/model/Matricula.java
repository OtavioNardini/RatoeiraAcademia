package br.unitins.topicos2.ano2024.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Matricula extends DefaultEntity {
    
    @NotBlank
    @Column(nullable = false, length = 2)
    private long numeroMatricula;

     @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    @NotBlank
    @Column(nullable = false)
    private LocalDate dataInicio;


    @NotBlank
    @Column(nullable = false)
    private LocalDate dataFim;

    public long getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(long numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
