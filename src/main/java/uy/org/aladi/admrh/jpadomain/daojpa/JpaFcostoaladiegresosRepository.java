package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fcostoaladiegresos;
import uy.org.aladi.admrh.jpadomain.repository.FcostoaladiegresosRepository;

@Repository("fcostoaladiegresosRepository")
public class JpaFcostoaladiegresosRepository extends JpaRepository<Fcostoaladiegresos, Long> implements FcostoaladiegresosRepository {

	private static final long serialVersionUID = 7297612924042530749L;

	public JpaFcostoaladiegresosRepository() {
		super(Fcostoaladiegresos.class);
	}

	@Override
	@Transactional
	public Boolean deleteAll() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcostoaladiegresos fcae")
					.executeUpdate();
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}

	@Override
	@Transactional
	public String deleteByFunc(Short tarjeta) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcostoaladiegresos fcae where " +
					"fcae.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcostoaladiegresos> getByFuncionario(Short tarjeta) {
		return entityManager.createQuery("from Fcostoaladiegresos fca where fca.tarjeta =:tar")
				.setParameter("tar", tarjeta)
				.getResultList();
	}

	@Override
	public Fcostoaladiegresos getByFuncyMesLiquidacion(Short tarjeta,
			String mesLiq) {
		Fcostoaladiegresos costo = (Fcostoaladiegresos)entityManager.createQuery("from Fcostoaladiegresos fca where fca.tarjeta =:tarjeta " +
				"and fca.mesAnio =:mesLiq")
				.setParameter("tarjeta", tarjeta)
				.setParameter("mesLiq", mesLiq)
				.getSingleResult();
		return costo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fcostoaladiegresos> getByMesLiquidacion(String mesLiq) {
		try{
			return entityManager.createQuery("from Fcostoaladiegresos fca where fca.mesAnio =:ma")
					.setParameter("ma", mesLiq)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}

}
