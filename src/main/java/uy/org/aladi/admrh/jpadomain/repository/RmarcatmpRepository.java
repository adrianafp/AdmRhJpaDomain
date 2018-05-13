package uy.org.aladi.admrh.jpadomain.repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rmarcatmp;

public interface RmarcatmpRepository extends Repository<Rmarcatmp, Integer>{

	Rmarcatmp getFirst(Short referencia);
	List<Date> getFechas();
	List<Rmarcatmp> getMarcasPorFecha(Date fecha);
	Rmarcatmp getSiguiente(Short tarjeta, Date fecha, Time hora);
	String limpiar();
}
