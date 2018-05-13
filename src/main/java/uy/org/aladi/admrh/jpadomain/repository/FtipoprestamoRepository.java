package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Ftipoprestamo;

public interface FtipoprestamoRepository extends Repository<Ftipoprestamo, Integer> {

	List<Ftipoprestamo> getSinConsumo();
	Ftipoprestamo getByTipo(Short tipo);
	List<Ftipoprestamo> getParaSolicitud();
	List<Ftipoprestamo> getParaAfaladi();
	
}
