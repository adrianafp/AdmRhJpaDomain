package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Ractreganio;
import uy.org.aladi.admrh.jpadomain.repository.RactreganioRepository;

@Repository("ractreganioRepository")
public class JpaRactreganioRepository extends JpaRepository<Ractreganio, Long> implements RactreganioRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRactreganioRepository(){
		super(Ractreganio.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> getLstAnioMes() {
		List<String> lstanioMes = entityManager.createQuery("select distinct ar.mesnro from Ractreganio ar")
				.getResultList();
		return lstanioMes;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreganio> getAllByAnioMes(String anioMes) {
		try{
			return entityManager.createQuery("from Ractreganio ar where ar.mesnro =:mes")
					.setParameter("mes", anioMes)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}


	@Override
	public Ractreganio getByTarjetayAniomes(Short tarjeta, String aniomes) {
		try{
			return (Ractreganio)entityManager.createQuery("from Ractreganio ar where ar.mesnro =:mes and " +
					"ar.tarjeta =:tar")
					.setParameter("mes", aniomes)
					.setParameter("tar", tarjeta)
					.getSingleResult();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreganio> getByTarjetayPeriodo(Short tarjeta,
			String anioMes1, String anioMes2) {
		try{
			return entityManager.createQuery("from Ractreganio ar where ar.mesnro >=:mes1 and " +
					"ar.mesnro <=:mes2 and ar.tarjeta =:tar")
					.setParameter("mes1", anioMes1)
					.setParameter("mes2", anioMes2)
					.setParameter("tar", tarjeta)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreganio> getAllByPeriodo(String anioMes1, String anioMes2) {
		try{
			return entityManager.createQuery("from Ractreganio ar where ar.mesnro >=:mes1 and " +
					"ar.mesnro <=:mes2")
					.setParameter("mes1", anioMes1)
					.setParameter("mes2", anioMes2)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreganio> getByDeptoyPeriodo(String tarjetas,
			String anioMes1, String anioMes2) {
		try{
			return entityManager.createQuery("from Ractreganio ar where ar.mesnro >=:mes1 and " +
					"ar.mesnro <=:mes2 and ar.tarjeta IN(" + tarjetas + ")")
					.setParameter("mes1", anioMes1)
					.setParameter("mes2", anioMes2)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> periodoExistente(String anioMes1, String anioMes2) {
		List<String> lstmeses = new ArrayList<String>();
		List<Ractreganio> lst = entityManager.createQuery("from Ractreganio ar where ar.mesnro >=:mes1 " +
				"and ar.mesnro <=:mes2")
				.setParameter("mes1", anioMes1)
				.setParameter("mes2", anioMes2)
				.getResultList();
		if(lst.size() > 0){
			String am1 = lst.get(0).getMesnro();
			String am2 = lst.get(lst.size() - 1).getMesnro();
			lstmeses.add(am1);
			lstmeses.add(am2);
			return lstmeses;
		}
		else{
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<String> periodoExistenteByFuncionario(Short tarjeta,
			String anioMes1, String anioMes2) {
		List<String> lstmeses = new ArrayList<String>();
		List<Ractreganio> lst = entityManager.createQuery("from Ractreganio ar where ar.tarjeta =:tar and " +
				"ar.mesnro >=:mes1 and ar.mesnro <=:mes2")
				.setParameter("tar", tarjeta)
				.setParameter("mes1", anioMes1)
				.setParameter("mes2", anioMes2)
				.getResultList();
		if(lst.size() > 0){
			String am1 = lst.get(0).getMesnro();
			String am2 = lst.get(lst.size() - 1).getMesnro();
			lstmeses.add(am1);
			lstmeses.add(am2);
			return lstmeses;
		}
		else{
			return null;
		}
	}

	@Override
	@Transactional
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Ractreganio rar").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreganio> getExtrasSimples(String anioMes) {
		return entityManager.createQuery("from Ractreganio ar where ar.mesnro =:am and " +
				"ar.extSim_horas <> null")
				.setParameter("am", anioMes)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreganio> getExtrasDobles(String anioMes) {
		return entityManager.createQuery("from Ractreganio ar where ar.mesnro =:am and " +
				" ar.extDob_horas <> null")
				.setParameter("am", anioMes)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Ractreganio> getExcAtFliar(String anioMes) {
		return entityManager.createQuery("from Ractreganio ar where ar.mesnro =:am and " +
				"ar.excat_horas <> null")
				.setParameter("am", anioMes)
				.getResultList();
	}



}
