package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Gmodcargas;
import uy.org.aladi.admrh.jpadomain.repository.GmodcargasRepository;

@Repository("gmodcargasRepository")
public class JpaGmodcargasRepository extends JpaRepository<Gmodcargas, Integer> implements GmodcargasRepository, Serializable {

	private static final long serialVersionUID = 2238719720751965253L;

	public JpaGmodcargasRepository() {
		super(Gmodcargas.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gmodcargas> getNoprocesadosByFunc(Short tarjeta) {
		
		Boolean procesado = false;
		List<Gmodcargas> lstmod = new ArrayList<Gmodcargas>();
		lstmod = entityManager.createQuery("from Gmodcargas gmc where " +
				"gmc.tarjeta =:tar and gmc.seProceso =:proces")
				.setParameter("tar", tarjeta)
				.setParameter("proces", procesado)
				.getResultList();
		return lstmod;
		
	}

}
