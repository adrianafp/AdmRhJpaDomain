package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rresumanio;
import uy.org.aladi.admrh.jpadomain.repository.RresumanioRepository;

@Repository("rResumanioRepository")
public class JpaRresumanioRepository extends JpaRepository<Rresumanio, Long> implements RresumanioRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4231014776387655021L;

	public JpaRresumanioRepository() {
		super(Rresumanio.class);
	}

	@Override
	public Rresumanio getByTarjetaCodigoyAniomes(Short tarjeta, Short idcod,
			String aniomes) {
		try{
			return (Rresumanio)entityManager.createQuery("from Rresumanio rrs where rrs.tarjeta =:tar and " +
					"rrs.rcodigos.idRcodigos =:cod and rrs.mesnro =:aniomes")
					.setParameter("tar", tarjeta)
					.setParameter("cod", idcod)
					.setParameter("aniomes", aniomes)
					.getSingleResult();
				
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=false)
	public String actualizarDesdeMensual() {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("insert into Rresumanio (idGplanta, Tarjeta, Mesnro, idRCodigos, Veces, Dias, Horas) " +
			 "select idGplanta, Tarjeta, Mesnro, idRCodigos, Veces, Dias, Horas from Rresumenm").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@Override
	@Transactional(readOnly=false)
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rresumanio rr").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rresumanio> getByCodigoyAnioMes(Short idcod, String anioMes) {
		try{
			return entityManager.createQuery("from Rresumanio rrs where " +
					"rrs.rcodigos.idRcodigos =:cod and rrs.mesnro =:aniomes")
					.setParameter("cod", idcod)
					.setParameter("aniomes", anioMes)
					.getResultList();
				
		}
		catch(Exception ex){
			return null;
		}
	}

}
