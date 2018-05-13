package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Fcostoaladisalud;

public interface FcostoaladisaludRepository extends Repository<Fcostoaladisalud, Integer>{
	String eliminarTodos();
	Fcostoaladisalud getByFuncyMesLiquidacion(Short tarjeta, String mesLiquidacion);
	String eliminarByFuncyMesLiquidacion(Short tarjeta, String mesLiquidacion);
	String eliminarByMesLiquidacion(String mesLiquidacion);
	String eliminarNotInGrupoyMesLiquidacion(String grupo, String mesLiquidacion);
}
