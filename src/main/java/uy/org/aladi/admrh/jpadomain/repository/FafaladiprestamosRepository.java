package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fafaladiprestamos;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;

public interface FafaladiprestamosRepository extends Repository<Fafaladiprestamos, Integer> {

	List<Fafaladiprestamos> getByFunc(Long idFunc);
	List<Fafaladiprestamos> getPendientesByFunc(Long idFunc);
	List<Fafaladiprestamos> getByFuncyTipo(Long idFunc, String tipo);
	List<Fafaladiprestamos> getVigentes();
	List<Fafaladiprestamos> getByTipo(String tipo);
	Fafaladiprestamos getByNroyTipo(Integer nro, String tipo);
	Integer getMaxNroPrestamoByTipo(String tipo);
	Gplanta getTitular(Fafaladiprestamos prst);
}
