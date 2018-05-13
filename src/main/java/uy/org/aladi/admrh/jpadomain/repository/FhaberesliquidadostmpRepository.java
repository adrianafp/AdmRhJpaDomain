package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fhaberesliquidadostmp;

public interface FhaberesliquidadostmpRepository extends Repository<Fhaberesliquidadostmp, Long>{

	Boolean deleteAll();
	List<Fhaberesliquidadostmp> getByFuncionario(Short tarjeta);
}
