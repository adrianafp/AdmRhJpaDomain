package uy.org.aladi.admrh.jpadomain.repository;

import java.math.BigDecimal;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fhaberesliquidados;

public interface FhaberesliquidadosRepository extends Repository<Fhaberesliquidados, Long>{

	List<Fhaberesliquidados> getByMesLiquidacion(String mesLiquidacion);
	List<Short> getCodigos();
	String eliminarTodos();
	List<Fhaberesliquidados> getByCabezal(Integer idCabezal);
	List<Fhaberesliquidados> getByCodigo(Short idcod);
	List<Fhaberesliquidados> getByFuncionario(Short tarjeta);
	List<Fhaberesliquidados> getByMesLiquidacionyFuncionario(String mesLiquidacion, Short tarjeta);
	Fhaberesliquidados getByFuncionarioyCodigo(Short tarjeta, Short idcod);
	String getMesLiquidacionByFuncionario(Short tarjeta);
	String eliminarUno(Short tarjeta);
	BigDecimal getSumaBasicos(Short tarjeta);
	BigDecimal getSumaByCodigoyMoneda(Short idCod, String moneda);
}
