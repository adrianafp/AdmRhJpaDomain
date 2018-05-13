package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Rlicencia;
import uy.org.aladi.admrh.jpadomain.repository.RlicenciasRepository;

@Repository("rlicenciaRepository")
public class JpaRlicenciaRepository extends JpaRepository<Rlicencia, Long> implements RlicenciasRepository, Serializable {

	private static final long serialVersionUID = 640853761630243688L;

	public JpaRlicenciaRepository() {
		super(Rlicencia.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getByFuncionario(Long idgplanta, Date desde, Date hasta) {
		return entityManager.createQuery("from Rlicencia rl where rl.gplanta.idGplanta =:id and " +
				"rl.fechaDesde >=:desde and rl.fechaDesde <=:hasta")
				.setParameter("id", idgplanta)
				.setParameter("desde", desde)
				.setParameter("hasta", hasta)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getAutorizadas() {
		Boolean aut = true;
		Boolean proc = false;
		List<Rlicencia> lst = entityManager.createQuery("from Rlicencia rl where rl.autorizada =:aut " +
				"and rl.procesadaRH =:pro")
				.setParameter("aut", aut)
				.setParameter("pro", proc)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getNoAutorizadas() {
		try{
			Boolean aut = false;
			List<Rlicencia> lst = entityManager.createQuery("from Rlicencia rl where rl.autorizada =:aut ")
					.setParameter("aut", aut)
					.getResultList();
			return lst;			
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getEnviadasRH() {
		Boolean env = true;
		Boolean proc = false;
		List<Rlicencia> lst = entityManager.createQuery("from Rlicencia rl where rl.enviadaRH =:env " +
				"and rl.procesadaRH =:pro")
				.setParameter("env", env)
				.setParameter("pro", proc)
				.getResultList();
		return lst;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getEnviadaAjefe(Short tarjeta) {
		Boolean procesada = false;
		return entityManager.createQuery("from Rlicencia rl where rl.jefeTarjeta =:tarjeta " +
				"and rl.procesadaRH =:procesada")
				.setParameter("tarjeta", tarjeta)
				.setParameter("procesada", procesada)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getEnviadasAJefeSinAut(Short tarjeta) {
		Boolean autorizada = false;
		return entityManager.createQuery("from Rlicencia rl where rl.jefeTarjeta =:tarjeta " +
				"and rl.autorizada =:autorizada")
				.setParameter("tarjeta", tarjeta)
				.setParameter("autorizada", autorizada)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getEnviadasAAsesoria() {
		Boolean procesada = false;
		Short tarjeta = Short.valueOf("0");
		return entityManager.createQuery("from Rlicencia rl where rl.jefeTarjeta =:tarjeta " +
				"and rl.procesadaRH =:procesada")
				.setParameter("tarjeta", tarjeta)
				.setParameter("procesada", procesada)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getEnviadasAAsesoriaSinAut() {
		Boolean autorizada = false;
		Short tarjeta = Short.valueOf("0");
		return entityManager.createQuery("from Rlicencia rl where rl.jefeTarjeta =:tarjeta " +
				"and rl.autorizada =:autorizada")
				.setParameter("tarjeta", tarjeta)
				.setParameter("autorizada", autorizada)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getTodasByFuncionario(Long idgplanta) {
		return entityManager.createQuery("from Rlicencia rl where rl.gplanta.idGplanta =:id ")
				.setParameter("id", idgplanta)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getTodasByFuncionarioyCodigo(Long idgplanta,
			Short idcodigo) {
		return entityManager.createQuery("from Rlicencia rl where rl.gplanta.idGplanta =:id and " +
				"rl.rcodigos.idRcodigos =:cod order by rl.fechaDesde")
				.setParameter("id", idgplanta)
				.setParameter("cod", idcodigo)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getSinAutorizarByFuncionario(Long idgplanta) {
		Boolean aut = false;
		return entityManager.createQuery("from Rlicencia rl where rl.gplanta.idGplanta =:id " +
				"and rl.autorizada =:aut")
				.setParameter("id", idgplanta)
				.setParameter("aut", aut)
				.getResultList();
	}


	@Override
	public Rlicencia getUltimaByFuncionario(Long idgplanta) {
		Date fecha = (Date)entityManager.createQuery("select max(rl.fechaDesde) from Rlicencia rl " +
				"where rl.gplanta.idGplanta =:id")
				.setParameter("id", idgplanta)
				.getSingleResult();
		
		Rlicencia bol = (Rlicencia)entityManager.createQuery("from Rlicencia rl where rl.gplanta.idGplanta =:id " +
				"and rl.fechaDesde =:fecha")
				.setParameter("id", idgplanta)
				.setParameter("fecha", fecha)
				.getSingleResult();
		
		return bol;
	}


	@Override
	public Rlicencia getUltimaByFuncionarioyCodigo(Long idgplanta,
			Short idCodigo) {
		
		try{
			java.sql.Date fecha = (java.sql.Date)entityManager.createQuery("select max(rl.fechaDesde) from Rlicencia rl " +
					"where rl.gplanta.idGplanta =:id and rl.rcodigos.idRcodigos =:cod")
					.setParameter("id", idgplanta)
					.setParameter("cod", idCodigo)
					.getSingleResult();

			Rlicencia bol = (Rlicencia)entityManager.createQuery("from Rlicencia rl where rl.gplanta.idGplanta =:id " +
					"and rl.fechaDesde =:fecha and rl.rcodigos.idRcodigos =:cod")
					.setParameter("id", idgplanta)
					.setParameter("fecha", fecha)
					.setParameter("cod", idCodigo)
					.getSingleResult();
			
			return bol;			
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getByFuncCodigoyAnio(Long idgplanta, Short idCodigo,
			Integer anio) {
		try{
		List<Rlicencia> lst = entityManager.createQuery("from Rlicencia rl where rl.gplanta.idGplanta =:id " +
			"and rl.rcodigos.idRcodigos =:cod and year(rl.fechaDesde) =:anio")
			.setParameter("id", idgplanta)
			.setParameter("cod", idCodigo)
			.setParameter("anio", anio)
			.getResultList();
		return lst;
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getTodasByYear(Integer anio) {
		try{
			return entityManager.createQuery("from Rlicencia rl where year(rl.fechaSolicitud) =:anio " +
					"order by rl.gplanta.idGplanta, rl.rcodigos.idRcodigos, rl.fechaDesde")
					.setParameter("anio", anio)
					.getResultList();			
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rlicencia> getEnProcesoByFuncionario(Long id) {
		Boolean procesada = false;
		return entityManager.createQuery("from Rlicencia rl where rl.gplanta.idGplanta =:id " +
				"and rl.procesadaRH =:procesada")
				.setParameter("id", id)
				.setParameter("procesada", procesada)
				.getResultList();
	}

}
