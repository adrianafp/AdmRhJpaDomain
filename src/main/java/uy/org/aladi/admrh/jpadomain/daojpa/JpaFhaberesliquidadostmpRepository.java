package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fhaberesliquidadostmp;
import uy.org.aladi.admrh.jpadomain.repository.FhaberesliquidadostmpRepository;

@Repository("fhaberesliquidadostmpRepository")
public class JpaFhaberesliquidadostmpRepository extends JpaRepository<Fhaberesliquidadostmp, Long> implements FhaberesliquidadostmpRepository{

	private static final long serialVersionUID = 2250838832995730223L;

	public JpaFhaberesliquidadostmpRepository() {
		super(Fhaberesliquidadostmp.class);
	}

	@Override
	@Transactional
	public Boolean deleteAll() {
		Boolean ret;
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fhaberesliquidadostmp fht").executeUpdate();
			ret = true;
		}
		catch(Exception ex){
			ret = false;
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fhaberesliquidadostmp> getByFuncionario(Short tarjeta) {
		return entityManager.createQuery("from Fhaberesliquidadostmp fht where fht.tarjeta =:tar " +
				"order by fht.idFcodigos")
				.setParameter("tar", tarjeta)
				.getResultList();
	}



}
