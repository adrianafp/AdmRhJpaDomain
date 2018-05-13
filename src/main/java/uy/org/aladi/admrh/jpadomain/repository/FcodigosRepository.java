package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fcodigos;

public interface FcodigosRepository extends Repository<Fcodigos, Short>{

	List<Fcodigos> getAdiciones();
	List<Fcodigos> getDeducciones();
	Short getMaxCodAdiciones();
	Short getMaxCodDeducciones();
}
