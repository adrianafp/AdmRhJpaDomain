package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rboleta;
import uy.org.aladi.admrh.jpadomain.repository.RboletasRepository;

@Repository("rboletaRepository")
public class JpaRboletaRepository extends JpaRepository<Rboleta, Long> implements RboletasRepository, Serializable {

	private static final long serialVersionUID = 640853761630243688L;

	public JpaRboletaRepository() {
		super(Rboleta.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboleta> getByFuncionario(Long idgplanta, Date desde, Date hasta) {
		return entityManager.createQuery("from Rboleta rb where rb.gplanta.idGPlanta =:id and " +
				"rb.fecha >=:desde and rb.fecha <=:hasta")
				.setParameter("id", idgplanta)
				.setParameter("desde", desde)
				.setParameter("hasta", hasta)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboleta> getAutorizadas() {
		Boolean aut = true;
		Boolean proc = false;
		List<Rboleta> lst = entityManager.createQuery("from Rboleta rb where rb.autorizada =:aut " +
				"and rb.procesadaRH =:pro")
				.setParameter("aut", aut)
				.setParameter("pro", proc)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rboleta> getNoAutorizadas() {
		try{
			Boolean aut = false;
			List<Rboleta> lst = entityManager.createQuery("from Rboleta rb where rb.autorizada =:aut ")
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
	public List<Rboleta> getEnviadasRH() {
		Boolean env = true;
		Boolean proc = false;
		List<Rboleta> lst = entityManager.createQuery("from Rboleta rb where rb.enviadaRH =:env " +
				"and rb.procesadaRH =:pro")
				.setParameter("env", env)
				.setParameter("pro", proc)
				.getResultList();
		return lst;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboleta> getEnviadaAjefe(Short tarjeta) {
		Boolean procesada = false;
		return entityManager.createQuery("from Rboleta rb where rb.jefeTarjeta =:tarjeta " +
				"and rb.procesadaRH =:procesada")
				.setParameter("tarjeta", tarjeta)
				.setParameter("procesada", procesada)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rboleta> getEnviadasAJefeSinAut(Short tarjeta) {
		Boolean autorizada = false;
		return entityManager.createQuery("from Rboleta rb where rb.jefeTarjeta =:tarjeta " +
				"and rb.autorizada =:autorizada")
				.setParameter("tarjeta", tarjeta)
				.setParameter("autorizada", autorizada)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rboleta> getTodasByFuncionario(Long idgplanta) {
		return entityManager.createQuery("from Rboleta rb where rb.gplanta.idGplanta =:id ")
				.setParameter("id", idgplanta)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboleta> getSinAutorizarByFuncionario(Long idgplanta) {
		Boolean aut = false;
		return entityManager.createQuery("from Rboleta rb where rb.gplanta.idGplanta =:id " +
				"and rb.autorizada =:aut")
				.setParameter("id", idgplanta)
				.setParameter("aut", aut)
				.getResultList();
	}


	@Override
	public Rboleta getUltimaByFuncionario(Long idgplanta) {
		Date fecha = (Date)entityManager.createQuery("select max(rb.fecha) from Rboleta rb " +
				"where rb.gplanta.idGplanta =:id")
				.setParameter("id", idgplanta)
				.getSingleResult();
		
		Rboleta bol = (Rboleta)entityManager.createQuery("from Rboleta rb where rb.gplanta.idGplanta =:id " +
				"and rb.fecha =:fecha")
				.setParameter("id", idgplanta)
				.setParameter("fecha", fecha)
				.getSingleResult();
		
		return bol;
	}


	@Override
	@Transactional
	public String eliminarAnteriores(Date fecha) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rboleta rb where rb.fecha <:ftope")
			.setParameter("ftope", fecha)
			.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboleta> getEnviadasAasesor() {
		Boolean procesada = false;
		Short tarjeta = Short.valueOf("0");
		return entityManager.createQuery("from Rboleta rb where rb.jefeTarjeta =:tarjeta " +
				"and rb.procesadaRH =:procesada")
				.setParameter("tarjeta", tarjeta)
				.setParameter("procesada", procesada)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboleta> getEnviadasAasesorSinAut() {
		Short tarjeta = Short.valueOf("0");
		Boolean autorizada = false;
		return entityManager.createQuery("from Rboleta rb where rb.jefeTarjeta =:tarjeta " +
				"and rb.autorizada =:autorizada")
				.setParameter("tarjeta", tarjeta)
				.setParameter("autorizada", autorizada)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rboleta> getEnProcesoByUsuario(Long id) {
		Boolean procesada = false;
		return entityManager.createQuery("from Rboleta rb where rb.gplanta.idGplanta =:id " +
				"and rb.procesadaRH =:procesada")
				.setParameter("id", id)
				.setParameter("procesada", procesada)
				.getResultList();
	}


}
