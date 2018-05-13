package uy.org.aladi.admrh.jpadomain.daojpa;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Ftipomovimiento;
import uy.org.aladi.admrh.jpadomain.repository.FtipomovimientoRepository;

@Repository("ftipomovimientoRepository")
public class JpaFtipomovimientoRepository extends JpaRepository<Ftipomovimiento, Integer> implements FtipomovimientoRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7054163755630438922L;
	public JpaFtipomovimientoRepository() {
		super(Ftipomovimiento.class);
	}
	public Ftipomovimiento getByTipo(Short tipo) {
		return (Ftipomovimiento) entityManager.createQuery("from Ftipomovimiento ftm where ftm.tipoMovimiento =:t")
				.setParameter("t", tipo)
				.getSingleResult();
	}


}
