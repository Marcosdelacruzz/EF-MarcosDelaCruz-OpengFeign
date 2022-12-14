package com.idat.ec4.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.idat.ec4.dto.HospedajeDTO;

@FeignClient(name = "MarcosDelaCruzService", url="localhost:8090")
public interface OpenFeignClient {

	@GetMapping("/api/hospedaje/listar")
	public List<HospedajeDTO> listarHospedajes();
	
}
