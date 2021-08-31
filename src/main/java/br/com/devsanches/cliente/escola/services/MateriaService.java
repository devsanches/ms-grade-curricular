package br.com.devsanches.cliente.escola.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.devsanches.cliente.escola.dtos.MateriaDTO;
import br.com.devsanches.cliente.escola.entities.MateriaEntity;
import br.com.devsanches.cliente.escola.exceptions.MateriaException;
import br.com.devsanches.cliente.escola.repositories.IMateriaRepository;

@Service
public class MateriaService implements IMateriaService {
	
	@Autowired
	private IMateriaRepository materiaRepository;
	
	
	@Override
	public List<MateriaEntity> buscar() {
		try {
			
			if (!materiaRepository.findAll().isEmpty()) {
				return materiaRepository.findAll();
			}	
			
			throw new MateriaException("Não foram encontradas materias", HttpStatus.NOT_FOUND);
		} catch(MateriaException m) {
			throw m;
		} catch(Exception e) {
			throw new MateriaException("Erro interno identificado. Contate o Suporte Técnico", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public MateriaEntity buscarPorId(Long id) {
		try {
			Optional<MateriaEntity> materiaOptional = materiaRepository.findById(id);
			
			if (materiaOptional.isPresent()) {
				return materiaOptional.get();
			}
			
			throw new MateriaException("Materia não encontrada", HttpStatus.NOT_FOUND);
		} catch (MateriaException m) {
			throw m;
		} catch (Exception e) {
			throw new MateriaException("Erro interno identificado. Contate o Suporte Técnico", HttpStatus.INTERNAL_SERVER_ERROR);
		} 

	}

	@Override
	public Boolean cadastrar(MateriaDTO materia) {
		try {
			ModelMapper mapper = new ModelMapper();
			MateriaEntity materiaEntity = mapper.map(materia, MateriaEntity.class);
			this.materiaRepository.save(materiaEntity);
			return true;
		} catch(Exception e) {
			throw new MateriaException("Erro interno identificado. Contate o Suporte Técnico", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Boolean atualizar(MateriaDTO materia) {
		
		try {
			
			Optional<MateriaEntity> materiaOptional = this.materiaRepository.findById(materia.getId());
			
			if (materiaOptional.isPresent()) {
				
				ModelMapper mapper = new ModelMapper();
				
				
				MateriaEntity materiaEntityAtualizada =  mapper.map(materia, MateriaEntity.class);
				
				this.materiaRepository.save(materiaEntityAtualizada);
				return true;
			} 
			
			throw new MateriaException("Materia não encontrada para atualização", HttpStatus.NOT_FOUND);
		} catch(MateriaException m) {
			throw m;
		} catch(Exception e) {
			throw new MateriaException("Erro interno identificado. Contate o Suporte Técnico", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Boolean excluir(Long id) {
		try {
			this.buscarPorId(id);
			this.materiaRepository.deleteById(id);
			return true;
		} catch(MateriaException m) {
			throw m;
		} catch(Exception e) {
			throw new MateriaException("Erro interno identificado. Contate o Suporte Técnico", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
