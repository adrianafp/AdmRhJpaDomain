package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fsueldomes;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.FsueldomesRepository;

@Repository("fsueldomesRepository")
public class JpaFsueldomesRepository extends JpaRepository<Fsueldomes, Long> implements FsueldomesRepository {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5094560246807996687L;

	public JpaFsueldomesRepository() {
		super(Fsueldomes.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fsueldomes> getByFunc(Gplanta func) {
		try{
			return entityManager.createQuery("from Fsueldomes fsm where fsm.gplanta.idGplanta =:id")
				.setParameter("id", func.getIdGplanta())
				.getResultList();
		}
		catch(NoResultException ex){
			return null;
		}
	}

	public Fsueldomes getByFuncyAnioMes(Gplanta func, String aniomes) {
		try{
			return (Fsueldomes)entityManager.createQuery("from Fsueldomes fsm where fsm.gplanta.idGplanta =:id " +
					"and fsm.anioMes =:aniomes")
					.setParameter("id", func.getIdGplanta())
					.setParameter("aniomes", aniomes)
					.getSingleResult();			
		}
		catch(NoResultException ex){
			return null;
		}
		
	}

}
