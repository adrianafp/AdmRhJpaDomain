package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rboleta;

public interface RboletasRepository extends Repository<Rboleta, Long> {

	List<Rboleta> getByFuncionario(Long idgplanta, Date desde, Date hasta);
	List<Rboleta> getEnviadaAjefe(Short tarjeta);
	List<Rboleta> getEnviadasAJefeSinAut(Short tarjeta);
	List<Rboleta> getAutorizadas();
	List<Rboleta> getNoAutorizadas();
	List<Rboleta> getEnviadasRH();
	List<Rboleta> getEnviadasAasesor();
	List<Rboleta> getEnviadasAasesorSinAut();
	List<Rboleta> getEnProcesoByUsuario(Long id);
	List<Rboleta> getTodasByFuncionario(Long idgplanta);
	List<Rboleta> getSinAutorizarByFuncionario(Long idgplanta);
	Rboleta getUltimaByFuncionario(Long idgplanta);
	String eliminarAnteriores(Date fecha);
}
