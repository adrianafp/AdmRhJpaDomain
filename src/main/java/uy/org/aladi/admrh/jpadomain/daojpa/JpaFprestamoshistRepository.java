package uy.org.aladi.admrh.jpadomain.daojpa;

import java.sql.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fprestamoshist;
import uy.org.aladi.admrh.jpadomain.repository.FprestamoshistRepository;

@Repository("fprestamoshistRepository")
public class JpaFprestamoshistRepository extends JpaRepository<Fprestamoshist, Integer> implements FprestamoshistRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaFprestamoshistRepository() {
		super(Fprestamoshist.class);

	}

	@SuppressWarnings("unchecked")
	public List<Fprestamoshist> getByFunc(Long idfunc) {
		return entityManager.createQuery("from Fprestamoshist ph where ph.idGplanta =:id")
				.setParameter("id", idfunc)
				.getResultList();
	}

	public Fprestamoshist getByNroPrst(Integer nro) {
		try{
			return (Fprestamoshist) entityManager.createQuery("from Fprestamoshist ph where ph.nroPrestamo =:nro")
					.setParameter("nro", nro)
					.getSingleResult();			
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fprestamoshist> getApartirDe(Date fecha) {
		try{
			List<Fprestamoshist> lstPrst = entityManager.createQuery("from Fprestamoshist fph " +
					"where fph.fechaSaldo >=:fec")
					.setParameter("fec", fecha)
					.getResultList();
			return lstPrst;
		}
		catch(NoResultException nex){
			return null;			
		}
	}

}
