package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fcabezalreciboshist;
import uy.org.aladi.admrh.jpadomain.repository.FcabezalreciboshistRepository;

@Repository("fcabezalreciboshistRepository")
public class JpaFcabezalreciboshistRepository extends JpaRepository<Fcabezalreciboshist, Integer> implements FcabezalreciboshistRepository {

	private static final long serialVersionUID = 7005818717549436693L;

	public JpaFcabezalreciboshistRepository() {
		super(Fcabezalreciboshist.class);

	}

	@Override
	public Integer getUltimoId() {
		Integer id = (Integer)entityManager.createQuery("select max(fcrh.idFCabezalRecibosHist) " +
				"from Fcabezalreciboshist fcrh").getSingleResult();
		return id;
	}

	@Override
	@Transactional
	public String agregarnuevos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Fcabezalreciboshist (idGPlanta, cotizacion, " +
					"liquido, mesLiquidacion, nombre, pctDisponible, sector, tarjeta, adiciones, " +
					"descuentos) select fc.gplanta.idGplanta, fc.cotizacion, fc.liquido, fc.mesLiquidacion, " +
					"fc.nombre, fc.pctDisponible, fc.sector, fc.tarjeta, fc.adiciones, fc.descuentos " +
					"from Fcabezalrecibos fc").executeUpdate();
			return "success";			
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@Override
	@Transactional
	public String actualizarCodigos(Short cod, Integer idCateg) {
		try{
			entityManager.joinTransaction();
			if(idCateg == null){
				entityManager.createQuery("update Fcabezalreciboshist fch set fch.idFCodigos =:cod " +
						"where fch.idFCodigos is null")
						.setParameter("cod", cod).executeUpdate();
			}
			else{
				entityManager.createQuery("update Fcabezalreciboshist fch set fch.idFCodigos " +
						"=:cod where fch.idFcodigos is null and fch.idGPlanta in " +
						"(select gp.idGplanta from Gplanta gp where gp.gcategorias.idGcategoria =:idCat)")
						.setParameter("cod", cod)
						.setParameter("idCat", idCateg)
						.executeUpdate();
			}
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@Override
	@Transactional
	public String agregarUno(Short tarjeta, Short codigo) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Fcabezalreciboshist (idGPlanta, cotizacion, " +
					"liquido, mesLiquidacion, nombre, pctDisponible, sector, tarjeta, adiciones, " +
					"descuentos) select fc.gplanta.idGplanta, fc.cotizacion, fc.liquido, fc.mesLiquidacion, " +
					"fc.nombre, fc.pctDisponible, fc.sector, fc.tarjeta, fc.adiciones, fc.descuentos " +
					"from Fcabezalrecibos fc where fc.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.executeUpdate();
			
			entityManager.createQuery("update Fcabezalreciboshist fch set fch.idFCodigos =:cod " +
					"where idFCodigos is null")
					.setParameter("cod", codigo)
					.executeUpdate();
			return "success";			
		}
		catch(Exception ex){
			return "fail";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcabezalreciboshist> allByMesLiquidacion(String anioMes) {
		return entityManager.createQuery("from Fcabezalreciboshist fcrh where " +
				"fcrh.mesLiquidacion =:mesLiq")
				.setParameter("mesLiq", anioMes)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcabezalreciboshist> getByPeriodoyFuncionario(String desde,
			String hasta, Short tarjeta) {
		
		return entityManager.createQuery("from Fcabezalreciboshist fcrh where " +
				"fcrh.tarjeta =:tar and fcrh.mesLiquidacion >=:aniomes1 and " + 
				"fcrh.mesLiquidacion <=:aniomes2")
				.setParameter("tar", tarjeta)
				.setParameter("aniomes1", desde)
				.setParameter("aniomes2", hasta)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMesesAnteriores(String sAnio) {
		List<String> lstMeses = entityManager.createQuery("select distinct fcrh.mesLiquidacion from " +
				"Fcabezalreciboshist fcrh where substring(fcrh.mesLiquidacion, 1, 4) =:anio")
				.setParameter("anio", sAnio)
				.getResultList();
		
		return lstMeses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcabezalreciboshist> getCabezalesAguinaldos() {
		Short agui = Short.valueOf("35");
		return entityManager.createQuery("from Fcabezalreciboshist fcrh where fcrh.idFCodigos =:cod " +
				"order by fcrh.mesLiquidacion, tarjeta")
				.setParameter("cod", agui)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcabezalreciboshist> getCabezalesHaberes() {
		Short agui = Short.valueOf("35");
		return entityManager.createQuery("from Fcabezalreciboshist fcrh where fcrh.idFCodigos <>:cod " +
				"order by fcrh.mesLiquidacion, tarjeta")
				.setParameter("cod", agui)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcabezalreciboshist> getUltimos(Integer ultimoId) {
		return entityManager.createQuery("from Fcabezalreciboshist fcrh where fcrh.idFCabezalRecibosHist >:ultimo")
				.setParameter("ultimo", ultimoId)
				.getResultList();
	}

}
