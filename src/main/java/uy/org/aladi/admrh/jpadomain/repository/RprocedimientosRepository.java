package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rprocedimientos;

public interface RprocedimientosRepository extends Repository<Rprocedimientos, Integer>{

	List<Rprocedimientos> getByCategoria(Integer cat);
	
}
