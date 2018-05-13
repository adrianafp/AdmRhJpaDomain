package uy.org.aladi.admrh.jpadomain.repository;


import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fsaldos;

public interface FsaldosRepository extends Repository<Fsaldos, Integer> {

	Fsaldos getByFunc(Short tarjeta);
	List<Fsaldos> getSaldosConsolidables();

}
