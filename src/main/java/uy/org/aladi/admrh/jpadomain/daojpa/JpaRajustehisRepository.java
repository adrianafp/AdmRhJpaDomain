package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rajustehis;
import uy.org.aladi.admrh.jpadomain.repository.RajustehisRepository;

@Repository("rajustehisRepository")
public class JpaRajustehisRepository extends JpaRepository<Rajustehis, Integer> implements RajustehisRepository{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8463230964510135593L;

	public JpaRajustehisRepository() {
		super(Rajustehis.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rajustehis> getByFuncionario(Short tarjeta) {
		try{
			return entityManager.createQuery("from Rajustehis raa where raa.tarjeta =:tar order by raa.mesAjuste desc")
					.setParameter("tar", tarjeta)
					.getResultList();			
		}
		catch(Exception ex){
			return null;
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String agregarNuevos() {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("insert into Rajustehis (dias, fechadesde, fechahasta, " +
			"horas, idGplanta, mesAjuste, mesCierre, pasaA, pasaDe, tarjeta, tipoCierre) " +
			"select raj.dias, raj.fechadesde, raj.fechahasta, raj.horas, raj.idGplanta, " +
			"raj.mesAjuste, raj.mesCierre, raj.pasaA, raj.pasaDe, raj.tarjeta, raj.tipoCierre " +
			"from Rajusteanio raj").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

}
