package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fadpermanentes;
import uy.org.aladi.admrh.jpadomain.repository.FadpermanentesRepository;

@Repository("fadpermanentesRepository")
public class JpaFadpermanentesRepository extends JpaRepository<Fadpermanentes, Long> implements FadpermanentesRepository, Serializable {

	private static final long serialVersionUID = 4649419100993302112L;
	
	public JpaFadpermanentesRepository() {
		super(Fadpermanentes.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fadpermanentes> getByFuncionario(Short tarjeta) {
		return entityManager.createQuery("from Fadpermanentes fadp where fadp.tarjeta =:tar")
				.setParameter("tar", tarjeta)
				.getResultList();
	}

	@Override
	public Fadpermanentes getByFuncionarioyCodigo(Short tarjeta, Short idcodigo) {
		return (Fadpermanentes) entityManager.createQuery("from Fadpermanentes fadp where fadp.tarjeta =:tar " +
				"and fadp.fcodigos.idFcodigos =:cod")
				.setParameter("tar", tarjeta)
				.setParameter("cod", idcodigo)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fadpermanentes> getSumasVigentes(Date today) {
		return entityManager.createQuery("from Fadpermanentes fadp where fadp.sumaResta =:sr and " +
				"(fadp.fechaHasta >=:today or fadp.fechaHasta is null) order by fadp.tarjeta")
				.setParameter("sr", Short.valueOf("1"))
				.setParameter("today", today)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fadpermanentes> getRestasVigentes(Date today) {
		return entityManager.createQuery("from Fadpermanentes fadp where fadp.sumaResta =:sr and " +
				"(fadp.fechaHasta >=:today or fadp.fechaHasta is null) order by fadp.tarjeta")
				.setParameter("sr", Short.valueOf("2"))
				.setParameter("today", today)
				.getResultList();
	}

}
