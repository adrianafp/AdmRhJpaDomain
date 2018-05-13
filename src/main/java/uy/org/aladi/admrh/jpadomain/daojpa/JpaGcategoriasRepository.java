package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Gcategorias;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.GcategoriasRepository;

@Repository("gcategoriasRepository")
public class JpaGcategoriasRepository extends JpaRepository<Gcategorias, Integer> implements GcategoriasRepository, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6387107505436349066L;
	

	public JpaGcategoriasRepository(){
		super(Gcategorias.class);
	}


	@Override
	public Gcategorias getByFuncionario(Gplanta func) {
		Integer id = func.getGcategorias().getIdGCatetoria();
		Gcategorias categ = (Gcategorias)this.findById(id);
		return categ;
	}
}
