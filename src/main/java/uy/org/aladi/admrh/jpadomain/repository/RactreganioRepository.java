package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Ractreganio;


public interface RactreganioRepository extends Repository<Ractreganio, Long>{
	
	List<String> getLstAnioMes();
	List<Ractreganio> getAllByAnioMes(String anioMes);
	Ractreganio getByTarjetayAniomes(Short tarjeta, String aniomes);
	List<Ractreganio> getByTarjetayPeriodo(Short tarjeta, String anioMes1, String anioMes2);
	List<Ractreganio> getAllByPeriodo(String anioMes1, String anioMes2);
	List<Ractreganio> getByDeptoyPeriodo(String tarjetas, String anioMes1, String anioMes2);
	List<String> periodoExistente(String anioMes1, String anioMes2);
	List<String> periodoExistenteByFuncionario(Short tarjeta, String anioMes1, String anioMes2);
	String eliminarTodos();
	List<Ractreganio> getExtrasSimples(String anioMes);
	List<Ractreganio> getExtrasDobles(String anioMes);
	List<Ractreganio> getExcAtFliar(String anioMes);
}
