package uy.org.aladi.admrh.jpadomain.daojpa;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fsaldoshistoria;
import uy.org.aladi.admrh.jpadomain.repository.FsaldoshistoriaRepository;

@Repository("fsaldoshistoriaRepository")
public class JpaFsaldosHistoriaRepository extends JpaRepository<Fsaldoshistoria, Long> implements FsaldoshistoriaRepository  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4020517656381853699L;

	public JpaFsaldosHistoriaRepository() {
		super(Fsaldoshistoria.class);
	}

	public BigDecimal sumaPorPeriodo(String anioMes1, String anioMes2) {
		BigDecimal bdsuma = (BigDecimal)entityManager.createQuery("select Sum(fsh.numerales) " +
				"from Fsaldoshistoria fsh where fsh.mesLiquidacion = :anioMes2 ")
				.setParameter("anioMes2", anioMes2)
				.getSingleResult();
			return bdsuma;
	}


	public BigDecimal sumaPorPeriodoyTarjetas(String anioMes1, String anioMes2,
			String tarjetas) {
		BigDecimal bdsuma = (BigDecimal)entityManager.createQuery("select Sum(fsh.numerales) " +
			"from Fsaldoshistoria fsh where fsh.mesLiquidacion = :anioMes2 and " +
			"fsh.tarjeta NOT IN (" + tarjetas +	")")
			.setParameter("anioMes2", anioMes2)
			.getSingleResult();
		return bdsuma;
	}

	public BigDecimal numeralesFuncionario(String anioMes1, String anioMes2,
			Short tarjeta) {
		BigDecimal bdNumerales = (BigDecimal)entityManager.createQuery("select " +
			"fsh.numerales from Fsaldoshistoria fsh where fsh.mesLiquidacion =:mes2 " +
				"and fsh.tarjeta =:tar")
				.setParameter("mes2", anioMes2)
				.setParameter("tar", tarjeta)
				.getSingleResult();
		
		return bdNumerales;
	}

	public Fsaldoshistoria getByFuncyMesLiquidacion(String mesLiquidacion,
			Short tarjeta) {
		try{
			Date fecha = (Date)entityManager.createQuery("select Max(fsh.fecha) form Fsaldoshistoria fsh where " +
					"fsh.mesLiquidacion =:mes and fsh.tarjeta =:id")
					.setParameter("mes", mesLiquidacion)
					.setParameter("id", tarjeta)
					.getSingleResult();
					
			Fsaldoshistoria saldos = (Fsaldoshistoria) entityManager.createQuery("from Fsaldoshistoria fsh " +
					"where fsh.fecha =:data and fsh.mesLiquidacion =:mes and fsh.tarjeta =:id")
					.setParameter("data", fecha)
					.setParameter("mes", mesLiquidacion)
					.setParameter("id", tarjeta)
					.getSingleResult();
			return saldos;			
		}
		catch(NoResultException nex){
			return null;
		}
	}

	public String getMaxMesLiquidacion() {
		
		return (String)entityManager.createQuery("select max(sf.mesLiquidacion) from " +
				"Fsaldoshistoria sf").getSingleResult();
	}

	@Transactional(readOnly=false)
	public String deleteByMesLiquidacion(String mesLiquidacion) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fsaldoshistoria fh where fh.mesLiquidacion =:mes")
				.setParameter("mes", mesLiquidacion)
				.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Fsaldoshistoria> getByFuncionarioyPeriodo(Short tarjeta,
			String anioMes1, String anioMes2) {
		try{
			List<Fsaldoshistoria> lst = entityManager.createQuery("from Fsaldoshistoria fh where fh.tarjeta =:tar " +
					"and fh.mesLiquidacion >=:mes1 and fh.mesLiquidacion <=:mes2")
					.setParameter("tar", tarjeta)
					.setParameter("mes1", anioMes1)
					.setParameter("mes2", anioMes2)
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fsaldoshistoria> getByTarjetasyMesLiquidacion(String tarjetas,
			String mesLiquida) {
		try{
			List<Fsaldoshistoria> lst = entityManager.createQuery("from Fsaldoshistoria fh where fh.tarjeta IN( " +
					tarjetas + ") and fh.mesLiquidacion =:mes")
					.setParameter("mes", mesLiquida)
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fsaldoshistoria> getByMesLiquidacion(String mesLiquida) {
		try{
			return entityManager.createQuery("from Fsaldoshistoria fh where fh.mesLiquidacion =:mes")
					.setParameter("mes", mesLiquida)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Boolean insertFromSaldosByFuncionario(Short tarjeta) {
		Boolean ret;		
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Fsaldoshistoria (idGplanta, " +
					"tarjeta, fecha, capitalIntegAntes, capitalIntegActual, " +
					"capitalDispAntes, capitalDispActual, numerales, mesLiquidacion)" +
					"select fs.gplanta.idGplanta, fs.tarjeta, fs.fecha, fs.capitalIntegAntes, " + 
					"fs.capitalIntegActual, fs.capitalDispAntes, fs.capitalDispActual, " +
					"fs.numerales, fs.mesLiquidacion from Fsaldos where fs.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.executeUpdate();
			ret = true;
		}
		catch(Exception ex){
			ret = false;
		}
		return ret;
	}

	@SuppressWarnings("unused")
	@Override
	public Boolean huboDistribucion(String mesLiquida) {
		String motivo = "Distribución de utilidades";
		try{
			Fsaldoshistoria fsh = (Fsaldoshistoria) entityManager.createQuery("from Fsaldoshistoria fsh " +
					"where fsh.mesLiquidacion =:mes and fsh.motivo =:motivo")
					.setParameter("mes", mesLiquida)
					.setParameter("motivo", motivo)
					.getSingleResult();
			return true;
		}
		catch(NoResultException nex){
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fsaldoshistoria> getByMesLiquidacionyMotivo(String mesLiquida,
			String motivo) {
		try{
			if(motivo.equalsIgnoreCase("Con Distribucion")){
				motivo = "Distribución de utilidades";
			}
			else{
				motivo = "Liquidación mensual";
			}
			return entityManager.createQuery("from Fsaldoshistoria fsh where fsh.mesLiquidacion =:mes " +
					"and fsh.motivo =:motivo")
					.setParameter("mes", mesLiquida)
					.setParameter("motivo", motivo)
					.getResultList();
		}
		catch(NoResultException nex){
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMesesLiquidacionPorAnio(String anio) {
		try{
			List<String> lst = entityManager.createQuery("select distinct fh.mesLiquidacion from Fsaldoshistoria fh " +
					"where substring(fh.mesLiquidacion, 1, 4) =:anio " )
					.setParameter("anio", anio)
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}


}
