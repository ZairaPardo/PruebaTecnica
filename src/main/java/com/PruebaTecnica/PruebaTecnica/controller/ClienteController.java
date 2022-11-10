package com.PruebaTecnica.PruebaTecnica.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.PruebaTecnica.PruebaTecnica.facadeImp.Clientedao;
import com.PruebaTecnica.PruebaTecnica.modelo.Cliente;

@Controller
@RequestMapping(path = "/prueba/")
public class ClienteController {

	@Autowired
	private Clientedao clienteDao;
	
	@GetMapping("/cliente")
	private String listarClientes(Model modelo) {
		List<Cliente> lstC = this.clienteDao.findAll();
		modelo.addAttribute("cliente", lstC);
		return "prueba/cliente";
	}
	
	/*
	@GetMapping("/all")
	private List<Cliente> allCliente(){
		List<Cliente> lstC = this.clienteDao.findAll();
		return lstC;
	}
	*/
	
	@GetMapping("/all")
	private ResponseEntity<Map<String, Object>> allClient2(Model modelo){
		Map<String, Object> respon = new HashMap<String,Object>();
		List<Cliente> lstC = this.clienteDao.findAll();
		respon.put("data", lstC);
		return new ResponseEntity<>(respon, HttpStatus.OK);
	}
	
	@GetMapping("/cliente/crear")
	private String formularioCrear(Model modelo) {
		modelo.addAttribute("clienteN", new Cliente());
		return "prueba/formulario_cc";
	}
	
	@PostMapping("/cliente")
	private String crearCliente(@ModelAttribute("clienteN") Cliente cliente) {
		clienteDao.create(cliente);
		return "redirect:/prueba/cliente";
	}
	
	@GetMapping("/cliente/editar/{numDocumento}")
	private String formularioEditar(@PathVariable("numDocumento") Integer numDocumento, Model modelo) {
		Cliente cliente = clienteDao.findId(numDocumento);
		modelo.addAttribute("cliente", cliente);
		return "prueba/formulario_ec";
	}

	@GetMapping("/cliente/eliminar/{numDocumento}")
	private String eliminarCliente(@PathVariable ("numDocumento") Integer numDocumento) {
		
		clienteDao.delete(numDocumento);
		return "redirect:/prueba/cliente";
	}
}
