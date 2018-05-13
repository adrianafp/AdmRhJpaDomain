package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Fcabezalrecibotmp;

public interface FcabezalrecibostmpRepository extends Repository<Fcabezalrecibotmp, Integer> {

	String eliminarTodos();
	Fcabezalrecibotmp getByFuncionario(Short tarjeta);
}
