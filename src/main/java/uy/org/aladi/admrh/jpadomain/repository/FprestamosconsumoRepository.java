package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fprestamosconsumo;

public interface FprestamosconsumoRepository extends Repository<Fprestamosconsumo, Integer> {

	List<Fprestamosconsumo> getByFunc(Long idFunc);
	List<Fprestamosconsumo> getPrstConNros(String nros);
	List<Fprestamosconsumo> getPrstSinNros(String nros);

}
