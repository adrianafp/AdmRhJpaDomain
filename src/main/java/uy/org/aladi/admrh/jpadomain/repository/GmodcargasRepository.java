package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Gmodcargas;

public interface GmodcargasRepository extends Repository<Gmodcargas, Integer>{

	List<Gmodcargas> getNoprocesadosByFunc(Short tarjeta);
}
