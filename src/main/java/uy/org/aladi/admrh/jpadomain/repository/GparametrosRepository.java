package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Gparametros;

public interface GparametrosRepository extends Repository<Gparametros, Integer> {

	Gparametros getByCodigo(Short codigo);

}
