package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Ftipomovimiento;

public interface FtipomovimientoRepository extends Repository<Ftipomovimiento, Integer> {

	Ftipomovimiento getByTipo(Short tipo);
	
}
