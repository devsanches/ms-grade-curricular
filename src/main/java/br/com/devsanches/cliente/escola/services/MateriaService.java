package br.com.devsanches.cliente.escola.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.devsanches.cliente.escola.entities.MateriaEntity;
import br.com.devsanches.cliente.escola.repositories.IMateriaRepository;

@Service
public class MateriaService implements IMateriaService {
	
	@Autowired
	private IMateriaRepository materiaRepository;
	
	
	@Override
	public List<MateriaEntity> buscar() {
		return materiaRepository.findAll();
	}

	@Override
	public MateriaEntity buscarPorId(Long id) {
		return materiaRepository.findById(id).get();
	}

	@Override
	public Boolean cadastrar(MateriaEntity materia) {
		try {
			this.materiaRepository.save(materia);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public Boolean atualizar(MateriaEntity materia) {
		MateriaEntity materiaEntityAtualizada = this.materiaRepository.findById(materia.getId()).get();
		
		materiaEntityAtualizada.setNome(materia.getNome());
		materiaEntityAtualizada.setCodigo(materia.getCodigo());
		materiaEntityAtualizada.setHoras(materia.getHoras());
		materiaEntityAtualizada.setFrequencia(materia.getFrequencia());
		
		
		try {
			this.materiaRepository.save(materiaEntityAtualizada);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	@Override
	public Boolean excluir(Long id) {
		try {
			this.materiaRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
}
