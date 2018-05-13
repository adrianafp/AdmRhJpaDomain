package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fparametros;
import uy.org.aladi.admrh.jpadomain.repository.FparametrosRepository;

@Repository("fparametrosRepository")
public class JpaFparametrosRepository extends JpaRepository<Fparametros, Long> implements FparametrosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFparametrosRepository(){
		super(Fparametros.class);
	}

	public Fparametros getByCodigo(Short codigo) {
		if(codigo == null){
			return null;
		}
		Fparametros fparam = (Fparametros)entityManager.createQuery("Select fp from Fparametros fp " +
				"where fp.idFcodigos =:cod")
				.setParameter("cod", codigo)
				.getSingleResult();
		return fparam;
	}

	@SuppressWarnings("unchecked")
	public List<Fparametros> getByLista(String lista) {
		if(lista == null){
			return null;
		}
		List<Fparametros> lst = entityManager.createQuery("from Fparametros fp where " +
				"fp.idFcodigos IN (" + lista + ")").getResultList();
		return lst;
	}
		
}
