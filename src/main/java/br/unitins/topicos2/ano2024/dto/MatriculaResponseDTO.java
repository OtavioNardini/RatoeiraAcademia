package br.unitins.topicos2.ano2024.dto;

import java.time.LocalDate;
import br.unitins.topicos2.ano2024.model.Matricula;

public record MatriculaResponseDTO(
    Long id,
    Long numeroMatricula,
    LocalDate dataInicio,
    LocalDate dataFim,
    UsuarioResponseDTO usuario

) {
    public static MatriculaResponseDTO valueOf(Matricula matricula) {
        return new MatriculaResponseDTO(
        matricula.getId(),
        matricula.getNumeroMatricula(),
        matricula.getDataInicio(),
        matricula.getDataFim(),
        UsuarioResponseDTO.valueOf(matricula.getUsuario()));  
}  
}