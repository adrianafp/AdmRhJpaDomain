package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Gplantahist;

public interface GplantahistRepository extends Repository<Gplantahist, Long>{
	Gplantahist getByTarjeta(Short tarjeta);
	String nombre(Short tarjeta);
	List<Short> getTarjetasEgresadosEnPeriodo(Date inicio, Date fin);
}
