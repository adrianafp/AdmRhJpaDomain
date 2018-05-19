package uy.org.aladi.admrh.jpadomain.repository;

import java.math.BigDecimal;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fsaldoshistoria;

public interface FsaldoshistoriaRepository extends Repository<Fsaldoshistoria, Long> {

	BigDecimal sumaPorPeriodo(String anioMes1, String anioMes2);
	BigDecimal sumaPorPeriodoyTarjetas(String anioMes1, String anioMes2, String tarjetas);
	BigDecimal numeralesFuncionario(String anioMes1, String anioMes2, Short tarjeta);
	Fsaldoshistoria getByFuncyMesLiquidacion(String mesLiquidacion, Short tarjeta);
	List<Fsaldoshistoria> getByFuncionarioyPeriodo(Short tarjeta, String anioMes1, String anioMes2);
	String deleteByMesLiquidacion(String mesLiquidacion);
	String getMaxMesLiquidacion();
	List<String> getMesesLiquidacionPorAnio(String anio);
	List<Fsaldoshistoria> getByTarjetasyMesLiquidacion(String tarjetas, String mesLiquida);
	List<Fsaldoshistoria> getByMesLiquidacion(String mesLiquida);
	Boolean insertFromSaldosByFuncionario(Short tarjeta);
	List<Fsaldoshistoria> getByMesLiquidacionyMotivo(String mesLiquida, String motivo);
	Boolean huboDistribucion(String mesLiquida);
}
