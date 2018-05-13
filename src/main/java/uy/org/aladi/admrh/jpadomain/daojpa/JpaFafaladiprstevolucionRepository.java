package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import uy.org.aladi.admrh.jpadomain.entities.Fafaladiprestamos;
import uy.org.aladi.admrh.jpadomain.entities.Fafaladiprstevolucion;
import uy.org.aladi.admrh.jpadomain.repository.FafaladiprstevolucionRepository;

@Repository("fafaladiprstevolucionRepository")
public class JpaFafaladiprstevolucionRepository extends JpaRepository<Fafaladiprstevolucion, Integer> implements FafaladiprstevolucionRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFafaladiprstevolucionRepository(){
		super(Fafaladiprstevolucion.class);
	}



	@SuppressWarnings("unchecked")
	public List<Fafaladiprstevolucion> getByPrst(Fafaladiprestamos prst) {
		List<Fafaladiprstevolucion> lst = entityManager.createQuery("from Fafaladiprstevolucion fpe " +
				"where fpe.fafaladiprestamos.idFAfaladiPrestamos =:id")
				.setParameter("id", prst.getIdFAfaladiPrestamos())
				.getResultList();
		
		return lst;
	}
		
		
}
