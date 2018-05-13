package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rlogreloj;
import uy.org.aladi.admrh.jpadomain.repository.criteria.LogRelojSearchCriteria;

public interface RlogrelojRepository extends Repository<Rlogreloj, Integer>{

	List<String> getCategorias();
	List<Rlogreloj> getByCriteria(LogRelojSearchCriteria criteria);
	List<Rlogreloj> getMsgByFecha(Date fecha);
	List<Rlogreloj> getByControlAusencia(Date fecha) throws Exception;
}
