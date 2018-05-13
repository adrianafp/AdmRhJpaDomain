package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Ggrados;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.GgradosRepository;

@Repository("ggradosRepository")
public class JpaGgradosRepository extends JpaRepository<Ggrados, Short> implements GgradosRepository, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6387107505436349066L;
	

	public JpaGgradosRepository(){
		super(Ggrados.class);
	}

	public Ggrados getByFuncionario(Gplanta func) {
		Short id = func.getGgrados().getIdGGrados();
		Ggrados grado = (Ggrados)this.findById(id);
		return grado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ggrados> getAllOrdenados() {
		return entityManager.createQuery("from Ggrados order by idGCategoria, nomGrado")
				.getResultList();
	}

}
