package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fmutualistasplanes;
import uy.org.aladi.admrh.jpadomain.entities.Gcargas;
import uy.org.aladi.admrh.jpadomain.entities.Gmodcargas;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.GcargasRepository;

@Repository("gcargasRepository")
public class JpaGcargasRepository extends JpaRepository<Gcargas, Integer> implements GcargasRepository{


	/**
	 * 
	 */
	private static final long serialVersionUID = 421959490081882825L;


	public JpaGcargasRepository(){
		super(Gcargas.class);
	}


	@SuppressWarnings("unchecked")
	public List<Gcargas> getByFuncionario(Gplanta func) {
		try{
			List<Gcargas> lst = entityManager.createQuery("from Gcargas gc where " + 
					"gc.gplanta.idGplanta =:id")
					.setParameter("id", func.getIdGplanta())
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	public List<Gcargas> getByMutualistaPlan(Fmutualistasplanes plan) {
		try{
			List<Gcargas> lst = entityManager.createQuery("from Gcargas g where " +
					"g.fmutualistasplanes.idFmutualistasPlanes =:id")
					.setParameter("id", plan.getIdFmutualistasPlanes())
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@Override
	public Gcargas getByFuncionarioyNombre(Long idFunc, String Nombre) {
		try{
			Gcargas cargareg = (Gcargas)entityManager.createQuery("from Gcargas gc where gc.gplanta.idGplanta =:idF " +
					"and gc.nombreFamiliar =:nombre")
					.setParameter("idF", idFunc)
					.setParameter("nombre", Nombre)
					.getSingleResult();
			return cargareg;			
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gcargas> getHijos() {
		try{
			String hijo = "Hijo/a";
			List<Gcargas> lst = entityManager.createQuery("from Gcargas g where " + 
					"g.parentesco =:hijo")
					.setParameter("hijo", hijo)
					.getResultList();
			return lst;
		}
		catch(Exception ex){
			return null;
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String deleteByIds(String ids) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Gcargas g where g.idGcargas IN ( " + ids +
					")").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gmodcargas> getModificaciones() {

		try{
			Boolean procesados = false;
			return entityManager.createQuery("from Gmodcargas gmc where gmc.seProceso =:proc")
					.setParameter("proc", procesados)
					.getResultList();
		}
		catch(Exception ex){
			return null;			
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gmodcargas> getModifByFuncionario(Short tarjeta) {
		try{
			Boolean procesados = false;
			return entityManager.createQuery("from Gmodcargas gmc where gmc.tarjeta =:tar and gmc.seProceso =:proc")
					.setParameter("tar", tarjeta)
					.setParameter("proc", procesados)
					.getResultList();
		}
		catch(Exception ex){
			return null;			
		}
	}

}
