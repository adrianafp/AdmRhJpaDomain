package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fparametros;

public interface FparametrosRepository extends Repository<Fparametros, Long> {

	Fparametros getByCodigo(Short codigo);
	List<Fparametros> getByLista(String lista);
}
