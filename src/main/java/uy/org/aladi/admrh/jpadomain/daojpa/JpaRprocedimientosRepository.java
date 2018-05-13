package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Rprocedimientos;
import uy.org.aladi.admrh.jpadomain.repository.RprocedimientosRepository;

@Repository("rprocedimientosRepository")
public class JpaRprocedimientosRepository extends JpaRepository<Rprocedimientos, Integer> implements RprocedimientosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaRprocedimientosRepository(){
		super(Rprocedimientos.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rprocedimientos> getByCategoria(Integer cat) {
		
		return entityManager.createQuery("from Rprocedimientos rp where rp.rcategorias.idrcategorias =:cat")
				.setParameter("cat", cat)
				.getResultList();
	}

}
