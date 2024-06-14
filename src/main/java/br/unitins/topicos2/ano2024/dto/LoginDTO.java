package br.unitins.topicos2.ano2024.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginDTO(
    @NotEmpty(message = "Informe o e-mail")
    String email,

    @NotEmpty(message = "Informe a senha")
    String senha
) {
    
}
