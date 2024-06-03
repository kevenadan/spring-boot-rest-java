package br.com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.service.MathService;
import br.com.project.valitator.Validator;

@RestController
public class MathController {
	
	@Qualifier("validadorNumerico")
	@Autowired private Validator<String> validador;
	@Autowired private MathService service;

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", 
			method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {

		validador.validar(numberOne);
		validador.validar(numberTwo);
		
		return service.sum(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", 
			method = RequestMethod.GET)
	public Double subtract(
			@PathVariable(value= "numberOne") String numberOne,
			@PathVariable(value= "numberTwo") String numberTwo
			)throws Exception {
		
		validador.validar(numberOne);
		validador.validar(numberTwo);
		
		return service.subtract(numberOne, numberTwo);
	}
	
	@RequestMapping(value= "/multiplication/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo
			) throws Exception {
		
		validador.validar(numberOne);
		validador.validar(numberTwo);
		
		return service.multiplication(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double division(
			@PathVariable(value= "numberOne") String numberOne,
			@PathVariable(value= "numberTwo") String numberTwo
			) throws Exception {
		
		validador.validar(numberOne);
		validador.validar(numberTwo);
		
		return service.division(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/average/{numberOne}/{numberTwo}",
			method = RequestMethod.GET)
	public Double average(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value= "numberTwo") String numberTwo
			) throws Exception {
		
		validador.validar(numberOne);
		validador.validar(numberTwo);
		
		return service.average(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/squareroot/{number}",
			method = RequestMethod.GET)
	public Double squareroot(
			@PathVariable(value = "number") String number
			) throws Exception {
		
		validador.validar(number);
		
		return service.squareRoot(number);
	}
	
}
