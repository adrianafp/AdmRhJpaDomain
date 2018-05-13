package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rmarcatmp;
import uy.org.aladi.admrh.jpadomain.repository.RmarcatmpRepository;

@Repository("rmarcatmpRepository")
public class JpaRmarcatmpRepository extends JpaRepository<Rmarcatmp, Integer> implements RmarcatmpRepository, Serializable {

	private static final long serialVersionUID = 640853761630243688L;

	public JpaRmarcatmpRepository() {
		super(Rmarcatmp.class);
	}


	@Override
	public Rmarcatmp getFirst(Short referencia) {
		try{
			Integer id = (Integer)entityManager.createQuery("select Min(rm.idrmarcatmp) from "+
					"Rmarcatmp rm where rm.tarjeta >= :minima")
					.setParameter("minima", referencia)
					.getSingleResult();
			return (Rmarcatmp) entityManager.createQuery("from Rmarcatmp rmt where rmt.idrmarcatmp = :id")
					 	.setParameter("id", id)
					 	.getSingleResult();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Date> getFechas() {
		List<Date> lst = entityManager.createQuery("select distinct rm.fecha from Rmarcatmp rm ").getResultList();
		return lst;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcatmp> getMarcasPorFecha(Date fecha) {
		List<Rmarcatmp> lst = entityManager.createQuery("from Rmarcatmp rm where " + 
				"rm.fecha =:dia order by rm.tarjeta, rm.fecha, rm.hora")
				.setParameter("dia", fecha)
				.getResultList();
		return lst;
	}



	@SuppressWarnings("unchecked")
	@Override
	public Rmarcatmp getSiguiente(Short tarjeta, Date fecha, Time hora) {
		List<Rmarcatmp> lst = entityManager.createQuery("from Rmarcatmp rmt where " +
				"rmt.tarjeta =:tar and rmt.fecha =:dia and rmt.hora >:hour order by rmt.hora")
				.setParameter("tar", tarjeta)
				.setParameter("dia", fecha)
				.setParameter("hour", hora)
				.getResultList();
		if(lst.size() > 0){
			return lst.get(0);
		}
		else{
			return null;
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String limpiar() {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("delete from Rmarcatmp").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}
}
