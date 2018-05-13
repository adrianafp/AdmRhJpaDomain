package uy.org.aladi.admrh.jpadomain.repository;

import java.math.BigDecimal;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fadicionesdescf;
import uy.org.aladi.admrh.jpadomain.exceptions.FadicionesdescfException;

public interface FadicionesdescfRepository extends Repository<Fadicionesdescf, Long> {

	Fadicionesdescf aporteFunc(Short tarjeta);
	List<Fadicionesdescf> getByFuncionario(Short tarjeta);
	void deleteByFuncImporte(Short tarjeta, BigDecimal importe) throws FadicionesdescfException;
	void actualizacionPorCierredeCta(Short tarjeta);
	String eliminarTodos();
	String limpiarMesAnterior(String mesLiq);
	List<Fadicionesdescf> getTodas();
}
