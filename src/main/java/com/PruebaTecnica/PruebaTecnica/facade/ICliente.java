package com.PruebaTecnica.PruebaTecnica.facade;

import java.util.List;

import com.PruebaTecnica.PruebaTecnica.modelo.Cliente;

public interface ICliente {

	public List<Cliente> findAll();
	public Cliente findId(Integer numDocumento);
	public void create(Cliente cliente);
	public void update(Cliente cliente);
	public void delete(Integer numDocumento);
	
}
