package com.idat.ec4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ec4.client.OpenFeignClient;
import com.idat.ec4.dto.HospedajeDTO;
import com.idat.ec4.modelo.Reserva;
import com.idat.ec4.modelo.ReservaDetalle;
import com.idat.ec4.modelo.ReservaHospedajeFK;
import com.idat.ec4.modelo.Turista;
import com.idat.ec4.modelo.TuristaDetalle;
import com.idat.ec4.modelo.TuristaHospedajeFK;
import com.idat.ec4.repositorio.TuristaRepository;
import com.idat.ec4.repositorio.DetalleReservaRepository;
import com.idat.ec4.repositorio.DetalleTuristaRepository;
import com.idat.ec4.repositorio.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository aularepo;
	
	@Autowired
	private DetalleReservaRepository detallerepo;
	
	@Autowired
	private OpenFeignClient client;
	
	@Override
	public void guardarReserva(Reserva reserva) {
		aularepo.save(reserva);
	}

	@Override
	public void asignarReservaHospedaje() {
		List<HospedajeDTO> listado = client.listarHospedajes();
		ReservaHospedajeFK fk = null;
		ReservaDetalle detalle = null;
		
		for (HospedajeDTO hospedajeDTO : listado) {
			fk = new ReservaHospedajeFK();
			fk.setIdHospedaje(hospedajeDTO.getIdHospedaje());
			fk.setIdReserva(1);
			
			detalle = new ReservaDetalle();
			detalle.setFk(fk);
			detallerepo.save(detalle);
		}
		}
		

}
