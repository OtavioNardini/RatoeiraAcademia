package br.unitins.topicos2.ano2024.repository;

import java.util.List;

import br.unitins.topicos2.ano2024.model.Matricula;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MatriculaRepository implements PanacheRepository<Matricula> {
    public Matricula findById(Long id) {
        if (id == null)
            return null;
        return (Matricula) find("UPPER(id) LIKE ?1 ", "%" + id + "%").list();
    }

    public List<Matricula> findAll2() {
        return find("SELECT c FROM Matricula c ORDER BY c.id ").list();
    }
}
