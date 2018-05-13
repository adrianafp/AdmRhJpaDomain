package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rajusteanio;

public interface RajusteanioRepository extends Repository<Rajusteanio, Integer>{

	List<Rajusteanio> getByFuncionario(Short tarjeta);
	List<Rajusteanio> getByFuncioanrioyMesCierre(Short tarjeta, String mesCierre, String mesAjuste);
	List<Rajusteanio> getByPasadeyMesCierre(Short codigo, String mesCierre);
	List<Rajusteanio> getByPasaDeyMesAjuste(Short codigo, String mesAjuste);
	List<Rajusteanio> getByPasaAyMesAjuste(Short codigo, String mesAjuste);
	String eliminarTodos();
}
