package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rajusteanio;
import uy.org.aladi.admrh.jpadomain.repository.RajusteanioRepository;

@Repository("rajusteanioRepository")
public class JpaRajusteanioRepository extends JpaRepository<Rajusteanio, Integer> implements RajusteanioRepository{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8463230964510135593L;

	public JpaRajusteanioRepository() {
		super(Rajusteanio.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rajusteanio> getByFuncionario(Short tarjeta) {
		try{
			return entityManager.createQuery("from Rajusteanio raa where raa.tarjeta =:tar order by raa.mesAjuste desc")
					.setParameter("tar", tarjeta)
					.getResultList();			
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rajusteanio> getByFuncioanrioyMesCierre(Short tarjeta,
			String mesCierre, String mesAjuste) {
		try{
			return entityManager.createQuery("from Rajusteanio raa where raa.tarjeta =:tar and " + 
					"raa.mesCierre =:mesc and raa.mesAjuste =:mesa order by raa.mesAjuste desc")
					.setParameter("tar", tarjeta)
					.setParameter("mesc", mesCierre)
					.setParameter("mesa", mesAjuste)
					.getResultList();			
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=false)
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rajusteanio raj").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rajusteanio> getByPasadeyMesCierre(Short codigo,
			String mesCierre) {
		try{
			return entityManager.createQuery("from Rajusteanio raa where " + 
					"raa.mesCierre =:mesc and raa.pasaDe =:cod order by raa.tarjeta")
					.setParameter("mesc", mesCierre)
					.setParameter("cod", codigo)
					.getResultList();			
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rajusteanio> getByPasaDeyMesAjuste(Short codigo,
			String mesAjuste) {
		try{
			return entityManager.createQuery("from Rajusteanio raa where " + 
					"raa.mesAjuste =:mesc and raa.pasaDe =:cod order by raa.tarjeta")
					.setParameter("mesc", mesAjuste)
					.setParameter("cod", codigo)
					.getResultList();			
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rajusteanio> getByPasaAyMesAjuste(Short codigo, String mesAjuste) {
		try{
			return entityManager.createQuery("from Rajusteanio raa where " + 
					"raa.mesAjuste =:mesc and raa.pasaA =:cod order by raa.tarjeta")
					.setParameter("mesc", mesAjuste)
					.setParameter("cod", codigo)
					.getResultList();			
		}
		catch(Exception ex){
			return null;
		}
	}

}
