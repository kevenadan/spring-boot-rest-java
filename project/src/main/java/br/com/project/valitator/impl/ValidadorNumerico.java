package br.com.project.valitator.impl;

import org.springframework.stereotype.Component;

import br.com.project.TipoCodigoErro;
import br.com.project.exceptions.ValidatorException;
import br.com.project.valitator.CheckableValidator;

@Component
public class ValidadorNumerico implements CheckableValidator<String> {

	@Override
	public void validar(String nome, String valor) throws ValidatorException {
		if(verificar(nome, valor)) {
			if(nome != null) {
				throw new ValidatorException(
						String.format("O valor '%s' do atributo 's' não é um numérico válido.",valor, nome), TipoCodigoErro.ERRO_VALIDACAO_DADO);
			} else {
				throw new ValidatorException(
						String.format("O valor '%s' é um número válido", valor), TipoCodigoErro.ERRO_VALIDACAO_DADO);
			}
		}
	}
	
	@Override
	public void validar(String valor) throws ValidatorException {
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

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String IS_NUMBER = "[-+]?[0-9]*\\.?[0-9]+";
		String number = strNumber.replaceAll(",", ".");
		return number.matches(IS_NUMBER);
	}
}
