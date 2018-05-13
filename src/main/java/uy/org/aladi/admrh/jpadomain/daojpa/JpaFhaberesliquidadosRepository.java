package uy.org.aladi.admrh.jpadomain.daojpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fhaberesliquidados;
import uy.org.aladi.admrh.jpadomain.repository.FhaberesliquidadosRepository;

@Repository("fhaberesliquidadosRepository")
public class JpaFhaberesliquidadosRepository extends JpaRepository<Fhaberesliquidados, Long> implements FhaberesliquidadosRepository {

	private static final long serialVersionUID = 8161231393198783899L;

	public JpaFhaberesliquidadosRepository() {
		super(Fhaberesliquidados.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fhaberesliquidados> getByMesLiquidacion(String mesLiquidacion) {
		List<Fhaberesliquidados> lstHaberes = new ArrayList<Fhaberesliquidados>();
		try{
			lstHaberes = entityManager.createQuery("from Fhaberesliquidados fhl where fhl.mesLiquidacion =:aniomes")
					.setParameter("aniomes", mesLiquidacion)
					.getResultList();
			return lstHaberes;
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Short> getCodigos() {
		try{
			List<Short> lstCodigos = entityManager.createQuery("select distinct fhl.fcodigos.idFcodigos " +
					"from Fhaberesliquidados fhl").getResultList();
			return lstCodigos;
		}
		catch(Exception ex){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Fhaberesliquidados> getByCodigo(Short idcod) {
		List<Fhaberesliquidados> lsthaberes = new ArrayList<Fhaberesliquidados>();
		lsthaberes = entityManager.createQuery("from Fhaberesliquidados fhl where " + 
				"fhl.fcodigos.idFcodigos =:cod order by fhl.tarjeta")
				.setParameter("cod", idcod)
				.getResultList();
		
		return lsthaberes;
	}

	@Override
	@Transactional
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fhaberesliquidados fh").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fhaberesliquidados> getByFuncionario(Short tarjeta) {
		List<Fhaberesliquidados> lsthaberes = new ArrayList<Fhaberesliquidados>();
		lsthaberes = entityManager.createQuery("from Fhaberesliquidados fhl where " + 
				"fhl.tarjeta =:tar order by fhl.fcodigos.idFcodigos")
				.setParameter("tar", tarjeta)
				.getResultList();
		
		return lsthaberes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fhaberesliquidados> getByMesLiquidacionyFuncionario(
			String mesLiquidacion, Short tarjeta) {
		List<Fhaberesliquidados> lsthaberes = new ArrayList<Fhaberesliquidados>();
		lsthaberes = entityManager.createQuery("from Fhaberesliquidados fhl where " + 
				"fhl.mesLiquidacion =:mesLiq and fhl.tarjeta =:tar order by fhl.fcodigos.idFcodigos")
				.setParameter("mesLiq", mesLiquidacion)
				.setParameter("tar", tarjeta)
				.getResultList();
		
		return lsthaberes;
	}

	@Transactional
	public String eliminarUno(Short tarjeta) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fhaberesliquidados fh where fh.tarjeta =:tar")
			.setParameter("tar", tarjeta)
			.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}
	}

	@Override
	public String getMesLiquidacionByFuncionario(Short tarjeta) {
		String mesLiq = null;
		mesLiq = (String)entityManager.createQuery("select distinct hl.mesLiquidacion from Fhaberesliquidados hl " +
				"where hl.tarjeta =:tar")
				.setParameter("tar", tarjeta)
				.getSingleResult();
		return mesLiq;
	}

	@Override
	public Fhaberesliquidados getByFuncionarioyCodigo(Short tarjeta, Short idcod) {
		try{
			Fhaberesliquidados fhl = (Fhaberesliquidados)entityManager.createQuery("from Fhaberesliquidados fhab where " +
					"fhab.tarjeta =:tar and fhab.fcodigos.idFcodigos =:idcod")
					.setParameter("tar", tarjeta)
					.setParameter("idcod", idcod)
					.getSingleResult();
			return fhl;
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	public BigDecimal getSumaBasicos(Short tarjeta) {
		try{
			BigDecimal sumaHaberes = (BigDecimal)entityManager.createQuery("select SUM(fhab.importe) " +
					"from Fhaberesliquidados fhab where fhab.tarjeta =:tar and " +
					"(fhab.fcodigos.idFcodigos =:idcod or fhab.fcodigos.idFcodigos =:idcod2)")
					.setParameter("tar", tarjeta)
					.setParameter("idcod", Short.valueOf("1"))
					.setParameter("idcod2", Short.valueOf("2"))
					.getSingleResult();
			return sumaHaberes;
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	public BigDecimal getSumaByCodigoyMoneda(Short idCod, String moneda) {
		try{
			BigDecimal suma = (BigDecimal)entityManager.createQuery("select SUM(fhab.importe) " +
					"from Fhaberesliquidados fhab where fhab.fcodigos.idFcodigos =:idcod and " +
					"fhab.moneda =:moneda")
					.setParameter("idcod", idCod)
					.setParameter("moneda", moneda)
					.getSingleResult();
			return suma;
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fhaberesliquidados> getByCabezal(Integer idCabezal) {
		
		return entityManager.createQuery("from Fhaberesliquidados fha where fha.fcabezalrecibos.idFcabezalRecibos =:id ")
				.setParameter("id", idCabezal)
				.getResultList();
	}


}
