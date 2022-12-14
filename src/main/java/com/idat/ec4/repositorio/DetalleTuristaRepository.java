package com.idat.ec4.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.ec4.modelo.TuristaDetalle;


@Repository
public interface DetalleTuristaRepository extends JpaRepository<TuristaDetalle, Integer> {

}
