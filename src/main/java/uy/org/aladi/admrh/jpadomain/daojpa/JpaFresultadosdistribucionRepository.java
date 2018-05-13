package uy.org.aladi.admrh.jpadomain.daojpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fresultadosdistribucion;
import uy.org.aladi.admrh.jpadomain.repository.FresultadosdistribucionRepository;

@Repository("fresultadosdistribucionRepository")
public class JpaFresultadosdistribucionRepository extends JpaRepository<Fresultadosdistribucion, Long> implements FresultadosdistribucionRepository  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5832770924419954832L;

	public JpaFresultadosdistribucionRepository() {
		super(Fresultadosdistribucion.class);
	}

	@SuppressWarnings("unchecked")
	public List<Fresultadosdistribucion> getByMesDistrib(String mesLiquidacion) {
		try{
			List<Fresultadosdistribucion> lst = entityManager.createQuery("from " +
					"Fresultadosdistribucion frd where frd.mesLiquidacion =:mes " +
					"order by frd.gplanta.tarjeta")
					.setParameter("mes", mesLiquidacion)
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;			
		}
	}

	@SuppressWarnings("unchecked")
	public List<Fresultadosdistribucion> getByMesFinal(String anioMes) {
		List<Fresultadosdistribucion> lst = entityManager.createQuery("from Fresultadosdistribucion frd " +
				"where frd.mesFinal =:mes")
				.setParameter("mes", anioMes)
				.getResultList();
		
		return lst;
	}

	public BigDecimal getTotNumerales(String anioMes) {
		BigDecimal valor = (BigDecimal)entityManager.createQuery("select Sum(frd.numeralesFuncionario) " +
				"from Fresultadosdistribucion frd where frd.mesFinal =:mes")
				.setParameter("mes", anioMes)
				.getSingleResult();
		return valor;
	}

	public BigDecimal getTotIntereses(String anioMes) {
		BigDecimal valor =(BigDecimal)entityManager.createQuery("select Sum(frd.distribucionFuncionario) " +
				"from Fresultadosdistribucion frd where frd.mesFinal =:mes")
				.setParameter("mes", anioMes)
				.getSingleResult();
		return valor;
	}

	public String getUltimoMesFinal() {
		return (String) entityManager.createQuery("select Max(frd.mesFinal) from Fresultadosdistribucion frd")
				.getSingleResult();

	}

	public String getPrimerMesInicial(String anio) {
	
		return (String) entityManager.createQuery("select Min(frd.mesInicial) from " +
				"Fresultadosdistribucion frd where substring(frd.mesLiquidacion, 1,4) =:aAct")
				.setParameter("aAct", anio)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Fresultadosdistribucion> getByMesesyFunc(String mesInicial,
			String mesFinal, Short tarjeta) {
		List<Fresultadosdistribucion> ldist = new ArrayList<Fresultadosdistribucion>();
		ldist = entityManager.createQuery("from Fresultadosdistribucion frd where " +
		"frd.tarjeta =:tar and frd.mesInicial >=:mes1 and frd.mesFinal <=:mes2")
		.setParameter("tar", tarjeta)
		.setParameter("mes1", mesInicial)
		.setParameter("mes2", mesFinal)
		.getResultList();
		return ldist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> listMesInicial() {
		return entityManager.createQuery("select distinct fdi.mesInicial from Fresultadosdistribucion fdi").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> listMesFinal() {
		return entityManager.createQuery("select distinct fdi.mesFinal from Fresultadosdistribucion fdi").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fresultadosdistribucion> getByPeriodo(String mesInicial,
			String mesFinal) {
		List<Fresultadosdistribucion> ldist = new ArrayList<Fresultadosdistribucion>();
		ldist = entityManager.createQuery("from Fresultadosdistribucion frd where " +
		"frd.mesInicial >=:mes1 and frd.mesFinal <=:mes2")
		.setParameter("mes1", mesInicial)
		.setParameter("mes2", mesFinal)
		.getResultList();
		return ldist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> listMesesFinalesPosteriores(String mesinicial) {
		return entityManager.createQuery("select distinct fdi.mesFinal from Fresultadosdistribucion fdi " + 
				"where fdi.mesFinal >:mesini")
				.setParameter("mesini", mesinicial)
				.getResultList();
	}

}
