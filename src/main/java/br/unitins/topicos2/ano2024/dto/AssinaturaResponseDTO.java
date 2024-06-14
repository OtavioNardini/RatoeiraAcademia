package br.unitins.topicos2.ano2024.dto;

import br.unitins.topicos2.ano2024.model.Assinatura;
import br.unitins.topicos2.ano2024.model.DuracaoPlano;

public record AssinaturaResponseDTO(
    Long id,
    Double preco,
    //DuracaoPlano duracaoPlano,
    String descricao,
    MatriculaResponseDTO matricula

) {
    public static AssinaturaResponseDTO valueOf(Assinatura assinatura) {
    return new AssinaturaResponseDTO(
        assinatura.getId(),
        assinatura.getPreco(),
        assinatura.getDescricao(),
        MatriculaResponseDTO.valueOf(assinatura.getMatricula()));
}
}  

