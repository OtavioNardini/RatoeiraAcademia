package br.unitins.topicos2.ano2024.dto;

import br.unitins.topicos2.ano2024.model.DuracaoPlano;
import io.smallrye.common.constraint.NotNull;
import jakarta.validation.constraints.NotBlank;

public record AssinaturaDTO(
     @NotBlank Long id,
    @NotBlank Double preco,
    @NotBlank DuracaoPlano duracao,
    @NotBlank String descricao,
    @NotNull Long idMatricula

    
) {


}
