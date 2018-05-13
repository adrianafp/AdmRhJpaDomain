package uy.org.aladi.admrh.jpadomain.daojpa;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fdatosdistribintereses;
import uy.org.aladi.admrh.jpadomain.repository.FdatosdistribucionRepository;

@Repository("fdatosdistribucionRepository")
public class JpaFdatosdistribucionRepository extends JpaRepository<Fdatosdistribintereses, Long> implements FdatosdistribucionRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = -870468894180761657L;

	public JpaFdatosdistribucionRepository() {
		super(Fdatosdistribintereses.class);
	}

	public Fdatosdistribintereses getPorMesDistrib(String mesDistrib) {
		try{
			Fdatosdistribintereses datos = (Fdatosdistribintereses)entityManager.createQuery("from " +
					"Fdatosdistribintereses fdi where fdi.mesDistrib =:mes")
					.setParameter("mes", mesDistrib)
					.getSingleResult();
			return datos;
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@Override
	public String getMesUltimaDistribucion() {
		String ultimomes = (String)entityManager.createQuery("select max(fdd.mesDistrib) from Fdatosdistribintereses fdd").getSingleResult();
		return ultimomes;
	}

}
