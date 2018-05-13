package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rmarcanio;


public interface RmarcanioRepository extends Repository<Rmarcanio, Integer>{

	List<Rmarcanio> getByTarjeta(Short tarjeta);
	List<Rmarcanio> getByTarjetayFecha(Short tarjeta, Date fecha);
	String actualizarDesdeMensual(Date ultimoDia);
	List<Rmarcanio> getByTarjetayPeriodo(Short tarjeta, Date fecha1, Date fecha2);
	String eliminarTodos();
}
