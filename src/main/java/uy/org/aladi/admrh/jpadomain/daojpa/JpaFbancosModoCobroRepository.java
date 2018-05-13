package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.FbancosModocobro;
import uy.org.aladi.admrh.jpadomain.repository.FbancosModoCobroRepository;

@Repository("fbancosModocobroRepository")
public class JpaFbancosModoCobroRepository extends JpaRepository<FbancosModocobro, Integer> implements FbancosModoCobroRepository {

	private static final long serialVersionUID = -8035960073747455912L;

	public JpaFbancosModoCobroRepository() {
		super(FbancosModocobro.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FbancosModocobro> getBancos() {
		return entityManager.createQuery("from FbancosModocobro fbm where fbm.banco <> 'Cheque'").getResultList();
	}

	@Override
	public FbancosModocobro findByName(String name) {
		return (FbancosModocobro) entityManager.createQuery("from FbancosModocobro fbm where fbm.banco =:nombre")
				.setParameter("nombre", name)
				.getSingleResult();
	}

}
