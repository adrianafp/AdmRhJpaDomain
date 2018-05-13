package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fmovimientos;
import uy.org.aladi.admrh.jpadomain.exceptions.FmovimientosException;
import uy.org.aladi.admrh.jpadomain.repository.FmovimientosRepository;

@Repository("fmovimientosRepository")
public class JpaFmovimientosRepository extends JpaRepository<Fmovimientos, Long> implements FmovimientosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFmovimientosRepository(){
		super(Fmovimientos.class);
	}


	public Boolean deleteByMesLiquidacion(String mesLiquidacion) {
		try{
			entityManager.createQuery("delete from Fmovimientos fm where " +
					"fm.mesLiquidacion =:mes")
					.setParameter("mes", mesLiquidacion)
					.executeUpdate();
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}


	@SuppressWarnings("unchecked")
	public List<Fmovimientos> selectByMesLiquidacion(String mesLiquidacion) {
		List<Fmovimientos> lst = entityManager.createQuery("from Fmovimientos fm where " +
				"fm.mesLiquidacion =:mes")
				.setParameter("mes", mesLiquidacion)
				.getResultList();
		return lst;
		
	}

	public Fmovimientos lastByFunc(Short tarjeta) {
		try{
			Long id = (Long)entityManager.createQuery("select Max(fmov.idFmovimientos) from Fmovimientos fmov " + 
					"where fmov.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.getSingleResult();
			
			Fmovimientos mov = (Fmovimientos)entityManager.createQuery("from Fmovimientos fm " +
					"where fm.tarjeta =:tar and fm.idFmovimientos =:id")
					.setParameter("tar", tarjeta)
					.setParameter("id", id)
					.getSingleResult();
			
			return mov;
		}
		catch(Exception ex){
			throw new FmovimientosException("No fue posible obtener el último movimiento del funcionario");
		}
	}

	public Fmovimientos aperturaCta(Short tarjeta){
		Short tipo = Short.valueOf("1");
		try{
			Fmovimientos mov = (Fmovimientos)entityManager.createQuery(""
				+ "form Fmovimientos fm " +
				"where fm.tarjeta =:tar and fm.tipoMovimiento =:tipo")
				.setParameter("tar", tarjeta)
				.setParameter("tipo", tipo)
				.getSingleResult();
			return mov;
		}
		catch(Exception nex){
			return null;
		}
	}

	@Transactional
	public Boolean deleteAntesMesLiquidacion(String mesLiquidacion) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fmovimientos fm where " +
					"fm.mesLiquidacion <:mes")
					.setParameter("mes", mesLiquidacion)
					.executeUpdate();
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}

	@Transactional
	public void deleteByNroPrestamo(Integer nro) throws FmovimientosException {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fmovimientos fm where " +
					"fm.nroPrestamo =:nro")
					.setParameter("nro", nro)
					.executeUpdate();
		}
		catch(Exception ex){
			throw new FmovimientosException("No fue posible eliminar el registro correspondiente en la tabla Movimientos");
		}
	}


	@Override
	@Transactional
	public Boolean deleteByFuncionario(Short tarjeta) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fmovimientos fm where " +
					"fm.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.executeUpdate();
			return true;
		}
		catch(Exception ex){
			throw new FmovimientosException("No fue posible eliminar el registro correspondiente en la tabla Movimientos");
		}
	}


	@SuppressWarnings("unchecked")
	public List<Fmovimientos> getByTipoyMes(Short tipo, String mesLiquidacion) {
		List<Fmovimientos> lst = entityManager.createQuery("from Fmovimientos fm where " +
				"fm.tipoMovimiento =:tipo and fm.mesLiquidacion =:mes order by fm.tarjeta")
				.setParameter("tipo", tipo)
				.setParameter("mes", mesLiquidacion)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Fmovimientos> getByTipoMesFunc(Short tipo,
			String mesLiquidacion, Short tarjeta) {
		try{
			List<Fmovimientos> lst = entityManager.createQuery("from Fmovimientos fm where " +
				"fm.tipoMovimiento =:tipo and fm.mesLiquidacion =:mes and fm.tarjeta =:tar")
				.setParameter("tipo", tipo)
				.setParameter("mes", mesLiquidacion)
				.setParameter("tar", tarjeta)
				.getResultList();
			if(lst.size() == 0){
				throw new FmovimientosException("El funcionario " + tarjeta.toString() + " no registra movimientos de aportes en el mes: " + mesLiquidacion);
			}
			return lst;
		}
		catch(Exception ex){
			throw new FmovimientosException("El funcionario " + tarjeta.toString() + " no registra movimientos de aportes en el mes: " + mesLiquidacion);
		}
	}


	@SuppressWarnings({"unchecked" })
	public List<Fmovimientos> getByTipoFechaFunc(Short tipo, Date fecha,
			Short tarjeta) {

		java.sql.Date fechaSql = new java.sql.Date(fecha.getTime());
		try{
			List<Fmovimientos> lstmov = entityManager.createQuery("from Fmovimientos fm where " +
					"fm.fechaMovimiento =:fecha and fm.tarjeta =:tar and fm.tipoMovimiento =:tipo")
					.setParameter("fecha", fechaSql)
					.setParameter("tar", tarjeta)
					.setParameter("tipo", tipo)
					.getResultList();
			return lstmov;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fmovimientos> getByFuncyPeriodo(Short tarjeta,
			String mesLiqinicio, String mesLiqfin) {

		try{
			List<Fmovimientos> lstmov = entityManager.createQuery("from Fmovimientos fm " +
					"where fm.tarjeta =:tar and fm.mesLiquidacion >=:desde and fm.mesLiquidacion <=:hasta " + 
					"order by fm.fechaMovimiento, fm.tipoMovimiento, fm.nroPrestamo")
					.setParameter("tar", tarjeta)
					.setParameter("desde", mesLiqinicio)
					.setParameter("hasta", mesLiqfin)
					.getResultList();
			return lstmov;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fmovimientos> getByFuncyMesLiquidacion(Short tarjeta,
			String mesLiquidacion) {

		try{
			List<Fmovimientos> lstmov = entityManager.createQuery("from Fmovimientos fm " +
					"where fm.tarjeta =:tar and fm.mesLiquidacion >=:desde " + 
					"order by fm.fechaMovimiento")
					.setParameter("tar", tarjeta)
					.setParameter("desde", mesLiquidacion)
					.getResultList();
			return lstmov;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Short> tarjetasEgresados(String mesLiquida) {
		String observ = "Por cierre de cuenta";
		try{
			List<Short> lstTarjetas = entityManager.createQuery("select distinct fm.tarjeta from Fmovimientos fm where fm.observaciones =:observ " + 
				"and fm.mesLiquidacion =:mesLiq")
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
	public List<Fmovimientos> movimientosEgresadoByMesLiquidacion(Short tarjeta,
			String mesLiquidacion) {
		String observ = "Por cierre de cuenta";
		try{
			List<Fmovimientos> movs = entityManager.createQuery("from Fmovimientos fm where " +
					"fm.tarjeta =:tar and fm.observaciones =:observ and fm.mesLiquidacion =:mes")
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
	public List<Fmovimientos> getByFuncyFechaOmesLiquidacion(Short tarjeta, java.sql.Date fecha, String mesLiquida){
			try{
				List<Fmovimientos> movs = entityManager.createQuery("from Fmovimientos fm where fm.tarjeta =:tar and (fm.fechaMovimiento =:fec or fm.mesLiquidacion =:mesLiq)")
				.setParameter("tar", tarjeta)
				.setParameter("fec", fecha)
				.setParameter("mesLiq", mesLiquida)
				.getResultList();
				return movs;
			}
			catch(Exception ex){
				return null;
			}
	}

}
