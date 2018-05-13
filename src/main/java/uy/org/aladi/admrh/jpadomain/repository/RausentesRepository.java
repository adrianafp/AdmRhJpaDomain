package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rausentes;

public interface RausentesRepository extends Repository<Rausentes, Long>{

	List<Rausentes> getTodosOrdenados();
	List<Rausentes> getByFuncionario(Short tarjeta);
	Rausentes getByFuncionarioyFecha(Short tarjeta, Date fecha);
	Boolean ausenciaRepetidaFuncionario(Short tarjeta, Date fechac, Date fechaf);
	Boolean actualizacionSolapadaFuncionario(Short tarjeta, Long idausencia, Date fechac, Date fechaf);
	List<Rausentes> getByFuncionarioyFechas(Short tarjeta, Date fechac, Date fechaf);
	String eliminarAntiguos(Date fechaTope);
	List<Rausentes> getByFuncionarioCodigoyAnio(Short tarjeta, Short cod, Integer anio);
}
