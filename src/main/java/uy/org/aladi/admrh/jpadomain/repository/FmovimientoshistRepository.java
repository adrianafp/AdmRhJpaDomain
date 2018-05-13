package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fmovimientoshist;

public interface FmovimientoshistRepository extends Repository<Fmovimientoshist, Long> {

	Boolean insertByAnioMes(String anioMes);
	Boolean insertByFuncionario(Short tarjeta);
	List<Short> tarjetasEgresados(String mesLiquida);
	List<Fmovimientoshist> movimientosEgresadoByMesLiquidacion(Short tarjeta, String mesLiquidacion);
	List<Fmovimientoshist> movimientosConTipoNulo();
}
