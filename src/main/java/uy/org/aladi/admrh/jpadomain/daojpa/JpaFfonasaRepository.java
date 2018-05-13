package uy.org.aladi.admrh.jpadomain.daojpa;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Ffonasa;
import uy.org.aladi.admrh.jpadomain.repository.FfonasaRepository;

@Repository("ffonasaRepository")
public class JpaFfonasaRepository extends JpaRepository<Ffonasa, Short> implements FfonasaRepository {

	private static final long serialVersionUID = -6136729469865816551L;

	public JpaFfonasaRepository() {
		super(Ffonasa.class);
	}

	@Override
	public Ffonasa getPorUnRango(Short edad1, Short edad2) {
		return (Ffonasa)entityManager.createQuery("from Ffonasa ff where ff.edadDesde <=:edad1 and ff.edadHasta >=:edad2")
		.setParameter("edad1", edad1)
		.setParameter("edad2", edad2)
		.getSingleResult();	
	}

}
