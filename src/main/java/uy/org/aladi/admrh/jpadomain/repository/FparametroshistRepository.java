package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fparametroshist;

public interface FparametroshistRepository extends Repository<Fparametroshist, Long> {

	List<Fparametroshist> getByidParametro(Long id);
}
