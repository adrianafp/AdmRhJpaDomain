package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Fparamcargas;

public interface FparamcargasRepository extends Repository<Fparamcargas, Long>{

	Fparamcargas getByIdCarga(Integer id);
}
