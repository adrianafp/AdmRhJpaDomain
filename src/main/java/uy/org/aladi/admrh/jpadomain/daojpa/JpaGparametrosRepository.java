package uy.org.aladi.admrh.jpadomain.daojpa;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Gparametros;
import uy.org.aladi.admrh.jpadomain.repository.GparametrosRepository;

@Repository("gparametrosRepository")
public class JpaGparametrosRepository extends JpaRepository<Gparametros, Integer> implements GparametrosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaGparametrosRepository(){
		super(Gparametros.class);
	}

	public Gparametros getByCodigo(Short codigo) {
		if(codigo == null){
			return null;
		}
		Gparametros gparam = (Gparametros)entityManager.createQuery("Select gp from Gparametros gp " +
				"where gp.gcodigo =:cod")
				.setParameter("cod", codigo)
				.getSingleResult();
		return gparam;
	}
		
}
