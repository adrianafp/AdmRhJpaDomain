package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Ractreghis;
import uy.org.aladi.admrh.jpadomain.repository.RactreghisRepository;

@Repository("ractreghisRepository")
public class JpaRactreghisRepository extends JpaRepository<Ractreghis, Long> implements RactreghisRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRactreghisRepository(){
		super(Ractreghis.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAnioMes() {
		List<String> anioMes = entityManager.createQuery("select distinct ar.mesnro from Ractreganio ar")
				.getResultList();
		return anioMes;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreghis> getAllByAnioMes(String anioMes) {
		try{
			return entityManager.createQuery("from Ractreghis ar where ar.mesnro =:mes")
					.setParameter("mes", anioMes)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	public Ractreghis getByTarjetayAniomes(Short tarjeta, String aniomes) {
		try{
			return (Ractreghis)entityManager.createQuery("from Ractreghis ar where ar.mesnro =:mes and " +
					"ar.tarjeta =:tar")
					.setParameter("mes", aniomes)
					.setParameter("tar", tarjeta)
					.getSingleResult();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreghis> getByTarjetayPeriodo(Short tarjeta,
			String anioMes1, String anioMes2) {
		try{
			return entityManager.createQuery("from Ractreghis ar where ar.mesnro >=:mes1 and " +
					"ar.mesnro <=:mes2 and ar.tarjeta =:tar")
					.setParameter("mes1", anioMes1)
					.setParameter("mes2", anioMes2)
					.setParameter("tar", tarjeta)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreghis> getAllByPeriodo(String anioMes1, String anioMes2) {
		try{
			return entityManager.createQuery("from Ractreghis ar where ar.mesnro >=:mes1 and " +
					"ar.mesnro <=:mes2")
					.setParameter("mes1", anioMes1)
					.setParameter("mes2", anioMes2)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreghis> getByDeptoyPeriodo(String tarjetas,
			String anioMes1, String anioMes2) {
		try{
			return entityManager.createQuery("from Ractreghis ar where ar.mesnro >=:mes1 and " +
					"ar.mesnro <=:mes2 and ar.tarjeta IN(" + tarjetas + ")")
					.setParameter("mes1", anioMes1)
					.setParameter("mes2", anioMes2)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	@Transactional
	public String agregarNuevos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Ractreghis (atflia_horas, diasTrabajados, " +
					"duelo, enfchse_horas, enfcon_dias, enfcon_horas, enfRet_horas, enfSin_3, " +
					"enfSin_dias, excat_horas, excat_veces, extCom_horas, extDob_horas, extNor_horas, " + 
					"extSim_horas, faltaCon, faltaSin, licComp, licEsp, licEst, licMat, licMatr, licOrd, " +
					"licPais, licPat, mesnro, mserv_dias, mserv_horas, mservr_horas, salesp_horas, sangre, " +
					"suspen, tardee_horas, tardee_veces, tarjeta, tiempX_horas, tmpXNoLab_horas) " + 
					"select rar.atflia_horas, rar.diasTrabajados, rar.duelo, rar.enfchse_horas, " +
					"rar.enfcon_dias, rar.enfcon_horas, rar.enfRet_horas, rar.enfSin_3, rar.enfSin_dias, " +
					"rar.excat_horas, rar.excat_veces, rar.extCom_horas, rar.extDob_horas, " +
					"rar.extNor_horas, rar.extSim_horas, rar.faltaCon, rar.faltaSin, rar.licComp, " +
					"rar.licEsp, rar.licEst, rar.licMat, rar.licMatr, rar.licOrd, rar.licPais, rar.licPat, " +
					"rar.mesnro, rar.mserv_dias, rar.mserv_horas, rar.mservr_horas, rar.salesp_horas, " +
					"rar.sangre, rar.suspen, rar.tardee_horas, rar.tardee_veces, rar.tarjeta, " +
					"rar.tiempX_horas, rar.tmpXNoLab_horas from Ractreganio rar").executeUpdate();
			return "success";			
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


}
