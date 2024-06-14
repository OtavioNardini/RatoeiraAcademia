package br.unitins.topicos2.ano2024.service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


import java.util.List;

import br.unitins.topicos2.ano2024.dto.UsuarioDTO;
import br.unitins.topicos2.ano2024.dto.UsuarioResponseDTO;
import br.unitins.topicos2.ano2024.model.Perfil;
import br.unitins.topicos2.ano2024.model.Usuario;
import br.unitins.topicos2.ano2024.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{

    @Inject
    UsuarioRepository repository;

    @Override
    @Transactional
    public UsuarioResponseDTO insert(UsuarioDTO dto) {
        Usuario novaUsuario = new Usuario();
        novaUsuario.setNome(dto.nome());
        novaUsuario.setEmail(dto.email());
        novaUsuario.setCpf(dto.cpf());
        novaUsuario.setPerfil(Perfil.valueOf(dto.idperfil()));
        novaUsuario.setDataNascimento(dto.dataNascimento());

        repository.persist(novaUsuario);

        return UsuarioResponseDTO.valueOf(novaUsuario);
    }

    @Override
    public UsuarioResponseDTO update(UsuarioDTO dto, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        return UsuarioResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<UsuarioResponseDTO> findAll() {
        return repository.listAll().stream()
                .map(e -> UsuarioResponseDTO.valueOf(e)).toList();
    }
}
