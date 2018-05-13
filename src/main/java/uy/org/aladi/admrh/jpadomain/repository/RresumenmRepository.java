package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rresumenm;


public interface RresumenmRepository extends Repository<Rresumenm, Long>{
	
	String getAnioMes();
	List<Rresumenm> getAllByAnioMes(String anioMes);
	List<Rresumenm> getByCodigoyAnioMes(Short idcod, String anioMes);
	String deleteAll();
	List<Rresumenm> getByTarjetayAniomes(Short tarjeta, String aniomes);
	Rresumenm getByTarjetaCodigoyAniomes(Short tarjeta, Short idcod, String aniomes);
	String eliminarTodos();
}
