package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rresumenm;
import uy.org.aladi.admrh.jpadomain.repository.RresumenmRepository;

@Repository("rResumenmRepository")
public class JpaRresumenmRepository extends JpaRepository<Rresumenm, Long> implements RresumenmRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRresumenmRepository(){
		super(Rresumenm.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rresumenm> getAllByAnioMes(String anioMes) {
		try{
			return entityManager.createQuery("from Rresumenm r where r.mesnro =:aniomes " +
					"order by r.tarjeta, r.rcodigos.idRcodigos")
					.setParameter("aniomes", anioMes)
					.getResultList();
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String deleteAll() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rresumenm r ").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";			
		}
	}


	@Override
	public Rresumenm getByTarjetaCodigoyAniomes(Short tarjeta, Short idcod,
			String aniomes) {
		try{
			return (Rresumenm)entityManager.createQuery("from Rresumenm rr where rr.tarjeta =:tar and " +
					"rr.rcodigos.idRcodigos =:id and rr.mesnro =:ames")
					.setParameter("tar", tarjeta)
					.setParameter("id", idcod)
					.setParameter("ames", aniomes)
					.getSingleResult();
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@Override
	public String getAnioMes() {
		String anioMes = (String)entityManager.createQuery("select distinct rr.mesnro from Rresumenm rr")
				.getSingleResult();
		return anioMes;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rresumenm> getByTarjetayAniomes(Short tarjeta, String aniomes) {
		try{
			return entityManager.createQuery("from Rresumenm rr where rr.tarjeta =:tar and " +
					"rr.mesnro =:ames order by rr.rcodigos.idRcodigos")
					.setParameter("tar", tarjeta)
					.setParameter("ames", aniomes)
					.getResultList();
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@Override
	@Transactional
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rresumenm rm").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rresumenm> getByCodigoyAnioMes(Short idcod, String anioMes) {
		try{
			return entityManager.createQuery("from Rresumenm rrs where " +
					"rrs.rcodigos.idRcodigos =:cod and rrs.mesnro =:aniomes")
					.setParameter("cod", idcod)
					.setParameter("aniomes", anioMes)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}


}
