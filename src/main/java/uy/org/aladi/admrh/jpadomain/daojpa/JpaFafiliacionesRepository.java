package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fafiliaciones;
import uy.org.aladi.admrh.jpadomain.entities.Fmutualistasplanes;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.FafiliacionesRepository;

@Repository("fafiliacionesRepository")
public class JpaFafiliacionesRepository extends JpaRepository<Fafiliaciones, Long> implements FafiliacionesRepository{


	/**
	 * 
	 */
	private static final long serialVersionUID = 421959490081882825L;


	public JpaFafiliacionesRepository(){
		super(Fafiliaciones.class);
	}


	@SuppressWarnings("unchecked")
	public List<Fafiliaciones> getByFuncionario(Gplanta func) {
		
		List<Fafiliaciones> lst = entityManager.createQuery("from Fafiliaciones f where " +
				"f.tarjeta =:tar")
				.setParameter("tar", func.getTarjeta())
				.getResultList();
		return lst;
	}


	@SuppressWarnings("unchecked")
	public List<Fafiliaciones> getByMutualistaPlan(Fmutualistasplanes plan) {
		List<Fafiliaciones> lst = entityManager.createQuery("from Fafiliaciones f where " +
				"f.fmutualistasplanes.idFmutualistasPlanes =:id")
				.setParameter("id", plan.getIdFmutualistasPlanes())
				.getResultList();
		return lst;
	}

}
