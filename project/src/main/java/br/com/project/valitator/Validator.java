package br.com.project.valitator;

public interface Validator<T> {

	void validar(final T valor);
	
	void validar(final String nome, final T valor);
}
