package br.com.devsanches.cliente.escola.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MateriaDTO {
	
	
	private Long id;
	
	@NotBlank(message = "Informe o nome da matéria")
	private String nome;
	
	@Min(value = 34, message = "Permitido o mínimo de 34h por Matéria")
	@Max(value = 120, message = "Permitido o máximo de 120h por Matéria")
	private int horas;
	
	@NotBlank(message = "Informe o código da matéria")
	private String codigo;
	
	@Min(value = 1, message = "Permitido o mínimo de 1 vez ao Ano")
	@Max(value = 2, message = "Permitido o máximo de 2 vezes ao Ano")
	private int frequencia;
	
}
