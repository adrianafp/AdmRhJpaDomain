package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fcabezalreciboshist;

public interface FcabezalreciboshistRepository extends Repository<Fcabezalreciboshist, Integer>{

	Integer getUltimoId();
	String agregarnuevos();
	String agregarUno(Short tarjeta, Short codigo);
	String actualizarCodigos(Short cod, Integer idCateg);
	List<Fcabezalreciboshist> allByMesLiquidacion(String anioMes);
	List<Fcabezalreciboshist> getByPeriodoyFuncionario(String desde, String hasta, Short tarjeta);
	List<String> getMesesAnteriores(String sAnio);
	List<Fcabezalreciboshist> getUltimos(Integer ultimoId);
	List<Fcabezalreciboshist> getCabezalesAguinaldos();
	List<Fcabezalreciboshist> getCabezalesHaberes();
}
