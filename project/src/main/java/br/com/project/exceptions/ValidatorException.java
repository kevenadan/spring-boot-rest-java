package br.com.project.exceptions;

import br.com.project.TipoCodigoErro;

public class ValidatorException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private TipoCodigoErro codigoErro;
	
	public ValidatorException(String mensagem) {
		this(mensagem, TipoCodigoErro.ERRO_VALIDACAO_DADO);
	}
	
	public ValidatorException(String mensagem, TipoCodigoErro codigoErro) {
		super(mensagem);
		this.codigoErro = codigoErro;
	}
	
	public TipoCodigoErro getTipoCodigoErro() {
		return codigoErro;
	}
	
}
