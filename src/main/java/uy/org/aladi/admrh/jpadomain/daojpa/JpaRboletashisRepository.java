package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rboletashis;
import uy.org.aladi.admrh.jpadomain.repository.RboletashisRepository;

@Repository("rboletashisRepository")
public class JpaRboletashisRepository extends JpaRepository<Rboletashis, Long> implements RboletashisRepository, Serializable {

	private static final long serialVersionUID = 640853761630243688L;

	public JpaRboletashisRepository() {
		super(Rboletashis.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboletashis> getByFuncionario(Long idgplanta, Date desde, Date hasta) {
		return entityManager.createQuery("from Rboletashis rb where rb.idGplanta =:id and " +
				"rb.fecha >=:desde and rb.fecha <=:hasta")
				.setParameter("id", idgplanta)
				.setParameter("desde", desde)
				.setParameter("hasta", hasta)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboletashis> getAutorizadas() {
		Boolean aut = true;
		Boolean proc = false;
		List<Rboletashis> lst = entityManager.createQuery("from Rboletashis rb where rb.autorizada =:aut " +
				"and rb.procesadaRH =:pro")
				.setParameter("aut", aut)
				.setParameter("pro", proc)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rboletashis> getNoAutorizadas() {
		try{
			Boolean aut = false;
			List<Rboletashis> lst = entityManager.createQuery("from Rboletashis rb where rb.autorizada =:aut ")
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
	public List<Rboletashis> getEnviadasRH() {
		Boolean env = true;
		Boolean proc = false;
		List<Rboletashis> lst = entityManager.createQuery("from Rboletashis rb where rb.enviadaRH =:env " +
				"and rb.procesadaRH =:pro")
				.setParameter("env", env)
				.setParameter("pro", proc)
				.getResultList();
		return lst;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboletashis> getEnviadaAjefe(Short tarjeta) {
		Boolean procesada = false;
		return entityManager.createQuery("from Rboletashis rb where rb.jefeTarjeta =:tarjeta " +
				"and rb.procesadaRH =:procesada")
				.setParameter("tarjeta", tarjeta)
				.setParameter("procesada", procesada)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rboletashis> getEnviadasAJefeSinAut(Short tarjeta) {
		Boolean autorizada = false;
		return entityManager.createQuery("from Rboletashis rb where rb.jefeTarjeta =:tarjeta " +
				"and rb.autorizada =:autorizada")
				.setParameter("tarjeta", tarjeta)
				.setParameter("autorizada", autorizada)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rboletashis> getTodasByFuncionario(Long idgplanta) {
		return entityManager.createQuery("from Rboletashis rb where rb.idGplanta =:id ")
				.setParameter("id", idgplanta)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboletashis> getSinAutorizarByFuncionario(Long idgplanta) {
		Boolean aut = false;
		return entityManager.createQuery("from Rboletashis rb where rb.idGplanta =:id " +
				"and rb.autorizada =:aut")
				.setParameter("id", idgplanta)
				.setParameter("aut", aut)
				.getResultList();
	}


	@Override
	@Transactional
	public String agregarNuevos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Rboletashis (idGplanta, fecha, horaDesde, horaHasta, idRCodigos, enviadaJefe, " +
					"enviadaRH, autorizada, jefeAutorizante, jefeEmail, jefeTarjeta, motivo, procesadaRH)" +
					" select rb.gplanta.idGplanta, rb.fecha, rb.horaDesde, rb.horaHasta, rb.rcodigos.idRcodigos, " +
					"rb.enviadaJefe, rb.enviadaRH, rb.autorizada, rb.jefeAutorizante, rb.jefeEmail, rb.jefeTarjeta, " +
					"rb.motivo, rb.procesadaRH from Rboleta rb").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

}
