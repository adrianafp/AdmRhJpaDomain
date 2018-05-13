package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fafiliaciones;
import uy.org.aladi.admrh.jpadomain.entities.Fmutualistas;
import uy.org.aladi.admrh.jpadomain.entities.Fmutualistasplanes;
import uy.org.aladi.admrh.jpadomain.entities.Gcargas;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.FmutualistasplanesRepository;

@Repository("fmutualistasplanesRepository")
public class JpaFmutualistasplanesRepository extends JpaRepository<Fmutualistasplanes, Integer> implements FmutualistasplanesRepository{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8898421711229203318L;

	public JpaFmutualistasplanesRepository(){
		super(Fmutualistasplanes.class);
	}

	@SuppressWarnings("unchecked")
	public List<Fmutualistasplanes> getPlanesByMutualista(Fmutualistas mutual) {
		List<Fmutualistasplanes> lst = entityManager.createQuery("from Fmutualistasplanes fmp " +
				"where fmp.fmutualistas.idFmutualistas =:id")
				.setParameter("id", mutual.getIdFmutualistas())
				.getResultList();
		return lst;
	}

	public List<Gplanta> getFuncByPlan(Fmutualistasplanes plan) {
		
		List<Gplanta> lst = plan.getGplanta();
		return lst;
	}

	public List<Gcargas> getCargasByPlan(Fmutualistasplanes plan) {
		List<Gcargas> lst = plan.getGcargas();
		return lst;
	}

	public List<Fafiliaciones> getAfilByPlan(Fmutualistasplanes plan) {
		
		List<Fafiliaciones> lst = plan.getFafiliaciones();
		return lst;
	}


}
