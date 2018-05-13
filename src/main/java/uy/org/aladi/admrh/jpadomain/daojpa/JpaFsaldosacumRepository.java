package uy.org.aladi.admrh.jpadomain.daojpa;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import uy.org.aladi.admrh.jpadomain.entities.Fsaldosacum;
import uy.org.aladi.admrh.jpadomain.repository.FsaldosacumRepository;

@Repository("fsaldosacumRepository")
public class JpaFsaldosacumRepository extends JpaRepository<Fsaldosacum, Integer> implements FsaldosacumRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFsaldosacumRepository(){
		super(Fsaldosacum.class);
	}


	public Fsaldosacum getByFunc(Short tarjeta) {
		try{
		Fsaldosacum saldo = (Fsaldosacum)entityManager.createQuery("from Fsaldosacum fs where " +
				"fs.tarjeta =:id")
				.setParameter("id", tarjeta)
				.getSingleResult();
		return saldo;
		}
		catch(NoResultException ex){
			return null;
		}
	}
		
}
