package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fmovimientoshist;
import uy.org.aladi.admrh.jpadomain.entities.Ftipomovimiento;
import uy.org.aladi.admrh.jpadomain.repository.FmovimientoshistRepository;
import uy.org.aladi.admrh.jpadomain.repository.FtipomovimientoRepository;

@Repository("fmovimientoshistRepository")
public class JpaFmovimientoshistRepository extends JpaRepository<Fmovimientoshist, Long> implements FmovimientoshistRepository{
	
	private static final long serialVersionUID = -5994470987435373982L;

	@Autowired
	private FtipomovimientoRepository ftipomovimientoRepository;
	
	public JpaFmovimientoshistRepository(){
		super(Fmovimientoshist.class);
	}

	@Transactional(readOnly=false)
	public Boolean insertByAnioMes(String anioMes) {
		Boolean ret = false;
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Fmovimientoshist (fechaMovimiento, " +
					"idFtipoMovimiento, idGplanta, importeCapSec, importeIntFunc, importeMov, " +
					"mesLiquidacion, nroCuota, nroPrestamo, observaciones, orden, saldoActual, " +
					"saldoAnterior, tarjeta) " +
					"select fm.fechaMovimiento, fm.ftipomovimiento.idFtipoMovimiento, fm.gplanta.idGplanta, " +
					"fm.importeCapSec, fm.importeIntFunc, fm.importeMov, fm.mesLiquidacion, fm.nroCuota, " +
					"fm.nroPrestamo, fm.observaciones, fm.orden, fm.saldoActual, fm.saldoAnterior, " +
					"fm.tarjeta from Fmovimientos fm where fm.mesLiquidacion <:am")
					.setParameter("am", anioMes).executeUpdate();
			
			ret = this.actualizarTipoMov();
		}
		catch(Exception sqlex){
			ret = false;
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	private Boolean actualizarTipoMov(){
		try{
		List<Fmovimientoshist> lstMovs = entityManager.createQuery("from Fmovimientoshist fmh " +
				"where fmh.tipoMovimiento is null").getResultList();
		for(Fmovimientoshist fmh : lstMovs){
			Integer tipomov = fmh.getIdFtipoMovimiento();
			Ftipomovimiento tmov = ftipomovimientoRepository.findById(tipomov);
			fmh.setTipoMovimiento(tmov.getTipoMovimiento());
			fmh = this.save(fmh);
		}
		return true;
		}
		catch(Exception ex){
			return false;
		}
	}
	
	@Override
	@Transactional(readOnly=false)
	public Boolean insertByFuncionario(Short tarjeta) {
		Boolean ret = false;
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Fmovimientoshist (fechaMovimiento, " +
					"idFtipoMovimiento, idGplanta, importeCapSec, importeIntFunc, importeMov, " +
					"mesLiquidacion, nroCuota, nroPrestamo, observaciones, orden, saldoActual, " +
					"saldoAnterior, tarjeta) " +
					"select fm.fechaMovimiento, fm.ftipomovimiento.idFtipoMovimiento, fm.gplanta.idGplanta, " +
					"fm.importeCapSec, fm.importeIntFunc, fm.importeMov, fm.mesLiquidacion, fm.nroCuota, " +
					"fm.nroPrestamo, fm.observaciones, fm.orden, fm.saldoActual, fm.saldoAnterior, " +
					"fm.tarjeta from Fmovimientos fm where fm.tarjeta =:tar")
					.setParameter("tar", tarjeta).executeUpdate();
			
			ret = this.actualizarTipoMov();
		}
		catch(Exception sqlex){
			ret = false;
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Short> tarjetasEgresados(String mesLiquida) {
		String observ = "Por cierre de cuenta";
		try{
			List<Short> lstTarjetas = entityManager.createQuery("select distinct fmh.tarjeta from Fmovimientoshist fmh where fmh.observaciones =:observ " + 
				"and fmh.mesLiquidacion =:mesLiq")
				.setParameter("observ", observ)
				.setParameter("mesLiq", mesLiquida)
				.getResultList();
			return lstTarjetas;
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fmovimientoshist> movimientosEgresadoByMesLiquidacion(
			Short tarjeta, String mesLiquidacion) {
		String observ = "Por cierre de cuenta";
		try{
			List<Fmovimientoshist> movs = entityManager.createQuery("from Fmovimientoshist fmh where " +
					"fmh.tarjeta =:tar and fmh.observaciones =:observ and fmh.mesLiquidacion =:mes")
					.setParameter("tar", tarjeta)
					.setParameter("observ", observ)
					.setParameter("mes", mesLiquidacion)
					.getResultList();
			return movs;
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fmovimientoshist> movimientosConTipoNulo() {

		try{
			List<Fmovimientoshist> lstMovs = entityManager.createQuery("from Fmovimientoshist fmh " +
					"where fmh.tipoMovimiento is null").getResultList();
			return lstMovs;
		}
		catch(NoResultException nex){
			return null;
		}
	}

}
