package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rferiados;
import uy.org.aladi.admrh.jpadomain.repository.RferiadosRepository;

@Repository("rferiadosRepository")
public class JpaRferiadosRepository extends JpaRepository<Rferiados, Integer> implements RferiadosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRferiadosRepository(){
		super(Rferiados.class);
	}

	@Override
	@Transactional(readOnly=false)
	public String updateUno(Integer id, Date fecha, String motivo,
			Boolean doble) {
		String result = "fail";
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("update Rferiados rf set rf.fecha =:fecha, rf.motivo =:motivo, rf.doble =:doble " +
					"where rf.idRferiados =:id")
					.setParameter("fecha", fecha)
					.setParameter("motivo", motivo)
					.setParameter("doble", doble)
					.setParameter("id", id)
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return result;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rferiados> getTodos()  {
		try{
			List<Rferiados> lstferiados = entityManager.createQuery("from Rferiados rf order by rf.fecha desc")
					.getResultList();
			return lstferiados;
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	public Rferiados getByFecha(Date fecha) {
		try{
			return (Rferiados) entityManager.createQuery("from Rferiados rf where rf.fecha =:data")
					.setParameter("data", fecha)
					.getSingleResult();
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	public Boolean esFeriado(Date fecha) {
		try{
			@SuppressWarnings("unused")
			Rferiados fer = (Rferiados) entityManager.createQuery("from Rferiados rf where rf.fecha =:data")
					.setParameter("data", fecha)
					.getSingleResult();
			return true;
		}
		catch(NoResultException nex){
			return false;
		}
	}

}
