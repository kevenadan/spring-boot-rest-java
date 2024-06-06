package br.com.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.project.model.Cliente;

@Service
public class ClienteService {

	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(Cliente.class.getName());
	
	public List<Cliente> findAllCliente() {
		
		logger.info("Buscando todos os clientes.");
		
		List<Cliente> clientes = new ArrayList<>();
		for(int i = 0; i < 8; i++ ) {
			Cliente cliente = mockCliente(i);
			clientes.add(cliente);
		}
		
		return clientes;
	}

	public Cliente findByIdCliente(String id) {
		
		logger.info(String.format("Buscando um cliente pelo id %s.", id));
		
		Cliente cliente = new Cliente();
		cliente.setId(counter.incrementAndGet());
		cliente.setNome("Keven");
		cliente.setSobrenome("Adan");
		cliente.setEndereco("Ilha do campeche - Florianópolis");
		cliente.setSexo("Masculino");
		
		return cliente;
	}
	
	public Cliente createCliente(Cliente cliente) {
		
		logger.info("Criando um cliente.");
		
		return cliente;
	}
	
	public Cliente updateCliente(Cliente cliente) {
		
		logger.info("Atualizando um cliente.");
		
		return cliente;
	}
	
	public void deleteCliente(String id) {
		logger.info(String.format("Deletando um cliente com o id %s.", id));
	}
	
	private Cliente mockCliente(int i) {
		
		Cliente cliente = new Cliente();
		cliente.setId(counter.incrementAndGet());
		cliente.setNome("Nome " + i);
		cliente.setSobrenome("Sobrenome " + i);
		cliente.setEndereco("Endereco " + i);
		cliente.setSexo("Masculino");
		return cliente;
	}
	
}
