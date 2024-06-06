package br.com.project.valitator.impl;

import org.springframework.stereotype.Component;

import br.com.project.exceptions.UnsupportedMathOperationException;
import br.com.project.validator.CheckableValidator;

@Component
public class ValidadorValorObrigatorio implements CheckableValidator<String> {

	@Override
	public void validar(String nome, String valor) {
		if(!verificar(valor)) {
			throw new UnsupportedMathOperationException("O atributo não pode ser vazio");
		}
	}
	
	@Override
	public void validar(String valor) {
		validar(null, valor);
	}

	@Override
	public boolean verificar(String valor) {
		if(valor == null || valor.trim().isEmpty()) return false;
		
		return true;
	}
	
	@Override
	public boolean verificar(String nome, String valor) {		
	
		return verificar(valor);
	}
}
