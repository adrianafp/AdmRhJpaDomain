package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fcabezalrecibos;

public interface FcabezalrecibosRepository extends Repository<Fcabezalrecibos, Integer> {

	String eliminarTodos();
	String getMesLiquidacion();
	Fcabezalrecibos getByFuncionario(Short tarjeta);
	String eliminarUno(Short tarjeta);
	List<Fcabezalrecibos> allByMesLiquidacion(String anioMes);
}
