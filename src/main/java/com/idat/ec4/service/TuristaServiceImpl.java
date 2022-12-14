package com.idat.ec4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec4.client.OpenFeignClient;
import com.idat.ec4.dto.HospedajeDTO;
import com.idat.ec4.modelo.Turista;
import com.idat.ec4.modelo.TuristaDetalle;
import com.idat.ec4.modelo.TuristaHospedajeFK;
import com.idat.ec4.repositorio.TuristaRepository;
import com.idat.ec4.repositorio.DetalleTuristaRepository;

@Service
public class TuristaServiceImpl implements TuristaService {

	@Autowired
	private TuristaRepository aularepo;
	
	@Autowired
	private DetalleTuristaRepository detallerepo;
	
	@Autowired
	private OpenFeignClient client;
	
	@Override
	public void guardarturista(Turista aula) {
		aularepo.save(aula);
	}

	@Override
	public void asignarturistaHospedaje() {
		List<HospedajeDTO> listado = client.listarHospedajes();
		TuristaHospedajeFK fk = null;
		TuristaDetalle detalle = null;
		
		for (HospedajeDTO hospedajeDTO : listado) {
			fk = new TuristaHospedajeFK();
			fk.setIdHospedaje(hospedajeDTO.getIdHospedaje());
			fk.setIdTurista(1);
			
			detalle = new TuristaDetalle();
			detalle.setFk(fk);
			detallerepo.save(detalle);
		}
		}
		

}
