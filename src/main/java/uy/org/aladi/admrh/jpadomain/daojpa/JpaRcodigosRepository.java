package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Rcodigos;
import uy.org.aladi.admrh.jpadomain.repository.RcodigosRepository;

@Repository("rcodigosRepository")
public class JpaRcodigosRepository extends JpaRepository<Rcodigos, Short> implements RcodigosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRcodigosRepository(){
		super(Rcodigos.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rcodigos> getCodigosDias() {
		Boolean dias = true;
		return entityManager.createQuery("from Rcodigos rc where rc.diasAusent =:dias")
				.setParameter("dias", dias)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rcodigos> getCodigosHoras() {
		Boolean dias = false;
		return entityManager.createQuery("from Rcodigos rc where rc.diasAusent =:dias")
				.setParameter("dias", dias)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rcodigos> getCodigosHorasSinCero() {
		Boolean dias = false;
		Short codigoCero = Short.valueOf("0");
		return entityManager.createQuery("from Rcodigos rc where rc.diasAusent =:dias and " +
				"rc.idRcodigos <> :cod")
				.setParameter("dias", dias)
				.setParameter("cod", codigoCero)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rcodigos> getCodigosBoletas() {
		String codQL = "21, 24, 41, 51, 80, 83";
		
		return entityManager.createQuery("from Rcodigos rc where rc.idRcodigos IN (" + codQL + ")")
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rcodigos> getCodigosLicencias() {
		String codQL = "29, 30, 33, 34, 37, 38";
		return entityManager.createQuery("from Rcodigos rc where rc.idRcodigos IN (" + codQL + ")")
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rcodigos> getCodigosLicenciasUsuarios() {
		String codQL = "29, 30, 33";
		return entityManager.createQuery("from Rcodigos rc where rc.idRcodigos IN (" + codQL + ")")
				.getResultList();
	}

}
