package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Ftipoprestamo;
import uy.org.aladi.admrh.jpadomain.repository.FtipoprestamoRepository;

@Repository("ftipoprestamoRepository")
public class JpaFtipoprestamoRepository extends JpaRepository<Ftipoprestamo, Integer> implements FtipoprestamoRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7054163755630438922L;
	public JpaFtipoprestamoRepository() {
		super(Ftipoprestamo.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ftipoprestamo> getSinConsumo() {
		Short tipo = Short.valueOf("6");
		List<Ftipoprestamo> lstTipos = entityManager.createQuery("from Ftipoprestamo ftp " +
				"where ftp.tipoPrestamo < :tipo")
				.setParameter("tipo", tipo)
				.getResultList();
		
		return lstTipos;
	}

	@Override
	public Ftipoprestamo getByTipo(Short tipo) {
		return (Ftipoprestamo)entityManager.createQuery("from Ftipoprestamo ftp where " +
				"ftp.tipoPrestamo =:tipo")
				.setParameter("tipo", tipo)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ftipoprestamo> getParaSolicitud() {
		Short tipo = Short.valueOf("4");
		return entityManager.createQuery("from Ftipoprestamo ftp where " +
				"ftp.tipoPrestamo <=:tipo")
				.setParameter("tipo", tipo)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ftipoprestamo> getParaAfaladi() {
		Short tipo = Short.valueOf("6");
		return entityManager.createQuery("from Ftipoprestamo ftp where " +
				"ftp.tipoPrestamo >:tipo")
				.setParameter("tipo", tipo)
				.getResultList();
	}

}
