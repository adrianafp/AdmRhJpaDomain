package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fprestamosconsumo;
import uy.org.aladi.admrh.jpadomain.repository.FprestamosconsumoRepository;

@Repository("fprestamosconsumoRepository")
public class JpaFprestamosconsumoRepository extends JpaRepository<Fprestamosconsumo, Integer> implements FprestamosconsumoRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFprestamosconsumoRepository(){
		super(Fprestamosconsumo.class);
	}


	@SuppressWarnings("unchecked")
	public List<Fprestamosconsumo> getByFunc(Long idFunc) {
		try{
			List<Fprestamosconsumo>lst = entityManager.createQuery("from Fprestamosconsumo fp where " +
					"fp.gplanta.idGplanta =:id")
					.setParameter("id", idFunc)
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	public List<Fprestamosconsumo> getPrstConNros(String nros) {
		return entityManager.createQuery("from Fprestamosconsumo fpc where " +
				"fpc.nroPrestamo IN (" + nros + ")")
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Fprestamosconsumo> getPrstSinNros(String nros) {
		return entityManager.createQuery("from Fprestamoscosumo fpc where " +
				"fpc.nroPrestamo NOT IN (" + nros + ")")
				.getResultList();
	}
		
}
