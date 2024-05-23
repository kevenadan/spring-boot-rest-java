package br.com.project.valitator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.project.exceptions.UnsupportedMathOperationException;
import br.com.project.valitator.CheckableValidator;
import br.com.project.valitator.Validator;

@Component
public class ValidadorNumerico implements Validator<String> {

	@Autowired
	@Qualifier("validadorValorObrigatorio")
	private CheckableValidator<String> validatorValorObrigatorio;
	
	@Override
	public void validar(String nome, String valor) {
		validatorValorObrigatorio.validar(valor);
		if(!isNumeric(valor)) {
			throw new UnsupportedMathOperationException("informe um valor numérico");
		}
	}
	
	@Override
	public void validar(String valor) {
		validar(null, valor);
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String IS_NUMBER = "[-+]?[0-9]*\\.?[0-9]+";
		String number = strNumber.replaceAll(",", ".");
		return number.matches(IS_NUMBER);
	}
}
