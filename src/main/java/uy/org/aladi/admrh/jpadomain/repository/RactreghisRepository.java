package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Ractreghis;


public interface RactreghisRepository extends Repository<Ractreghis, Long>{
	
	List<String> getAnioMes();
	List<Ractreghis> getAllByAnioMes(String anioMes);
	Ractreghis getByTarjetayAniomes(Short tarjeta, String aniomes);
	List<Ractreghis> getByTarjetayPeriodo(Short tarjeta, String anioMes1, String anioMes2);
	List<Ractreghis> getAllByPeriodo(String anioMes1, String anioMes2);
	List<Ractreghis> getByDeptoyPeriodo(String tarjetas, String anioMes1, String anioMes2);
	String agregarNuevos();
	
}
