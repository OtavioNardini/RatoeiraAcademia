package br.unitins.topicos2.ano2024.service;

import java.util.List;

import br.unitins.topicos2.ano2024.dto.MatriculaDTO;
import br.unitins.topicos2.ano2024.dto.MatriculaResponseDTO;
import jakarta.validation.Valid;

public interface MatriculaService {
        // recursos basicos
        List<MatriculaResponseDTO> getAll(int page, int pageSize);

        MatriculaResponseDTO findById(Long id);
    
        MatriculaResponseDTO create(@Valid MatriculaDTO dto);
    
        MatriculaResponseDTO update(Long id, MatriculaDTO dto);
    
        void delete(Long id);
    
        long count();
    
}   

