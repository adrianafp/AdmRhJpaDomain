package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Rlogreloj;
import uy.org.aladi.admrh.jpadomain.repository.RlogrelojRepository;
import uy.org.aladi.admrh.jpadomain.repository.criteria.LogRelojSearchCriteria;

@Repository("rlogrelojRepository")
public class JpaRlogrelojRepository extends JpaRepository<Rlogreloj, Integer> implements RlogrelojRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaRlogrelojRepository(){
		super(Rlogreloj.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getCategorias() {
		
		return entityManager.createQuery("select distinct lr.categoria from Rlogreloj lr")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rlogreloj> getByCriteria(LogRelojSearchCriteria criteria) {
		List<Rlogreloj> lst = new ArrayList<Rlogreloj>();
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
				lst = entityManager.createQuery("from Rlogreloj log where " +
						"log.fecha >= :desde and log.fecha <= :hasta")
						.setParameter("desde", desde)
						.setParameter("hasta", hasta)
						.getResultList();				
			}
			else{
				lst = entityManager.createQuery("from Rlogreloj log where " +
						"log.fecha >= :desde and log.fecha <= :hasta and log.categoria =:cat")
						.setParameter("desde", desde)
						.setParameter("hasta", hasta)
						.setParameter("cat", criteria.getCategoria())
						.getResultList();								
			}
		}
		if(desde != null && hasta == null){
			if(criteria.getCategoria().equalsIgnoreCase("Todas")){
				lst = entityManager.createQuery("from Rlogreloj log where " +
						"log.fecha >= :desde")
						.setParameter("desde", desde)
						.getResultList();							
			}
			else{
				lst = entityManager.createQuery("from Rlogreloj log where " +
						"log.fecha >= :desde and log.categoria =:cat")
						.setParameter("desde", desde)
						.setParameter("cat", criteria.getCategoria())
						.getResultList();							
			}
		}
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rlogreloj> getMsgByFecha(Date sfecha) {
		List<Rlogreloj> lst = entityManager.createQuery("from Rlogreloj lr where lr.fecha =:fec " +
				"and lr.mensajeUsuario <> null")
				.setParameter("fec", sfecha)
				.getResultList();
		
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rlogreloj> getByControlAusencia(Date fecha) throws Exception {
		try{
			List<Rlogreloj> lst = entityManager.createQuery("from Rlogreloj lr where lr.fecha =:fec " +
					"and lr.procedimiento =:proc")
					.setParameter("fec", fecha)
					.setParameter("proc", "Control de Ausencias")
					.getResultList();
			return lst;
		}
		catch(Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

}
