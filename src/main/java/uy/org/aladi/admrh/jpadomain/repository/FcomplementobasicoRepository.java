package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Fcomplementobasico;

public interface FcomplementobasicoRepository extends Repository<Fcomplementobasico, Integer> {

	Fcomplementobasico getByFunc(Long idGplanta);
}
