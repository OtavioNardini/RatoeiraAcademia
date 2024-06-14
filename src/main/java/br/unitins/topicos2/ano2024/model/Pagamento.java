package br.unitins.topicos2.ano2024.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


@Entity
public class Pagamento extends DefaultEntity{


    @Positive(message = "O valor total deve ser maior que zero")
    private Double valorTotal;

    @NotBlank(message = "O método de pagamento não pode ser nulo")
    private MetodoDePagamento metodo;

    @NotBlank(message = "O status do pagamento não pode ser nulo")
    private StatusPagamento status;

    @NotBlank(message = "A data de pagamento não pode ser nula")
    private LocalDate dataPagamento;

}
