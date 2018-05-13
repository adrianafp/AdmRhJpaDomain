package uy.org.aladi.admrh.jpadomain.daojpa;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fsaldos;
import uy.org.aladi.admrh.jpadomain.repository.FsaldosRepository;

@Repository("fsaldosRepository")
public class JpaFsaldosRepository extends JpaRepository<Fsaldos, Integer> implements FsaldosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFsaldosRepository(){
		super(Fsaldos.class);
	}


	public Fsaldos getByFunc(Short tarjeta) {
		try{
			Fsaldos lst = (Fsaldos)entityManager.createQuery("from Fsaldos fs where " +
					"fs.tarjeta =:id")
					.setParameter("id", tarjeta)
					.getSingleResult();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	public List<Fsaldos> getSaldosConsolidables() {
		try{
			BigDecimal cap = BigDecimal.ZERO;
			
			List<Fsaldos> lstSaldos = entityManager.createQuery("from Fsaldos fs where fs.capitalIntegAntes >:cap")
					.setParameter("cap", cap)
					.getResultList();
			return lstSaldos;
		}
		catch(NoResultException nex){
			return null;
		}
	}
		
}
