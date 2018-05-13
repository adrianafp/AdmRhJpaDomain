package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rferiados;

public interface RferiadosRepository extends Repository<Rferiados, Integer>{

	Rferiados getByFecha(Date fecha);
	List<Rferiados> getTodos();
	String updateUno(Integer id, Date fecha, String motivo, Boolean doble);
	Boolean esFeriado(Date fecha);
}
