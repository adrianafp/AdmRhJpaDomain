package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fcostoaladiegresos;

public interface FcostoaladiegresosRepository extends Repository<Fcostoaladiegresos, Long>{

	Boolean deleteAll();
	String deleteByFunc(Short tarjeta);
	List<Fcostoaladiegresos> getByFuncionario(Short tarjeta);
	Fcostoaladiegresos getByFuncyMesLiquidacion(Short tarjeta, String mesLiq);
	List<Fcostoaladiegresos> getByMesLiquidacion(String mesLiq);
}
