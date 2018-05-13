package uy.org.aladi.admrh.jpadomain.daojpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rresumenhis;
import uy.org.aladi.admrh.jpadomain.repository.RresumenhisRepository;

@Repository("rResumenhisRepository")
public class JpaRresumenhisRepository extends JpaRepository<Rresumenhis, Long> implements RresumenhisRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4231014776387655021L;

	public JpaRresumenhisRepository() {
		super(Rresumenhis.class);
	}

	@Override
	@Transactional(readOnly=false)
	public String agregarNuevos() {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("insert into Rresumenhis (dias, horas, " +
			"idGPlanta, idRCodigos, mesnro, tarjeta, veces)" +
			" select rr.dias, rr.horas, rr.idGPlanta, rr.idRcodigos, rr.mesnro, " +
			"rr.tarjeta, rr.veces from Rresumanio rr").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

}
