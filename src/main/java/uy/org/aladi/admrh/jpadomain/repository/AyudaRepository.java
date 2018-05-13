package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;



import uy.org.aladi.admrh.jpadomain.entities.Ayuda;
import uy.org.aladi.admrh.jpadomain.repository.criteria.AyudaSearchCriteria;

public interface AyudaRepository extends Repository<Ayuda, Integer> {

	Ayuda getByClave(String clave);
    List<Ayuda> getByCriteria(AyudaSearchCriteria criteria);
    List<Ayuda> getLstByClave(String clave);
}
