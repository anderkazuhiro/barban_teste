package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import br.com.tokiomarine.seguradora.avaliacao.Error.ResourceNotFoundException;
import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import br.com.tokiomarine.seguradora.avaliacao.service.util.ValidateEstudante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudanteServiceImpl implements EstudandeService {

	@Autowired
	EstudanteRepository repository;

	@Autowired
	ValidateEstudante validateEstudante;

	@Override
	public String cadastrarEstudante(@Valid Estudante estudante) {
		validateEstudante.validate(estudante);
		estudante = repository.save(estudante);
		return estudante.getId().toString();
	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante,Long id) {
		validateEstudante.validate(estudante);
		Estudante estudanteAtualizado = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Estudante não encontrado"));

		estudanteAtualizado.setNome(estudante.getNome());
		estudanteAtualizado.setCurso(estudante.getCurso());
		estudanteAtualizado.setEmail(estudante.getEmail());
		estudanteAtualizado.setMatricula(estudante.getMatricula());
		estudanteAtualizado.setTelefone(estudante.getTelefone());

		repository.save(estudanteAtualizado);
	}

	@Override
	public void apagarEstudante(Long id) {

		Estudante estudante = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Estudante não encontrado"));
		repository.delete(estudante);
	}

	@Override
	public List<Estudante> buscarEstudantes() {
		List<Estudante> estudantes = repository.findAll();
		return estudantes;
	}

	@Override
	public Estudante buscarEstudante(long id) {
		Estudante estudante = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Estudante não encontrado"));
		return estudante;
	}

}
