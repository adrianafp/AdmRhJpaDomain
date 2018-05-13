package uy.org.aladi.admrh.jpadomain.repository;

import java.math.BigDecimal;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fresultadosdistribucion;

public interface FresultadosdistribucionRepository extends Repository<Fresultadosdistribucion, Long>{

	List<Fresultadosdistribucion> getByMesDistrib(String mesLiquidacion);
	List<Fresultadosdistribucion> getByMesFinal(String anioMes);
	BigDecimal getTotNumerales(String anioMes);
	BigDecimal getTotIntereses(String anioMes);
	String getUltimoMesFinal();
	String getPrimerMesInicial(String anio);
	List<Fresultadosdistribucion> getByMesesyFunc(String mesInicial, String mesFinal, Short tarjeta);
	List<String> listMesInicial();
	List<String> listMesFinal();
	List<String> listMesesFinalesPosteriores(String mesinicial);
	List<Fresultadosdistribucion> getByPeriodo(String mesInicial, String mesFinal);
}
