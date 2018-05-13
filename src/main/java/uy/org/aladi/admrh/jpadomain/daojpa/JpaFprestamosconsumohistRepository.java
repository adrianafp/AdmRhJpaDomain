package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fprestamosconsumohist;
import uy.org.aladi.admrh.jpadomain.repository.FprestamosconsumohistRepository;

@Repository("fprestamosconsumohistRepository")
public class JpaFprestamosconsumohistRepository extends JpaRepository<Fprestamosconsumohist, Integer> implements FprestamosconsumohistRepository {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7518068475882406868L;
	
	public JpaFprestamosconsumohistRepository() {
		super(Fprestamosconsumohist.class);
	}

	@SuppressWarnings("unchecked")
	public List<Fprestamosconsumohist> getByFunc(Long idFunc) {
		try{
			return entityManager.createQuery("from Fprestamosconsumohist pch.idGplanta =:id" )
					.setParameter("id", idFunc)
					.getResultList();
		}
		catch(NoResultException nex){
			return null;
		}
	}


}
