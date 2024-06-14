package br.unitins.topicos2.ano2024.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.AssinaturaDTO;
import br.unitins.topicos2.ano2024.dto.AssinaturaResponseDTO;
import br.unitins.topicos2.ano2024.dto.MatriculaDTO;
import br.unitins.topicos2.ano2024.dto.MatriculaResponseDTO;
import br.unitins.topicos2.ano2024.model.Assinatura;
import br.unitins.topicos2.ano2024.repository.AssinaturaRepository;
import br.unitins.topicos2.ano2024.repository.MatriculaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class AssinaturaServiceImpl implements AssinaturaService {
           @Inject
    AssinaturaRepository assinaturaRepository;

    @Inject
    MatriculaRepository matriculaRepository;

    @Inject
    Validator validator;


    @Override
    public AssinaturaResponseDTO findById(Long id) {
        Assinatura assinatura = assinaturaRepository.findById(id);
        if (assinatura == null)
            throw new NotFoundException("Assinatura não encontrada.");
        return AssinaturaResponseDTO.valueOf(assinatura);
    }

    @Override
    @Transactional
    public AssinaturaResponseDTO create(AssinaturaDTO assinaturaDTO) throws ConstraintViolationException {
        validar(assinaturaDTO);

        Assinatura entity = new Assinatura();
        entity.setId(assinaturaDTO.id());
        entity.setMatricula(matriculaRepository.findById(assinaturaDTO.idMatricula()));

        assinaturaRepository.persist(entity);

        return AssinaturaResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public AssinaturaResponseDTO update(Long id, AssinaturaDTO assinaturaDTO) throws ConstraintViolationException {
        validar(assinaturaDTO);

        Assinatura entity = assinaturaRepository.findById(id);

        entity.setId(assinaturaDTO.id());
        entity.setMatricula(matriculaRepository.findById(assinaturaDTO.idMatricula()));

        return AssinaturaResponseDTO.valueOf(entity);
    }

    private void validar(AssinaturaDTO assinaturaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<AssinaturaDTO>> violations = validator.validate(assinaturaDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        assinaturaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return assinaturaRepository.count();
    }

   @Override
    public List<AssinaturaResponseDTO> getAll(int page, int pageSize) {
        List<Assinatura> list = assinaturaRepository
                                .findAll()
                                .page(page, pageSize)
                                .list();
        
        return list.stream().map(e -> AssinaturaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

@Override
public MatriculaResponseDTO update(Long id, MatriculaDTO dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
}   




}
