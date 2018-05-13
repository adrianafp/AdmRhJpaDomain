package uy.org.aladi.admrh.jpadomain.repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fmutualistasplanes;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.criteria.GplantaSearchCriteria;

public interface GplantaRepository extends Repository<Gplanta, Long>{

	Gplanta getByTarjeta(Short tarjeta);
	List<Gplanta> getByCriteria(GplantaSearchCriteria criteria);
	List<Gplanta> getConEgresos();
	List<Gplanta> getOrdenByCategoria();
	List<Gplanta> getOrdenByDepto();
	Gplanta getById(Long id);
	List<Gplanta> getByMutualistaPlan(Fmutualistasplanes plan);
	List<Gplanta> getByBanco(Integer idBco);
	List<Gplanta> getUltimosIngresos();
	List<Gplanta> getCambiosAntiguedad();
	List<Short> getTarjetasEgresos();
	List<Short> getTarjetasIngresos(Date fecha);
	List<Gplanta> getFuncsNotInGroup(String tarjetas);
	String getNombre(Short tarjeta);
	BigDecimal getBasico(Short tarjeta);
	BigDecimal getCambioBasico(Short tarjeta, String mesLiquidacion);
	BigDecimal getComplementoBasico(Long idFunc);
	List<Gplanta> getLosQueMarcan();
	List<Gplanta> getLosQueMarcanByDepto();
	List<Gplanta> getLosQueNoMarcan();
	List<Gplanta> getTodosByTarjeta();
	Short getTarjetaMenor();
}
