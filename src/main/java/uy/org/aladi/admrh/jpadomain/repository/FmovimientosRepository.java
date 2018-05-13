package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fmovimientos;
import uy.org.aladi.admrh.jpadomain.exceptions.FmovimientosException;

public interface FmovimientosRepository extends Repository<Fmovimientos, Long> {

	Boolean deleteByMesLiquidacion(String mesLiquidacion);
	Boolean deleteAntesMesLiquidacion(String mesLiquidacion);
	Boolean deleteByFuncionario(Short tarjeta);
	List<Fmovimientos> selectByMesLiquidacion(String mesLiquidacion);
	List<Fmovimientos> getByTipoyMes(Short tipo, String mesLiquidacion);
	List<Fmovimientos> getByTipoMesFunc(Short tipo, String mesLiquidacion, Short tarjeta);
	List<Fmovimientos> getByTipoFechaFunc(Short tipo, Date fecha, Short tarjeta);
	Fmovimientos lastByFunc(Short tarjeta);
	Fmovimientos aperturaCta(Short tarjeta);
	void deleteByNroPrestamo(Integer nro) throws FmovimientosException;
	List<Fmovimientos> getByFuncyPeriodo(Short tarjeta, String mesLiqinicio, String mesLiqfin);
	List<Fmovimientos> getByFuncyMesLiquidacion(Short tarjeta, String mesLiquidacion);
	List<Short> tarjetasEgresados(String mesLiquida);
	List<Fmovimientos> movimientosEgresadoByMesLiquidacion(Short tarjeta, String mesLiquidacion);
	List<Fmovimientos> getByFuncyFechaOmesLiquidacion(Short tarjeta, java.sql.Date fecha, String mesLiquida);
	
}
