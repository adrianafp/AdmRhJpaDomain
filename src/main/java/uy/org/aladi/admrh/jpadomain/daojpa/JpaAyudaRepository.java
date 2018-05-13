package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Ayuda;
import uy.org.aladi.admrh.jpadomain.repository.AyudaRepository;
import uy.org.aladi.admrh.jpadomain.repository.criteria.AyudaSearchCriteria;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository("ayudaRepository")
public class JpaAyudaRepository extends JpaRepository<Ayuda, Integer> implements AyudaRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaAyudaRepository(){
		super(Ayuda.class);
	}

	public Ayuda getByClave(String clave){
		if(clave == null){
			return null;
		}
		Ayuda help = (Ayuda) entityManager.createQuery("Select a from Ayuda a where a.clave = :key")
				.setParameter("key", clave).getSingleResult();
		return help;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Ayuda> getByCriteria(AyudaSearchCriteria criteria){
	
		if(criteria == null){
			return null;
		}
		String q = "select * from " +  Ayuda.class.getSimpleName() + " a where a.clave =:clv";
		
		Query query = entityManager.createQuery(q);
		query.setParameter("clv", criteria.getClave());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ayuda> getLstByClave(String clave) {
		Integer largo;
		if(clave == null){
			return null;
		}
		else{
			largo = clave.length();
		}
		
		List<Ayuda> help = entityManager.createQuery("Select a from Ayuda a where " +
				"substring(a.clave, 1, " + largo + ") = :key")
				.setParameter("key", clave).getResultList();
		return help;
	}
}
