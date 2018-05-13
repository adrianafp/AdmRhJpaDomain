package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fmutualistas;
import uy.org.aladi.admrh.jpadomain.entities.Fmutualistasplanes;
import uy.org.aladi.admrh.jpadomain.repository.FmutualistasRepository;

@Repository("fmutualistasRepository")
public class JpaFmutualistasRepository extends JpaRepository<Fmutualistas, Integer> implements FmutualistasRepository {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8764317435588074267L;

	public JpaFmutualistasRepository(){
		super(Fmutualistas.class);
	}

	@SuppressWarnings("unchecked")
	public List<Fmutualistasplanes> getPlanesByMutualista(Fmutualistas mutual) {
		try{
			List<Fmutualistasplanes> lst = entityManager.createQuery("from Fmutualistasplanes fmp " +
					"where fmp.mutualistas.idFmutualistas =:id")
					.setParameter("id", mutual.getIdFmutualistas())
					.getResultList();
			
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}
}
