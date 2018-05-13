package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fcodigos;
import uy.org.aladi.admrh.jpadomain.repository.FcodigosRepository;

@Repository("fcodigosRepository")
public class JpaFcodigosRepository extends JpaRepository<Fcodigos, Short> implements FcodigosRepository {

	private static final long serialVersionUID = 3666674358159944660L;

	public JpaFcodigosRepository() {
		super(Fcodigos.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcodigos> getAdiciones() {
		return entityManager.createQuery("from Fcodigos fc where fc.adicion = true").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcodigos> getDeducciones() {
		return entityManager.createQuery("from Fcodigos fc where fc.descuento = true").getResultList();
	}

	@Override
	public Short getMaxCodAdiciones() {
		Short id = (Short)entityManager.createQuery("select Max(fc.idFcodigos) from Fcodigos fc where fc.adicion = true").getSingleResult();
		return id;
	}

	@Override
	public Short getMaxCodDeducciones() {
		Short id = (Short)entityManager.createQuery("select Max(fc.idFcodigos) from Fcodigos fc where fc.descuento = true").getSingleResult();
		return id;
	}


}
