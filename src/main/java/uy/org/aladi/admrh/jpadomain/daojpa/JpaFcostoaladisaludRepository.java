package uy.org.aladi.admrh.jpadomain.daojpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fcostoaladisalud;
import uy.org.aladi.admrh.jpadomain.repository.FcostoaladisaludRepository;

@Repository("fcostoaladisaludRepository")
public class JpaFcostoaladisaludRepository extends JpaRepository<Fcostoaladisalud, Integer> implements FcostoaladisaludRepository{

	private static final long serialVersionUID = 1730697441085711455L;

	public JpaFcostoaladisaludRepository() {
		super(Fcostoaladisalud.class);
	}

	@Override
	public String eliminarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fcostoaladisalud getByFuncyMesLiquidacion(Short tarjeta,
			String mesLiquidacion) {
		try{
			return (Fcostoaladisalud) entityManager.createQuery("from Fcostoaladisalud fcs where fcs.tarjeta =:tar " +
				"and fcs.mesLiquidacion =:mesLiq")
				.setParameter("tar", tarjeta)
				.setParameter("mesLiq", mesLiquidacion)
				.getSingleResult();
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=false)
	public String eliminarByFuncyMesLiquidacion(Short tarjeta,
			String mesLiquidacion) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcostoaladisalud fcs where fcs.tarjeta =:tar and " +
					"fcs.mesLiquidacion =:mesLiq")
					.setParameter("tar", tarjeta)
					.setParameter("mesLiq", mesLiquidacion)
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}
	}

	@Override
	@Transactional(readOnly=false)
	public String eliminarByMesLiquidacion(String mesLiquidacion) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcostoaladisalud fcs where " +
					"fcs.mesLiquidacion =:mesLiq")
					.setParameter("mesLiq", mesLiquidacion)
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}

	}

	@Override
	@Transactional(readOnly=false)
	public String eliminarNotInGrupoyMesLiquidacion(String grupo,
			String mesLiquidacion) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcostoaladisalud fcs where fcs.mesLiquidacion =:mesLiq and " +
					"fcs.tarjeta NOT IN (" + grupo +")")
					.setParameter("mesLiq", mesLiquidacion)
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}
	}

}
