package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Gorganigrama;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.GorganigramaRepository;

@Repository("gorganigramaRepository")
public class JpaGorganigramaRepository extends JpaRepository<Gorganigrama, Short> implements GorganigramaRepository, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6387107505436349066L;
	

	public JpaGorganigramaRepository(){
		super(Gorganigrama.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getByDepto(Short id) {
		List<Gplanta> lst = entityManager.createQuery("from Gplanta gp where " +
				"gp.gorganigrama.idGOrganigrama =:id")
				.setParameter("id", id)
				.getResultList();
		return lst;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getLosQueMarcanByDepto(Short id) {
		Boolean marca = true;
		List<Gplanta> lst = entityManager.createQuery("from Gplanta gp where " +
				"gp.marcas =:marca and gp.gorganigrama.idGOrganigrama =:id")
				.setParameter("marca", marca)
				.setParameter("id", id)
				.getResultList();
		return lst;
	}

}
