package uy.org.aladi.admrh.jpadomain.repository;

import java.sql.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fprestamos;
import uy.org.aladi.admrh.jpadomain.entities.summary.SaldosPrestamosSummary;

public interface FprestamosRepository extends Repository<Fprestamos, Integer> {

	List<Fprestamos> getByFunc(Long idFunc);
	List<Fprestamos> getByCesion();
	List<Fprestamos> getNuevos();
	List<Fprestamos> getPrstsConNros(Boolean nuevo, String lstNros);
	List<Fprestamos> getPrstsSinNros(Boolean nuevo, String lstNros);
	List<Fprestamos> getPrstsByTipo(Boolean nuevo, Short tipo);
	List<Fprestamos> getNoNuevos();
	void deleteAmortizados();
	void deletePorCierreCta(String prstQL);
	Date maxFechaSaldo();
	List<Fprestamos> getOrdenadosByTarjeta();
	List<SaldosPrestamosSummary> getSumaSaldosByTarjeta();
}
