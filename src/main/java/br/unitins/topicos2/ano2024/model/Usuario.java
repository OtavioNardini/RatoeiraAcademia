package br.unitins.topicos2.ano2024.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Usuario extends DefaultEntity {

    @NotBlank
    private String nome;

    @NotBlank
    @Size(min = 4, max = 25, message = "A senha deve ter entre de 4 a 25 caracteres")
    private String senha;

    @NotBlank
    @CPF
    private String cpf;

    @Pattern(regexp = "^$|^[0-9]{10,15}$", message = "Número de telefone inválido")
    private String telefone;

    @NotBlank
    @Email
    private String email;

    @Past(message = "Data de nascimento inválida")
    private LocalDate DataNascimento;

    @OneToMany
    @JoinColumn(name = "id_endereco")
    private List<Endereco> ListaEndereco;

    private Perfil perfil;

    private String nomeImagem;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        DataNascimento = dataNascimento;
    }

    public List<Endereco> getListaEndereco() {
        return ListaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        ListaEndereco = listaEndereco;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    
}
