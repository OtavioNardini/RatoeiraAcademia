package br.unitins.topicos2.ano2024.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos2.ano2024.dto.MatriculaResponseDTO;
import br.unitins.topicos2.ano2024.dto.MatriculaDTO;
import br.unitins.topicos2.ano2024.model.Matricula;
import br.unitins.topicos2.ano2024.repository.MatriculaRepository;
import br.unitins.topicos2.ano2024.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class MatriculaServiceImpl implements MatriculaService {
    
        @Inject
    MatriculaRepository matriculaRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    Validator validator;


    @Override
    public MatriculaResponseDTO findById(Long id) {
        Matricula matricula = matriculaRepository.findById(id);
        if (matricula == null)
            throw new NotFoundException("Matricula não encontrada.");
        return MatriculaResponseDTO.valueOf(matricula);
    }

    @Override
    @Transactional
    public MatriculaResponseDTO create(MatriculaDTO matriculaDTO) throws ConstraintViolationException {
        validar(matriculaDTO);

        Matricula entity = new Matricula();
        entity.setNumeroMatricula(matriculaDTO.numeroMatricula());
        entity.setUsuario(usuarioRepository.findById(matriculaDTO.idUsuario()));

        matriculaRepository.persist(entity);

        return MatriculaResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public MatriculaResponseDTO update(Long id, MatriculaDTO matriculaDTO) throws ConstraintViolationException {
        validar(matriculaDTO);

        Matricula entity = matriculaRepository.findById(id);

        entity.setNumeroMatricula(matriculaDTO.numeroMatricula());
        entity.setUsuario(usuarioRepository.findById(matriculaDTO.idUsuario()));

        return MatriculaResponseDTO.valueOf(entity);
    }

    private void validar(MatriculaDTO matriculaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<MatriculaDTO>> violations = validator.validate(matriculaDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }

    @Override
    public long count() {
        return matriculaRepository.count();
    }

   @Override
    public List<MatriculaResponseDTO> getAll(int page, int pageSize) {
        List<Matricula> list = matriculaRepository
                                .findAll()
                                .page(page, pageSize)
                                .list();
        
        return list.stream().map(e -> MatriculaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }   




}
