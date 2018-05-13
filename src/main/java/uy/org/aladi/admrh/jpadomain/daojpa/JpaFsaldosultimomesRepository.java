package uy.org.aladi.admrh.jpadomain.daojpa;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fsaldosultimomes;
import uy.org.aladi.admrh.jpadomain.repository.FsaldosultimomesRepository;

@Repository("fsaldosultimomesRepository")
public class JpaFsaldosultimomesRepository extends JpaRepository<Fsaldosultimomes, Integer> implements FsaldosultimomesRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFsaldosultimomesRepository(){
		super(Fsaldosultimomes.class);
	}


	public Fsaldosultimomes getByFunc(Long idFunc) {
		try{
			Fsaldosultimomes saldos = (Fsaldosultimomes) entityManager.createQuery("from Fsaldosultimomes fs where " +
					"fs.gplanta.idGplanta =:id")
					.setParameter("id", idFunc)
					.getSingleResult();
			return saldos;
			
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@Transactional(readOnly=false)
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fsaldosultimomes fs ").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@Override
	public String mesLiquidacion() {
		try{
			return (String)entityManager.createQuery("select distinct fsu.mesLiquidacion from " +
					"Fsaldosultimomes fsu").getSingleResult();
		}
		catch(NoResultException nex){
			return null;
		}
	}
		
}
