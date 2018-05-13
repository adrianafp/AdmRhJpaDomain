package uy.org.aladi.admrh.jpadomain.daojpa;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rparam;
import uy.org.aladi.admrh.jpadomain.repository.RparamRepository;

@Repository("rparamRepository")
public class JpaRparamRepository extends JpaRepository<Rparam, Integer> implements RparamRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaRparamRepository(){
		super(Rparam.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rparam> getByFechaDesde(Date fecha) {
		List<Rparam> lsthorario = entityManager.createQuery("from Rparam rp where rp.fechac >=:fec order by rp.fechac desc")
				.setParameter("fec", fecha)
				.getResultList();
		
		return lsthorario;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rparam> getTodosOrdenados() {
		List<Rparam> lstTodos = entityManager.createQuery("from Rparam rp order by rp.fechac desc").getResultList();
		return lstTodos;
	}

	@Override
	@Transactional(readOnly=false)
	public String actualizarFechaFin(Integer id, Date fecha, Time hora) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("update Rparam rp set rp.fechaf =:data, rp.sal_gral =:hora where rp.idRparam =:id")
				.setParameter("data", fecha)
				.setParameter("hora", hora)
				.setParameter("id", id)
				.executeUpdate();
			return "success";	
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@Override
	public Rparam getByFecha(Date fecha) {
		try{
			Rparam horario = (Rparam)entityManager.createQuery("from Rparam rp where rp.fechac <=:fec1 and rp.fechaf >=:fec2")
					.setParameter("fec1", fecha)
					.setParameter("fec2", fecha)
					.getSingleResult();
			
			return horario;			
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rparam> getByPeriodo(Date fechac, Date fechaf) {
		try{
			List<Rparam> horarios = entityManager.createQuery("from Rparam rp where rp.fechac >=:fec1 or rp.fechaf <=:fec2")
					.setParameter("fec1", fechac)
					.setParameter("fec2", fechaf)
					.getResultList();
			
			return horarios;			
		}
		catch(NoResultException nex){
			return null;
		}
	}

}
