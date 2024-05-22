package br.com.project.valitator;

import br.com.project.exceptions.ValidatorException;

public interface Validator<T> {

	void validar(final T valor) throws ValidatorException;
	
	void validar(final String nome, final T valor) throws ValidatorException;
	
}
