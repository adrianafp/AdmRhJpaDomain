package uy.org.aladi.admrh.jpadomain.daojpa;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fparamcargas;
import uy.org.aladi.admrh.jpadomain.repository.FparamcargasRepository;

@Repository("fparamcargasRepository")
public class JpaFparamcargasRepository extends JpaRepository<Fparamcargas, Long> implements FparamcargasRepository{

	private static final long serialVersionUID = 6295378383771715046L;

	public JpaFparamcargasRepository() {
		super(Fparamcargas.class);
	}

	@Override
	public Fparamcargas getByIdCarga(Integer id) {
		return (Fparamcargas) entityManager.createQuery("from Fparamcargas fpc " +
				"where fpc.gcargas.idGcargas =:id")
				.setParameter("id", id)
				.getSingleResult();
	}

}
