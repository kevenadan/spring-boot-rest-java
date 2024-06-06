package br.com.project.validator;

public interface CheckableValidator<T> extends Validator<T>{

	boolean verificar(final T valor);
	
	boolean verificar(final String nome, final T valor);
	
}
