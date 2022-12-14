package com.idat.ec4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.ec4.modelo.Reserva;
import com.idat.ec4.modelo.Turista;
import com.idat.ec4.service.ReservaService;
import com.idat.ec4.service.TuristaService;


@Controller
@RequestMapping("api/reserva")
public class ReservaController {


	@Autowired
	private ReservaService service;
	
	@PostMapping("/guardar")
	public @ResponseBody void guardar(@RequestBody Reserva reserva) {
		service.guardarReserva(reserva);
	}
	
	@GetMapping("/asignar")
	public @ResponseBody void asignar() {
		service.asignarReservaHospedaje();
	}
}
