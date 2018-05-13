package uy.org.aladi.admrh.jpadomain.repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rparam;

public interface RparamRepository extends Repository<Rparam, Integer>{

	List<Rparam> getByFechaDesde(Date fecha);
	List<Rparam> getTodosOrdenados();
	String actualizarFechaFin(Integer id, Date fecha, Time hora);
	Rparam getByFecha(Date fecha);
	List<Rparam> getByPeriodo(Date fechac, Date fechaf);
}
