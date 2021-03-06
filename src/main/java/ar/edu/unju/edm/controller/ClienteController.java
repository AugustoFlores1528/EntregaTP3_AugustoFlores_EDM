package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.service.IClienteService;

@Controller
public class ClienteController {
	private static final Log LOGGER = LogFactory.getLog(ClienteController.class);
	
	@Autowired
	IClienteService clienteService;
	
	@GetMapping("/cliente/mostrar")
	public String cargarC(Model model) {
		model.addAttribute("unCliente", clienteService.crearC());
		model.addAttribute("clientes", clienteService.obtenerTodosC());
		return("cliente");
	}
	
	@PostMapping("/cliente/guardar")
	public String guardarNuevoProducto(@ModelAttribute("unCliente") Cliente nuevoCliente, Model model) {
		LOGGER.info("METHOD: ingresando al metodo guardar");
		clienteService.guardarC(nuevoCliente);
		LOGGER.info("Tamaño del Listado: "+ clienteService.obtenerTodosC().size());
		
		return ("redirect:/cliente/mostrar");
	}
}
