package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fsolicitudprestamos;
import uy.org.aladi.admrh.jpadomain.repository.FsolicitudprestamosRepository;

@Repository("fsolicitudprestamosRepository")
public class JpaFsolicitudprestamosRepository extends JpaRepository<Fsolicitudprestamos, Integer> implements FsolicitudprestamosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFsolicitudprestamosRepository(){
		super(Fsolicitudprestamos.class);
	}


	@SuppressWarnings("unchecked")
	public List<Fsolicitudprestamos> getByFunc(Long idFunc) {
		try{
			List<Fsolicitudprestamos>lst = entityManager.createQuery("from Fsolicitudprestamos fp where " +
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
	public List<Fsolicitudprestamos> getByCesion() {
		try{
			List<Fsolicitudprestamos>lst = entityManager.createQuery("from Fsolicitudprestamos fp where " +
					"fp.cesionTarjeta != null")
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	public List<Fsolicitudprestamos> getPrstsByTipo(Short tipo) {
		return entityManager.createQuery("from Fsolicitudprestamos fp where " +
				"fp.tipoPrestamo =:tipo")
				.setParameter("tipo", tipo)
				.getResultList();
	}


	@Transactional(readOnly = false)
	public void deletePorCierreCta(Short tarjeta) {
		entityManager.joinTransaction();
		entityManager.createQuery("delete from Fsolicitudprestamos fp where fp.tarjeta =:tar")
		.setParameter("tar", tarjeta)
		.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fsolicitudprestamos> getOrdenadosByTarjeta() {
		return entityManager.createQuery("from Fsolicitudprestamos order by tarjeta").getResultList();
	}


	@Override
	public Fsolicitudprestamos getUltimaByFunc(Long idFunc) {
		Date fecha = (Date)entityManager.createQuery("select max(sol.fechaSolicitud) from Fsolicitudprestamos sol " +
				"where sol.idGPlanta =:id")
				.setParameter("id", idFunc)
				.getSingleResult();
		
		Fsolicitudprestamos sol = (Fsolicitudprestamos)entityManager.createQuery("from Fsolicitudprestamos sl where sl.idGPlanta =:id " +
				"and sl.fechaSolicitud =:fecha")
				.setParameter("id", idFunc)
				.setParameter("fecha", fecha)
				.getSingleResult();
		
		return sol;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fsolicitudprestamos> getEnviadasSinProcesar() {
		Boolean enviadas = true;
		
		return entityManager.createQuery("from Fsolicitudprestamos sl where " +
				"sl.enviadaAFondo =:env and sl.procesada is null")
				.setParameter("env", enviadas)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fsolicitudprestamos> getEnviadasAComisionSinProcesar() {
		Boolean enviadas = true;
		
		return entityManager.createQuery("from Fsolicitudprestamos sl where " +
				"sl.enviadaAComision =:env and sl.procesada is null")
				.setParameter("env", enviadas)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fsolicitudprestamos> getEnviadasAFinanzasSinProcesar() {
		Boolean enviadas = true;
		
		return entityManager.createQuery("from Fsolicitudprestamos sl where " +
				"sl.enviadaAFinanzas =:env and sl.procesada is null")
				.setParameter("env", enviadas)
				.getResultList();
	}
		
}
