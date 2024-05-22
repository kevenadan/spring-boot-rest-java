package br.com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.project.service.MathService;
import br.com.project.valitator.impl.ValidadorNumerico;

@Component
public class MathServiceImpl implements MathService {

	@Autowired private ValidadorNumerico validator;
	
	@Override
	public Double sum(String strNumberOne, String strNumberTwo) {
		
		return convertToDouble(strNumberOne) + convertToDouble(strNumberTwo) ;
	}

	@Override
	public Double subtract(String strNumberOne, String strNumberTwo) {

		return convertToDouble(strNumberOne) - convertToDouble(strNumberTwo);
	}

	@Override
	public Double multiplication(String strNumberOne, String strNumberTwo) {

		return convertToDouble(strNumberOne) * convertToDouble(strNumberTwo);
	}

	@Override
	public Double division(String strNumberOne, String strNumberTwo) {
		
		return convertToDouble(strNumberOne) / convertToDouble(strNumberTwo);
	}

	@Override
	public Double squareRoot(String strNumber) {
	
		return Math.sqrt(convertToDouble(strNumber));
	}

	@Override
	public Double average(String strNumberOne, String strNumberTwo) {
		
		return (convertToDouble(strNumberOne) + convertToDouble(strNumberTwo)) / 2;
	}
	
	public Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		//BR 10,25 US 10.25
		String number = strNumber.replaceAll(",",".");
		if(validator.isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}
}
