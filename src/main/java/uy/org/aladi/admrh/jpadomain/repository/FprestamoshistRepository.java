package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fprestamoshist;

public interface FprestamoshistRepository extends Repository<Fprestamoshist, Integer> {

	List<Fprestamoshist> getByFunc(Long idfunc);
	Fprestamoshist getByNroPrst(Integer nro);
	List<Fprestamoshist> getApartirDe(java.sql.Date fecha);
}
