package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rajustehis;

public interface RajustehisRepository extends Repository<Rajustehis, Integer>{

	List<Rajustehis> getByFuncionario(Short tarjeta);
	String agregarNuevos();
}
