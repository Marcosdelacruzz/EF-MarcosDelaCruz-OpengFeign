package com.idat.ec4.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "detalle_reserva")
public class ReservaDetalle {
	
	@Id
	private ReservaHospedajeFK fk = new ReservaHospedajeFK();
	

}
