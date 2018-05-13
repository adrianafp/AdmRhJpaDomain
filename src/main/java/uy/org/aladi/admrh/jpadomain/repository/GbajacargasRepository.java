package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Gbajacargas;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;

public interface GbajacargasRepository extends Repository<Gbajacargas, Integer>{

	List<Gbajacargas> getByFuncionario(Gplanta func);
}
