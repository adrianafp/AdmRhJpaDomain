package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rresumencomp;


public interface RresumencompRepository extends Repository<Rresumencomp, Long>{
	String deleteAll();
	List<Rresumencomp> getAllByAnioMes(String anioMes);
	List<Rresumencomp> getByCodigoyAnioMes(Short idcod, String anioMes);

}
