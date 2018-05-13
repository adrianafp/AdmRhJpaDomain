package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.entities.Gvinculofuncionariocargo;
import uy.org.aladi.admrh.jpadomain.repository.GvinculofuncionariocargoRepository;

@Repository("gvinculofuncionariocargoRepository")
public class JpaGvinculofuncionariocargoRepository extends JpaRepository<Gvinculofuncionariocargo, Long> implements GvinculofuncionariocargoRepository, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6387107505436349066L;
	

	public JpaGvinculofuncionariocargoRepository(){
		super(Gvinculofuncionariocargo.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gvinculofuncionariocargo> getAllOrdenadosByFecha() {
		try{
			return entityManager.createQuery("from Gvinculofuncionariocargo gvf order by " +
					"gvf.fechaInicial desc").getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gvinculofuncionariocargo> getByVinculo(Short vinculo) {
		try{
			List<Gvinculofuncionariocargo> lst = entityManager.createQuery("from Gvinculofuncionariocargo gvf where gvf.vinculo " +
					"=:vinc order by gvf.fechaInicial desc, gvf.tarjeta")
					.setParameter("vinc", vinculo)
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@Override
	public Gvinculofuncionariocargo getUltimoByFuncionario(Gplanta func) {
		try{
			return (Gvinculofuncionariocargo) entityManager.createQuery("from Gvinculofuncionariocargo gvf where gvf.idGplanta =:id " +
					"and gvf.fechaFinal is null")
					.setParameter("id", func.getIdGplanta())
					.getSingleResult();
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gvinculofuncionariocargo> getByFuncionario(Gplanta func) {
		try{
			return entityManager.createQuery("from Gvinculofuncionariocargo gvf where gvf.idGplanta = " +
			":id order by gvf.fechaInicial desc")
			.setParameter("id", func.getIdGplanta())
			.getResultList();
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gvinculofuncionariocargo> getPosterioresA(Date fecha) {
		try{
			return entityManager.createQuery("from Gvinculofuncionariocargo gvf where gvf.fechaInicial >=:fecha")
					.setParameter("fecha", fecha)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getTodosEnProceso() {
		try{
			List<Gplanta> lstFuncs = entityManager.createQuery("from Gplanta gp where gp.tarjeta In " +
				"(select distinct gvf.tarjeta from Gvinculofuncionariocargo gvf where gvf.vinculo < 3)")
				.getResultList();
			return lstFuncs;
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Gvinculofuncionariocargo> getUltimosCambios() {
		try{
			List<Gvinculofuncionariocargo> lst = entityManager.createQuery("from Gvinculofuncionariocargo gvf " +
					"where gvf.vinculo >= 4 and gvf.fechaFinal is null").getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}

}
