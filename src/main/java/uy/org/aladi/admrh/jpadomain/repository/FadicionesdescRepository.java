package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fadicionesdesc;

public interface FadicionesdescRepository extends Repository<Fadicionesdesc, Long> {

	void actualizacionPorCierredeCta(Short tarjeta);
	List<Fadicionesdesc> getConRegNulo(Short tarjeta);
	List<Fadicionesdesc> getByFuncionario(Short tarjeta);
	List<Fadicionesdesc> getByFuncionarioyCodigo(Short tarjeta, Short codigo);
	List<Fadicionesdesc> getSumas();
	List<Fadicionesdesc> getRestas();
	List<Fadicionesdesc> getTodas();
	String eliminarTodos();
	String eliminarMesAnterior(String mesLiquidacion);
	String eliminarByCodigo(Short idCod);
	List<Short> getTarjetas();
}
