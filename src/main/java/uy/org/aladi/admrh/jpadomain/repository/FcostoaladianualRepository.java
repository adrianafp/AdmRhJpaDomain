package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fcostoaladianual;

public interface FcostoaladianualRepository extends Repository<Fcostoaladianual, Long>{

	Boolean deleteAll();
	List<Fcostoaladianual> getByFuncionario(Short tarjeta);
	Boolean deleteByFuncionario(Short tarjeta);
	List<String> getAllAnioMes();
	String deleteByMesLiquidacion(String anioMes);
	List<Fcostoaladianual> getByMesLiquidacion(String anioMes);
	Fcostoaladianual getByFuncyMesLiquidacion(Short tarjeta, String anioMes);
	Boolean insertFromEgresoByFuncionario(Short tarjeta);
}
