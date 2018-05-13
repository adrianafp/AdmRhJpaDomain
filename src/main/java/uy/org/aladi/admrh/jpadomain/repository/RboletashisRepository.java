package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rboletashis;

public interface RboletashisRepository extends Repository<Rboletashis, Long> {

	String agregarNuevos();
	List<Rboletashis> getByFuncionario(Long idgplanta, Date desde, Date hasta);
	List<Rboletashis> getEnviadaAjefe(Short tarjeta);
	List<Rboletashis> getEnviadasAJefeSinAut(Short tarjeta);
	List<Rboletashis> getAutorizadas();
	List<Rboletashis> getNoAutorizadas();
	List<Rboletashis> getEnviadasRH();
	List<Rboletashis> getTodasByFuncionario(Long idgplanta);
	List<Rboletashis> getSinAutorizarByFuncionario(Long idgplanta);
}
