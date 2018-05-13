package uy.org.aladi.admrh.jpadomain.repository;

import java.math.BigDecimal;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fhabereshist;

public interface FhabereshistRepository extends Repository<Fhabereshist, Long> {

	String agregarNuevos();
	String actualizarIdCabezal(Integer ultimoId);
	String actualizarUnIdCabezal(Integer ultimoId, Long idHabHist);
	Long getUltimoId();
	List<Fhabereshist> getByFuncAnioCodigo(Short tarjeta, String anio, Short codigo);
	BigDecimal getSumaParaMedioAguinaldo(Short tarjeta, String mesJulio);
	BigDecimal getSumaParaAguinaldo(Short tarjeta, String anio);
	List<String> getAnioMesesByCodigo(Short codigo);
	List<Fhabereshist> getByMesLiquidacionyCodigo(String mesLiquidacion, Short codigo);
	Fhabereshist getByFuncMesLiquidacionyCodigo(Short tarjeta, String mesLiquidacion, Short codigo);
	String agregarNuevoByFunc(Short tarjeta);
	List<Fhabereshist> getHaberesPosterioresAguinaldo(Short tarjeta, String sanio);
	List<Fhabereshist> getByidCabezal(Integer idCabezal);
	List<Fhabereshist> getByFuncyMesLiquidacion(Short tarjeta, String mesLiquidacion);
}
