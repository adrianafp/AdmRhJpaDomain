package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fprestamosconsumohist;

public interface FprestamosconsumohistRepository extends Repository<Fprestamosconsumohist, Integer> {

	List<Fprestamosconsumohist> getByFunc(Long idFunc);
	
}
