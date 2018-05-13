package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fcostoaladihist;

public interface FcostoaladihistRepository extends Repository<Fcostoaladihist, Long> {

	Boolean insertByAnioMes(String anioMes);
	Boolean insertFromAnual();
	List<Fcostoaladihist> selectByAnioMes(String anioMes);
	Boolean insertFromAnualByFuncionario(Short tarjeta);
	Boolean insertFromEgresoByFuncionario(Short tarjeta);
}
