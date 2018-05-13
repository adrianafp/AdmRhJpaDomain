package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Fsaldosultimomes;

public interface FsaldosultimomesRepository extends Repository<Fsaldosultimomes, Integer> {

	Fsaldosultimomes getByFunc(Long idFunc);
	String eliminarTodos();
	String mesLiquidacion();
}
