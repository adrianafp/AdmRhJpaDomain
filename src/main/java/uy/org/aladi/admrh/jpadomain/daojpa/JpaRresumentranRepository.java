package uy.org.aladi.admrh.jpadomain.daojpa;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rresumentran;
import uy.org.aladi.admrh.jpadomain.exceptions.RresumenException;
import uy.org.aladi.admrh.jpadomain.repository.RresumentranRepository;

@Repository("rResumentranRepository")
public class JpaRresumentranRepository extends JpaRepository<Rresumentran, Long> implements RresumentranRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRresumentranRepository(){
		super(Rresumentran.class);
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

	@Override
	public Rresumentran getByTarjetaCodigoyAniomes(Short tarjeta, Short idcod,
			String aniomes) {
		try{
			return (Rresumentran)entityManager.createQuery("from Rresumentran rt where rt.tarjeta =:tar and " +
					"rt.rcodigos.idRcodigos =:id and rt.mesnro =:ames")
					.setParameter("tar", tarjeta)
					.setParameter("id", idcod)
					.setParameter("ames", aniomes)
					.getSingleResult();
		}
		catch(NonUniqueResultException nun){
			throw new RresumenException("Mas de un registro en Rresumentran: " + tarjeta.toString() + " con código: " + idcod.toString());
		}
		catch(NoResultException nex){
			return null;
		}
	}

}
