package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Gbajacargas;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.GbajacargasRepository;

@Repository("gbajacargasRepository")
public class JpaGbajacargasRepository extends JpaRepository<Gbajacargas, Integer> implements GbajacargasRepository{


	/**
	 * 
	 */
	private static final long serialVersionUID = 421959490081882825L;


	public JpaGbajacargasRepository(){
		super(Gbajacargas.class);
	}


	@SuppressWarnings("unchecked")
	public List<Gbajacargas> getByFuncionario(Gplanta func) {
		try{
			List<Gbajacargas> lst = entityManager.createQuery("from Gcargas gc where " + 
					"gc.gplanta.idGplanta =:id")
					.setParameter("id", func.getIdGplanta())
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}


}
