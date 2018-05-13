package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rausenteh;

public interface RausentehRepository extends Repository<Rausenteh, Long>{

	List<Rausenteh> getTodosOrdenados();
	List<Rausenteh> getByFuncionario(Short tarjeta);
	List<Rausenteh> getByFuncionarioyFechas(Short tarjeta, Date fechac, Date fechaf);
	String agregarNuevos(Date fechaTope);
	List<Rausenteh> getByFuncionarioCodigoyAnio(Short tarjtea, Short cod, Integer anio);
}
