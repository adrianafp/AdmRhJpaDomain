package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fadpermanentes;


public interface FadpermanentesRepository extends Repository<Fadpermanentes, Long> {

	List<Fadpermanentes> getByFuncionario(Short tarjeta);
	Fadpermanentes getByFuncionarioyCodigo(Short tarjeta, Short idcodigo);
	List<Fadpermanentes> getSumasVigentes(java.sql.Date today);
	List<Fadpermanentes> getRestasVigentes(java.sql.Date today);
	
}
