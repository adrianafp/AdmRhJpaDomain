package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fcabezalrecibos;
import uy.org.aladi.admrh.jpadomain.repository.FcabezalrecibosRepository;

@Repository("fcabezalrecibosRepository")
public class JpaFcabezalrecibosRepository extends JpaRepository<Fcabezalrecibos, Integer> implements FcabezalrecibosRepository {

	private static final long serialVersionUID = 4137701084514611331L;

	public JpaFcabezalrecibosRepository() {
		super(Fcabezalrecibos.class);
	}

	@Override
	@Transactional
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcabezalrecibos fc").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@Override
	public String getMesLiquidacion() {
		String mesLiquidacion = (String)entityManager.createQuery("select distinct cr.mesLiquidacion from Fcabezalrecibos cr").getSingleResult();
		return mesLiquidacion.replaceAll("\r", "");
	}

	@Override
	public Fcabezalrecibos getByFuncionario(Short tarjeta) {
		try{
			return (Fcabezalrecibos)entityManager.createQuery("from Fcabezalrecibos fc where " +
					"fc.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.getSingleResult();
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	@Transactional
	public String eliminarUno(Short tarjeta) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fcabezalrecibos fc where fc.tarjeta =:tar")
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
	public List<Fcabezalrecibos> allByMesLiquidacion(String anioMes) {
		return entityManager.createQuery("from Fcabezalrecibos fcr where fcr.mesLiquidacion =" +
				":mesLiq")
				.setParameter("mesLiq", anioMes)
				.getResultList();
	}

}
