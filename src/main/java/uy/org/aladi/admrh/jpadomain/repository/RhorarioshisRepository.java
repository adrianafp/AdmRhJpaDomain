package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rhorarioshis;

public interface RhorarioshisRepository extends Repository<Rhorarioshis, Long>{

	List<Rhorarioshis> getTodosOrdenados();
	List<Rhorarioshis> getByFuncionario(Short tarjeta);
	List<Rhorarioshis> getByFuncHEnfermedad(Short tarjeta, Date fechac, Date fechaf);
	String agregarNuevos(Date fechaTope);
}
