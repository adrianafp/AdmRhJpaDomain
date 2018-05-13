package uy.org.aladi.admrh.jpadomain.daojpa;

import java.sql.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fprestamos;
import uy.org.aladi.admrh.jpadomain.entities.summary.SaldosPrestamosSummary;
import uy.org.aladi.admrh.jpadomain.repository.FprestamosRepository;

@Repository("fprestamosRepository")
public class JpaFprestamosRepository extends JpaRepository<Fprestamos, Integer> implements FprestamosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFprestamosRepository(){
		super(Fprestamos.class);
	}


	@SuppressWarnings("unchecked")
	public List<Fprestamos> getByFunc(Long idFunc) {
		try{
			List<Fprestamos>lst = entityManager.createQuery("from Fprestamos fp where " +
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
	public List<Fprestamos> getByCesion() {
		try{
			List<Fprestamos>lst = entityManager.createQuery("from Fprestamos fp where " +
					"fp.cesionTarjeta != null and fp.cesionTarjeta != 0")
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	public List<Fprestamos> getNuevos() {
		try{
			Boolean nuevo = true;
			List<Fprestamos>lst = entityManager.createQuery("from Fprestamos fp where " +
					"fp.prestamoNuevo =:nuevo")
					.setParameter("nuevo", nuevo)
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	public List<Fprestamos> getPrstsConNros(Boolean nuevo, String lstNros) {
		List<Fprestamos> lstprsts = entityManager.createQuery("from Fprestamos fp where fp.prestamoNuevo =:nuevo and " +
				"fp.nroPrestamo IN (" + lstNros + ")")
				.setParameter("nuevo", nuevo)
				.getResultList();
		return lstprsts;
	}


	@SuppressWarnings("unchecked")
	public List<Fprestamos> getPrstsSinNros(Boolean nuevo, String lstNros) {
		List<Fprestamos> lstprsts = entityManager.createQuery("from Fprestamos fp where fp.prestamoNuevo =:nuevo and " +
				"fp.nroPrestamo NOT IN (" + lstNros + ")")
				.setParameter("nuevo", nuevo)
				.getResultList();
		return lstprsts;
	}


	@SuppressWarnings("unchecked")
	public List<Fprestamos> getPrstsByTipo(Boolean nuevo, Short tipo) {
		return entityManager.createQuery("from Fprestamos fp where fp.prestamoNuevo =:nuevo and " +
				"fp.tipoPrestamo =:tipo")
				.setParameter("nuevo", nuevo)
				.setParameter("tipo", tipo)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Fprestamos> getNoNuevos() {
		Boolean nuevo = false;
		List<Fprestamos> lstprsts = entityManager.createQuery("from Fprestamos fp where fp.prestamoNuevo =:nuevo")
				.setParameter("nuevo", nuevo)
				.getResultList();
		return lstprsts;
	}


	@Transactional(readOnly = false)
	public void deleteAmortizados() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete From Fprestamos fp where fp.cantCuotas = fp.cuotasPagas")
			.executeUpdate();
			return;
		}
		catch(Exception ex){
			return;
		}
	}

	@Transactional(readOnly = false)
	public void deletePorCierreCta(String prstQL) {
		entityManager.joinTransaction();
		entityManager.createQuery("delete from Fprestamos fp where fp.nroPrestamo IN (" + prstQL +
				")").executeUpdate();
		
	}


	@Override
	public Date maxFechaSaldo() {
		return (Date) entityManager.createQuery("select max(fp.fechaSaldo) from Fprestamos fp").getSingleResult();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fprestamos> getOrdenadosByTarjeta() {
		List<Fprestamos> lstPrst = entityManager.createQuery("from Fprestamos fp order by fp.tarjeta").getResultList();
		return lstPrst;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<SaldosPrestamosSummary> getSumaSaldosByTarjeta() {
		List<SaldosPrestamosSummary> lstSumas = entityManager.createQuery("select new uy.org.aladi.admrh.jpadomain.entities.summary.SaldosPrestamosSummary(fp.tarjeta, Sum(fp.saldoPrestamo)) from Fprestamos fp group by fp.tarjeta")
				.getResultList();
		return lstSumas;
		
	}
		
}
