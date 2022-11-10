package com.PruebaTecnica.PruebaTecnica.facadeImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PruebaTecnica.PruebaTecnica.facade.ICliente;
import com.PruebaTecnica.PruebaTecnica.modelo.Cliente;
import com.PruebaTecnica.PruebaTecnica.repository.ClienteRepository;

@Service
public class Clientedao implements ICliente{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente findId(Integer numDocumento) {
		return this.clienteRepository.getReferenceById(numDocumento);
	}

	@Override
	public void create(Cliente cliente) {
		this.clienteRepository.save(cliente);
	}

	@Override
	public void update(Cliente cliente) {
		this.clienteRepository.save(cliente);
		
	}

	@Override
	public void delete(Integer numDocumento) {
		clienteRepository.deleteById(numDocumento);
	}

}
