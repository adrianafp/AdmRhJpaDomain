package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rresumanio;


public interface RresumanioRepository extends Repository<Rresumanio, Long>{
	Rresumanio getByTarjetaCodigoyAniomes(Short tarjeta, Short idcod, String aniomes);
	String actualizarDesdeMensual();
	String eliminarTodos();
	List<Rresumanio> getByCodigoyAnioMes(Short idcod, String anioMes);
}
