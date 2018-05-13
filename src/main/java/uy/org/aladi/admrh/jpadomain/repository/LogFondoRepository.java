package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Flogfondo;
import uy.org.aladi.admrh.jpadomain.repository.criteria.LogFondoSearchCriteria;

public interface LogFondoRepository extends Repository<Flogfondo, Integer> {

	List<Flogfondo> getByCriteria(LogFondoSearchCriteria criteria);
	List<String> getCategorias();
}
