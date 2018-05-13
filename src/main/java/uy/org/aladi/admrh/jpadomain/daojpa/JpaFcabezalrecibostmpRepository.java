package uy.org.aladi.admrh.jpadomain.daojpa;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fcabezalrecibotmp;
import uy.org.aladi.admrh.jpadomain.repository.FcabezalrecibostmpRepository;

@Repository("fcabezalrecibostmpRepository")
public class JpaFcabezalrecibostmpRepository extends JpaRepository<Fcabezalrecibotmp, Integer> implements FcabezalrecibostmpRepository {

	private static final long serialVersionUID = 3907180330262417378L;
	
	public JpaFcabezalrecibostmpRepository() {
		super(Fcabezalrecibotmp.class);
	}

	@Override
	@Transactional
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcabezalrecibotmp fc").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}
	}

	@Override
	public Fcabezalrecibotmp getByFuncionario(Short tarjeta) {
		try{
			return (Fcabezalrecibotmp)entityManager.createQuery("from Fcabezalrecibotmp fct where fct.tarjeta =:tar")
				.setParameter("tar", tarjeta)
				.getSingleResult();
		}
		catch(NoResultException nex){
			return null;
		}
	}


}
