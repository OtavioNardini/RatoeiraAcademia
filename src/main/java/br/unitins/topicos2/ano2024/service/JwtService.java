package br.unitins.topicos2.ano2024.service;

import br.unitins.topicos2.ano2024.dto.UsuarioResponseDTO;

public interface JwtService {
    public String generateJwt(UsuarioResponseDTO dto);
}
