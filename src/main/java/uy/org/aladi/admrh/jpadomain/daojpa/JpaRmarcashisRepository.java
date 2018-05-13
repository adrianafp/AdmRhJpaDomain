package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rmarcashis;
import uy.org.aladi.admrh.jpadomain.repository.RmarcashisRepository;

@Repository("rmarcashisRepository")
public class JpaRmarcashisRepository extends JpaRepository<Rmarcashis, Integer> implements RmarcashisRepository{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaRmarcashisRepository() {
		super(Rmarcashis.class);
	}

	@Override
	@Transactional(readOnly=false)
	public String agregarNuevos() {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("insert into Rmarcashis (fecha1, fecha2, " +
			"fechaAnalisis, hora1, hora2, idGPlanta, observ, idRcodigos, tarjeta, ultlect) " +
			"select rm.fecha1, rm.fecha2, rm.fechaAnalisis, rm.hora1, rm.hora2, " + 
			"rm.idGPlanta, rm.observ, rm.idRcodigos, rm.tarjeta, " + 
			"rm.ultlect from Rmarcanio rm")
				.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcashis> getByTarjeta(Short tarjeta) {
		return entityManager.createQuery("from Rmarcashis rm where rm.tarjeta =:tar")
				.setParameter("tar", tarjeta)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcashis> getByTarjetayPeriodo(Short tarjeta, Date fecha1,
			Date fecha2) {
		return entityManager.createQuery("from Rmarcashis rm where rm.tarjeta =:tar and " +
			"rm.fecha1 >=:f1 and rm.fecha2 >=:f2")
				.setParameter("tar", tarjeta)
				.setParameter("f1", fecha1)
				.setParameter("f2", fecha2)
				.getResultList();
	}

}
