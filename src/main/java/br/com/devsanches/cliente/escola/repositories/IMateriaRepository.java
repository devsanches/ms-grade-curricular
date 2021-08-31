package br.com.devsanches.cliente.escola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devsanches.cliente.escola.entities.MateriaEntity;

public interface IMateriaRepository extends JpaRepository<MateriaEntity, Long> {
	
}
