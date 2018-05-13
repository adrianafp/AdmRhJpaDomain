package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Ffonasa;

public interface FfonasaRepository extends Repository<Ffonasa, Short> {
	Ffonasa getPorUnRango(Short edad1, Short edad2);
}
