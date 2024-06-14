package br.unitins.topicos2.ano2024.repository;

import java.util.List;

import br.unitins.topicos2.ano2024.model.Endereco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnderecoRespository implements PanacheRepository<Endereco>{

    public List<Endereco> findById(String cidade){
        return find("cidade.id = ?1",cidade).list(); 
    }
    
}
