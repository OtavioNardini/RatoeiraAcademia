package br.unitins.topicos2.ano2024.repository;

import java.util.List;

import br.unitins.topicos2.ano2024.dto.AssinaturaResponseDTO;
import br.unitins.topicos2.ano2024.model.Assinatura;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.NotFoundException;


@ApplicationScoped
public class AssinaturaRepository implements PanacheRepository<Assinatura>{
        public List<Assinatura> findId(Long id) {
        if (id == null)
            return null;
        return find("id ?1 ", "%" + id + "%").list();
    }

    public List<Assinatura> findAll2() {
        return find("SELECT c FROM Assinatura c ORDER BY c.id ").list();
    }
}
