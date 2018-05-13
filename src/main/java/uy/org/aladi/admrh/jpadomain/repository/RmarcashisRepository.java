package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rmarcashis;


public interface RmarcashisRepository extends Repository<Rmarcashis, Integer>{

	List<Rmarcashis> getByTarjeta(Short tarjeta);
	List<Rmarcashis> getByTarjetayPeriodo(Short tarjeta, Date fecha1, Date fecha2);
	String agregarNuevos();
}
