package br.unitins.topicos2.ano2024.dto;

import java.time.LocalDate;
import java.util.List;

import br.unitins.topicos2.ano2024.model.Perfil;
import br.unitins.topicos2.ano2024.model.Usuario;


public record UsuarioResponseDTO(
        String nome,
        String senha,
        String cpf,
        String telefone,
        String email,
        LocalDate dataNascimento,
        List<EnderecoResponseDTO> listaEndereco,
        Perfil perfil,
        String nomeImagem

) {
    public static UsuarioResponseDTO valueOf(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getNome(),
                usuario.getSenha(),
                usuario.getCpf(),
                usuario.getTelefone(),
                usuario.getEmail(),
                usuario.getDataNascimento(),
                usuario.getListaEndereco().stream().
                map(t -> EnderecoResponseDTO.valueOf(t)).toList(),
                usuario.getPerfil(),
                usuario.getNomeImagem());

    }

}