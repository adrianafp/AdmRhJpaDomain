package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rmarcanio;
import uy.org.aladi.admrh.jpadomain.repository.RmarcanioRepository;

@Repository("rmarcanioRepository")
public class JpaRmarcanioRepository extends JpaRepository<Rmarcanio, Integer> implements RmarcanioRepository{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaRmarcanioRepository() {
		super(Rmarcanio.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcanio> getByTarjeta(Short tarjeta) {
		return entityManager.createQuery("from Rmarcanio rm where rm.tarjeta =:tar")
				.setParameter("tar", tarjeta)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcanio> getByTarjetayFecha(Short tarjeta, Date fecha) {
		List<Rmarcanio> lstrm = entityManager.createQuery("from Rmarcanio rmm where rmm.tarjeta =:tar " +
				"and rmm.fecha1 =:f1 ")
				.setParameter("tar", tarjeta)
				.setParameter("f1", fecha)
				.getResultList();
		return lstrm;
	}

	@Override
	@Transactional(readOnly=false)
	public String actualizarDesdeMensual(Date ultimoDia) {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("insert into Rmarcanio (idGplanta, Tarjeta, " + 
					"Fecha1, Hora1, Fecha2, Hora2, idRCodigos, Observ, Ultlect, FechaAnalisis) " + 
					" select idGplanta, Tarjeta, Fecha1, Hora1, Fecha2, Hora2, idRCodigos, Observ, " + 
					"Ultlect, FechaAnalisis from Rmarcames where fecha1 <:dia")
					.setParameter("dia", ultimoDia)
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcanio> getByTarjetayPeriodo(Short tarjeta, Date fecha1,
			Date fecha2) {
		return entityManager.createQuery("from Rmarcanio rm where rm.tarjeta =:tar and " +
			"rm.fecha1 >=:fecha1 and rm.fecha1 <=:fecha2")
			.setParameter("tar", tarjeta)
			.setParameter("fecha1", fecha1)
			.setParameter("fecha2", fecha2)
			.getResultList();
	}

	@Override
	@Transactional(readOnly=false)
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("delete from Rmarcanio")
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

}
