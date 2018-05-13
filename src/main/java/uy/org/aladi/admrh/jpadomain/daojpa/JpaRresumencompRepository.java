package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rresumencomp;
import uy.org.aladi.admrh.jpadomain.repository.RresumencompRepository;

@Repository("rResumencompRepository")
public class JpaRresumencompRepository extends JpaRepository<Rresumencomp, Long> implements RresumencompRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRresumencompRepository(){
		super(Rresumencomp.class);
	}

	@Override
	@Transactional(readOnly=false)
	public String deleteAll() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rresumencomp r ").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rresumencomp> getAllByAnioMes(String anioMes) {
		try{
			return entityManager.createQuery("from Rresumencomp r where r.mesnro =:aniomes " +
					"order by r.tarjeta, r.rcodigos.idRcodigos")
					.setParameter("aniomes", anioMes)
					.getResultList();
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rresumencomp> getByCodigoyAnioMes(Short idcod, String anioMes) {
		try{
			return entityManager.createQuery("from Rresumencomp rrs where " +
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
