package uy.org.aladi.admrh.jpadomain.daojpa;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fhabereshist;
import uy.org.aladi.admrh.jpadomain.repository.FhabereshistRepository;

@Repository("fhabereshistRepository")
public class JpaFhabereshistRepository extends JpaRepository<Fhabereshist, Long> implements FhabereshistRepository {

	private static final long serialVersionUID = 3624789653168224483L;

	public JpaFhabereshistRepository() {
		super(Fhabereshist.class);
	}

	@Override
	@Transactional
	public String agregarNuevos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Fhabereshist (idGplanta, cantidad, descripcion, " +
					"idFcodigos, importe, mesLiquidacion, moneda, orden, registro, sumaResta, " +
					"tarjeta) select fh.gplanta.idGplanta, fh.cantidad, fh.descripcion, fh.fcodigos.idFcodigos, " + 
					"fh.importe, fh.mesLiquidacion, fh.moneda, fh.orden, fh.registro, fh.sumaResta, fh.tarjeta " +
					"from Fhaberesliquidados fh").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@Override
	@Transactional
	public String actualizarIdCabezal(Integer ultimoId) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("update Fhabereshist fhh set fhh.idFCabezalRecibosHist = " +
					"(select fch.idFCabezalRecibosHist from Fcabezalreciboshist fch where " +
					"fch.tarjeta = fhh.tarjeta and fch.mesLiquidacion = fhh.mesLiquidacion " +
					"and fch.idFCabezalRecibosHist >:id)")
					.setParameter("id", ultimoId)
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fhabereshist> getByFuncAnioCodigo(Short tarjeta, String anio,
			Short codigo) {
		try{
			return entityManager.createQuery("from Fhabereshist hh where hh.tarjeta =:tar " +
					"and substring(hh.mesLiquidacion, 1, 4) =:anio and hh.idFcodigos =:cod")
					.setParameter("tar", tarjeta)
					.setParameter("anio", anio)
					.setParameter("cod", codigo)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	public BigDecimal getSumaParaMedioAguinaldo(Short tarjeta, String mesJulio) {
		BigDecimal suma = BigDecimal.ZERO;
		try{
			suma = (BigDecimal)entityManager.createQuery("select sum(hh.importe) from Fhabereshist hh " +
					"where hh.tarjeta =:tar and hh.mesLiquidacion >=:aniomes and (" +
					"hh.idFcodigos =:cod1 or hh.idFcodigos =:cod2)")
					.setParameter("tar", tarjeta)
					.setParameter("aniomes", mesJulio)
					.setParameter("cod1", Short.valueOf("1"))
					.setParameter("cod2", Short.valueOf("2"))
					.getSingleResult();
		}
		catch(Exception ex){
			suma = BigDecimal.ZERO;
		}
		return suma;
	}

	@Override
	public BigDecimal getSumaParaAguinaldo(Short tarjeta, String anio) {
		BigDecimal suma = BigDecimal.ZERO;
		try{
			suma = (BigDecimal)entityManager.createQuery("select sum(hh.importe) from Fhabereshist hh " +
					"where hh.tarjeta =:tar and substring(hh.mesLiquidacion, 1, 4) =:anio and (" +
					"hh.idFcodigos =:cod1 or hh.idFcodigos =:cod2)")
					.setParameter("tar", tarjeta)
					.setParameter("anio", anio)
					.setParameter("cod1", Short.valueOf("1"))
					.setParameter("cod2", Short.valueOf("2"))
					.getSingleResult();
		}
		catch(Exception ex){
			suma = BigDecimal.ZERO;
		}
		return suma;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAnioMesesByCodigo(Short codigo) {
		try{
			return entityManager.createQuery("select distinct fh.mesLiquidacion from " +
					"Fhabereshist fh where fh.idFcodigos =:cod order by fh.mesLiquidacion desc")
					.setParameter("cod", codigo)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fhabereshist> getByMesLiquidacionyCodigo(String mesLiquidacion,
			Short codigo) {
		try{
			return entityManager.createQuery("from Fhabereshist fh where fh.mesLiquidacion =:mesLiq " +
					"and fh.idFcodigos =:cod")
					.setParameter("mesLiq", mesLiquidacion)
					.setParameter("cod", codigo)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	@Transactional
	public String agregarNuevoByFunc(Short tarjeta) {
		try{
			entityManager.joinTransaction();

			entityManager.createQuery("insert into Fhabereshist (idGplanta, cantidad, descripcion, " +
				"idFcodigos, importe, mesLiquidacion, moneda, orden, registro, sumaResta, " +
				"tarjeta) select fh.gplanta.idGplanta, fh.cantidad, fh.descripcion, fh.fcodigos.idFcodigos, " + 
				"fh.importe, fh.mesLiquidacion, fh.moneda, fh.orden, fh.registro, fh.sumaResta, fh.tarjeta " +
				"from Fhaberesliquidados fh where fh.tarjeta =:tar")
				.setParameter("tar", tarjeta)
				.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}
	}

	@Override
	@Transactional(readOnly=false)
	public String actualizarUnIdCabezal(Integer ultimoId, Long idHabHist) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("update Fhabereshist fhh set fhh.idFCabezalRecibosHist =:id " +
					"where fhh.idFhaberesHist =:idHab")
					.setParameter("id", ultimoId)
					.setParameter("idHab", idHabHist)
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}
	}

	@Override
	public Long getUltimoId() {
		return (Long)entityManager.createQuery("select max(fhh.idFhaberesHist) from Fhabereshist fhh").getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fhabereshist> getHaberesPosterioresAguinaldo(Short tarjeta,
			String sanio) {
		try{
			Fhabereshist fhh = (Fhabereshist)entityManager.createQuery("from Fhabereshist fhh " +
				"where fhh.tarjeta =:tar and substring(fhh.mesLiquidacion,1,4) =:sanio and " +
				"fhh.idFcodigos =:icod")
				.setParameter("tar", tarjeta)
				.setParameter("sanio", sanio)
				.setParameter("icod", Short.valueOf("35"))
				.getSingleResult();
			String mesLiqAgui = fhh.getMesLiquidacion();
			List<Fhabereshist> lstHabHist = entityManager.createQuery("from Fhabereshist fhh where " +
					"fhh.tarjeta =:tar and fhh.mesLiquidacion >:saniomes and (fhh.idFcodigos =:icod1 " +
					"or fhh.idFcodigos =:icod2)")
					.setParameter("tar", tarjeta)
					.setParameter("saniomes", mesLiqAgui)
					.setParameter("icod1", Short.valueOf("1"))
					.setParameter("icod2", Short.valueOf("2"))
					.getResultList();
			return lstHabHist;
		}
		catch(Exception ex){
			List<Fhabereshist> lstHab = entityManager.createQuery("from Fhabereshist fhh " +
					"where fhh.tarjeta =:tar and substring(fhh.mesLiquidacion, 1, 4) =:sanio " +
					"and (fhh.idFcodigos =:icod1 or fhh.idFcodigos =:icod2)")
					.setParameter("tar", tarjeta)
					.setParameter("sanio", sanio)
					.setParameter("icod1", Short.valueOf("1"))
					.setParameter("icod2", Short.valueOf("2"))
					.getResultList();
			return lstHab;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fhabereshist> getByidCabezal(Integer idCabezal) {
		return entityManager.createQuery("from Fhabereshist fhh where fhh.idFCabezalRecibosHist =:id")
				.setParameter("id", idCabezal)
				.getResultList();
	}

	@Override
	public Fhabereshist getByFuncMesLiquidacionyCodigo(Short tarjeta,
			String mesLiquidacion, Short codigo) {
		try{
			return (Fhabereshist)entityManager.createQuery("from Fhabereshist fhh where fhh.tarjeta =:tar and " +
				"fhh.mesLiquidacion =:mesLiq and fhh.idFcodigos =:cod")
				.setParameter("tar", tarjeta)
				.setParameter("mesLiq", mesLiquidacion)
				.setParameter("cod", codigo)
				.getSingleResult();
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fhabereshist> getByFuncyMesLiquidacion(Short tarjeta,
			String mesLiquidacion) {
		try{
			return entityManager.createQuery("from Fhabereshist fhh where fhh.tarjeta =:tar and " +
					"fhh.mesLiquidacion =:mesLiq")
					.setParameter("tar", tarjeta)
					.setParameter("mesLiq", mesLiquidacion)
					.getResultList();
		}
		catch(NoResultException nex){
			return null;			
		}
	}

}
