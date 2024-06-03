package br.com.project.service;

import org.springframework.stereotype.Service;

@Service
public interface MathService {

	Double convertToDouble(String strNumber);
	
	Double sum(String strNumberOne, String strNumberTwo);
	
	Double subtract(String strNumberOne, String strNumberTwo);
	
	Double multiplication(String strNumberOne, String strNumberTwo);
	
	Double division(String strNumberOne, String strNumberTwo);
	
	Double average(String strNumberOne, String strNumberTwo);
	
	Double squareRoot(String strNumber);
}
