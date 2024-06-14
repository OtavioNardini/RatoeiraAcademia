package br.unitins.topicos2.ano2024.dto;

import java.time.LocalDate;

import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record MatriculaDTO (
    @NotBlank Long idUsuario,
    @NotNull Long numeroMatricula,
    @NotBlank LocalDate dataInicio,
    @NotBlank LocalDate dataFim
    )
{}
