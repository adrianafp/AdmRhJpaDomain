package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Flogfondo;
import uy.org.aladi.admrh.jpadomain.repository.LogFondoRepository;
import uy.org.aladi.admrh.jpadomain.repository.criteria.LogFondoSearchCriteria;

@Repository("logfondoRepository")
public class JpaLogFondoRepository extends JpaRepository<Flogfondo, Integer> implements LogFondoRepository, Serializable {

	private static final long serialVersionUID = -3621008181606193657L;

	public JpaLogFondoRepository() {
		super(Flogfondo.class);
	}

	@SuppressWarnings("unchecked")
	public List<Flogfondo> getByCriteria(LogFondoSearchCriteria criteria) {
		List<Flogfondo> lst = new ArrayList<Flogfondo>();
		Date desde = null;
		Date hasta = null;
		if(criteria == null){
			return null;
		}
		
		if(criteria.getFechaDesde() == null){
			return null;
		}
		else{
			desde = criteria.getFechaDesde();
		}
		if(criteria.getFechaHasta() != null){
			hasta = criteria.getFechaHasta();			
		}
		if(desde != null && hasta != null){
			if(criteria.getCategoria().equalsIgnoreCase("Todas")){
				lst = entityManager.createQuery("from Flogfondo log where " +
						"log.fecha >= :desde and log.fecha <= :hasta")
						.setParameter("desde", desde)
						.setParameter("hasta", hasta)
						.getResultList();				
			}
			else{
				lst = entityManager.createQuery("from Flogfondo log where " +
						"log.fecha >= :desde and log.fecha <= :hasta and log.categoria =:cat")
						.setParameter("desde", desde)
						.setParameter("hasta", hasta)
						.setParameter("cat", criteria.getCategoria())
						.getResultList();								
			}
		}
		if(desde != null && hasta == null){
			if(criteria.getCategoria().equalsIgnoreCase("Todas")){
				lst = entityManager.createQuery("from Flogfondo log where " +
						"log.fecha >= :desde")
						.setParameter("desde", desde)
						.getResultList();							
			}
			else{
				lst = entityManager.createQuery("from Flogfondo log where " +
						"log.fecha >= :desde and log.categoria =:cat")
						.setParameter("desde", desde)
						.setParameter("cat", criteria.getCategoria())
						.getResultList();							
			}
		}
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<String> getCategorias() {
		
		return entityManager.createQuery("select distinct flf.categoria from Flogfondo flf").getResultList();
	}

}
