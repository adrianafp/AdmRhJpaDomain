package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rlicencia;

public interface RlicenciasRepository extends Repository<Rlicencia, Long> {

	List<Rlicencia> getByFuncionario(Long idgplanta, Date desde, Date hasta);
	List<Rlicencia> getEnviadaAjefe(Short tarjeta);
	List<Rlicencia> getEnviadasAJefeSinAut(Short tarjeta);
	List<Rlicencia> getEnviadasAAsesoria();
	List<Rlicencia> getEnviadasAAsesoriaSinAut();
	List<Rlicencia> getAutorizadas();
	List<Rlicencia> getNoAutorizadas();
	List<Rlicencia> getEnviadasRH();
	List<Rlicencia> getEnProcesoByFuncionario(Long id);
	List<Rlicencia> getTodasByFuncionario(Long idgplanta);
	List<Rlicencia> getTodasByFuncionarioyCodigo(Long idgplanta, Short idcodigo);
	List<Rlicencia> getSinAutorizarByFuncionario(Long idgplanta);
	Rlicencia getUltimaByFuncionario(Long idgplanta);
	Rlicencia getUltimaByFuncionarioyCodigo(Long idgplanta, Short idCodigo);
	List<Rlicencia> getByFuncCodigoyAnio(Long idgplanta, Short idCodigo, Integer anio);
	List<Rlicencia> getTodasByYear(Integer anio);
}
