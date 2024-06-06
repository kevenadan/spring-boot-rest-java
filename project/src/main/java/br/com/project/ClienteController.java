package br.com.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.model.Cliente;
import br.com.project.service.impl.ClienteService;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente findByIdCliente(@PathVariable(value = "id") String id) {
		return service.findByIdCliente(id);
	}
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> findByAllCliente() {
		return service.findAllCliente();
	}
	
	@RequestMapping(method = RequestMethod.POST, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return service.createCliente(cliente);
	}
	
	@RequestMapping(method = RequestMethod.PUT, 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Cliente updateCliente(@RequestBody Cliente cliente) {
		return service.updateCliente(cliente);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCliente(@PathVariable String id) {
		service.deleteCliente(id);
	}
}
