package br.unitins.topicos2.ano2024.service;

import java.util.List;

import br.unitins.topicos2.ano2024.dto.AssinaturaDTO;
import br.unitins.topicos2.ano2024.dto.AssinaturaResponseDTO;
import br.unitins.topicos2.ano2024.dto.MatriculaDTO;
import br.unitins.topicos2.ano2024.dto.MatriculaResponseDTO;
import jakarta.validation.Valid;

public interface AssinaturaService {

          List<AssinaturaResponseDTO> getAll(int page, int pageSize);

        AssinaturaResponseDTO findById(Long id);
    
        AssinaturaResponseDTO create(@Valid AssinaturaDTO dto);
    
        MatriculaResponseDTO update(Long id, MatriculaDTO dto);
    
        void delete(Long id);
    
        long count();

        AssinaturaResponseDTO update(Long id, AssinaturaDTO dto);
}
