package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fparametroshist;
import uy.org.aladi.admrh.jpadomain.repository.FparametroshistRepository;

@Repository("fparametroshistRepository")
public class JpaFparametroshistRepository extends JpaRepository<Fparametroshist, Long> implements FparametroshistRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFparametroshistRepository(){
		super(Fparametroshist.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fparametroshist> getByidParametro(Long id) {
		List<Fparametroshist> lst = entityManager.createQuery("from Fparametroshist fph where " +
				"fph.idFparametros =:id")
				.setParameter("id", id)
				.getResultList();
		return lst;
	}
		
}
