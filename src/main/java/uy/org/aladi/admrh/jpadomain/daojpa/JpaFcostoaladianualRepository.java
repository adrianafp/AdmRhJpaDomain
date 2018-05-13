package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fcostoaladianual;
import uy.org.aladi.admrh.jpadomain.repository.FcostoaladianualRepository;

@Repository("fcostoaladianualRepository")
public class JpaFcostoaladianualRepository extends JpaRepository<Fcostoaladianual, Long> implements FcostoaladianualRepository {

	private static final long serialVersionUID = -254001771769879846L;

	public JpaFcostoaladianualRepository(){
		super(Fcostoaladianual.class);
	}

	@Transactional
	public Boolean deleteAll() {
		Boolean ret;
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcostoaladianual fca").executeUpdate();
			ret = true;
		}
		catch(Exception ex){
			ret = false;
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcostoaladianual> getByFuncionario(Short tarjeta) {
		try{
			return entityManager.createQuery("from Fcostoaladianual fca where fca.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.getResultList();			
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=false)
	public Boolean deleteByFuncionario(Short tarjeta) {
		Boolean ret;
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcostoaladianual fca where fca.tarjeta =:tar")
			.setParameter("tar", tarjeta)
			.executeUpdate();
			ret = true;
		}
		catch(Exception ex){
			ret = false;
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllAnioMes() {
		return entityManager.createQuery("select distinct fca.mesAnio from Fcostoaladianual fca ")
				.getResultList();
	}

	@Override
	@Transactional(readOnly=false)
	public String deleteByMesLiquidacion(String anioMes) {
		String ret;
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcostoaladianual fca where " + 
					"fca.mesAnio =:mesLiq")
					.setParameter("mesLiq", anioMes)
					.executeUpdate();
			ret = "success";
		}
		catch(Exception ex){
			ret = "fail";
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcostoaladianual> getByMesLiquidacion(String anioMes) {
		return entityManager.createQuery("from Fcostoaladianual fca where fca.mesAnio =:mesLiq")
				.setParameter("mesLiq", anioMes)
				.getResultList();
	}

	@Override
	public Fcostoaladianual getByFuncyMesLiquidacion(Short tarjeta,
			String anioMes) {
		try{
		Fcostoaladianual costo = (Fcostoaladianual)entityManager.createQuery("from Fcostoaladianual fca where fca.tarjeta =:tarjeta " +
				"and fca.mesAnio =:mesLiq")
				.setParameter("tarjeta", tarjeta)
				.setParameter("mesLiq", anioMes)
				.getSingleResult();
		return costo;
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Boolean insertFromEgresoByFuncionario(Short tarjeta) {
		Boolean ret;		
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("insert into Fcostoaladianual (mesAnio, idGPlanta, " +
					"tarjeta, nombre, basico, aguinaldo, antiguedad, aporte, cargas, " +
					"compensa, excAtFliar, hextras, representacion, segAccidT, segSalud, " +
					"segVida, vivienda, otrosMas, otrosMenos, total)" +
					"select ca.mesAnio, ca.idGplanta, ca.tarjeta, ca.nombre, " +
					"ca.basico, ca.aguinaldo, ca.antiguedad, ca.aporte, ca.cargas, ca.compensa, " +
					"ca.excAtFliar, ca.hextras, ca.representacion, ca.segAccidT, ca.segSalud, " +
					"ca.segVida, ca.vivienda, ca.otrosMas, ca.otrosMenos, ca.total from " +
					"Fcostoaladiegresos ca where ca.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.executeUpdate();
			ret = true;
		}
		catch(Exception ex){
			ret = false;
		}
		return ret;
	}
}
