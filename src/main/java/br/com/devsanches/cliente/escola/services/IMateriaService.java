package br.com.devsanches.cliente.escola.services;

import java.util.List;

import br.com.devsanches.cliente.escola.entities.MateriaEntity;

public interface IMateriaService {
	
	public List<MateriaEntity> buscar();
	
	public MateriaEntity buscarPorId(final Long id);
	
	public Boolean cadastrar(final MateriaEntity materia);
	
	public Boolean atualizar(final MateriaEntity materia);
	
	public Boolean excluir(final Long id);
	
}
