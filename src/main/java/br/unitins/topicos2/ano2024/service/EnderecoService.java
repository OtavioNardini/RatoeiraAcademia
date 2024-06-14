package br.unitins.topicos2.ano2024.service;



import java.util.List;

import br.unitins.topicos2.ano2024.dto.EnderecoDTO;
import br.unitins.topicos2.ano2024.dto.EnderecoResponseDTO;


public interface EnderecoService {
    
    public EnderecoResponseDTO insert(EnderecoDTO dto);

    public EnderecoResponseDTO update(EnderecoDTO dto, Long id);

    public void delete(Long id);

    public EnderecoResponseDTO findById(Long id);
    
    public List<EnderecoResponseDTO> findByBairro(String nome);

    public List<EnderecoResponseDTO> findByAll();
}