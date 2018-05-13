package uy.org.aladi.admrh.jpadomain.daojpa;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fadicionesdescsalud;
import uy.org.aladi.admrh.jpadomain.repository.FadicdescsaludRepository;

@Repository("fadicdescsaludRepository")
public class JpaFadicdescsaludRepository extends JpaRepository<Fadicionesdescsalud, Integer> implements FadicdescsaludRepository {

	private static final long serialVersionUID = 8109247013039398149L;

	public JpaFadicdescsaludRepository() {
		super(Fadicionesdescsalud.class);
	}

	@Override
	@Transactional
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fadicionesdescsalud fads ").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Short> getCodigosByMesLiquidacion(String mesLiquidacion) {
		return entityManager.createQuery("select distinct fad.fcodigos.idFcodigos from Fadicionesdescsalud fad " +
				"where fad.mesLiquidacion =:mesLiq")
				.setParameter("mesLiq", mesLiquidacion)
				.getResultList();
	}

	@Override
	public BigDecimal getSumaByCodigo(Short codigo, String mesLiquidacion) {
		return (BigDecimal)entityManager.createQuery("select SUM(fads.importe) from Fadicionesdescsalud fads " +
				"where fads.fcodigos.idFcodigos =:idcod and fads.mesLiquidacion =:mesLiq")
				.setParameter("idcod", codigo)
				.setParameter("mesLiq", mesLiquidacion)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fadicionesdescsalud> getByCodigoyMesLiquidacion(Short codigo,
			String mesLiquidacion) {

		return entityManager.createQuery("from Fadicionesdescsalud fads where fads.mesLiquidacion =:mesLiq and " +
				"fads.fcodigos.idFcodigos =:idcod order by fads.idFMutualistas, fads.tarjeta")
				.setParameter("mesLiq", mesLiquidacion)
				.setParameter("idcod", codigo)
				.getResultList();
	}

	@Override
	public BigDecimal getSumaByCodigoyMutualista(Short codigo, Integer codMut, String mesLiquidacion){
		return (BigDecimal)entityManager.createQuery("select SUM(fads.importe) from Fadicionesdescsalud fads " +
				"where fads.fcodigos.idFcodigos =:idcod and fads.idFMutualistas =:idmut and fads.mesLiquidacion =:mesLiq")
				.setParameter("idcod", codigo)
				.setParameter("idmut", codMut)
				.setParameter("mesLiq", mesLiquidacion)
				.getSingleResult();
	}

}
