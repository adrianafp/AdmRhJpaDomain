package uy.org.aladi.admrh.jpadomain.daojpa;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Rcategorias;
import uy.org.aladi.admrh.jpadomain.repository.RcategoriasRepository;

@Repository("rcategoriasRepository")
public class JpaRcategoriasRepository extends JpaRepository<Rcategorias, Integer> implements RcategoriasRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaRcategoriasRepository(){
		super(Rcategorias.class);
	}

}
