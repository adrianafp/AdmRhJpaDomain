package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fafaladiprestamos;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.FafaladiprestamosRepository;

@Repository("fafaladiprestamosRepository")
public class JpaFafaladiprestamosRepository extends JpaRepository<Fafaladiprestamos, Integer> implements FafaladiprestamosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994470987435373982L;

	public JpaFafaladiprestamosRepository(){
		super(Fafaladiprestamos.class);
	}

	@SuppressWarnings("unchecked")
	public List<Fafaladiprestamos> getByFunc(Long idFunc) {
		List<Fafaladiprestamos>lst = entityManager.createQuery("from Fafaladiprestamos fp where " +
				"fp.gplanta.idGplanta =:id ")
				.setParameter("id", idFunc)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Fafaladiprestamos> getPendientesByFunc(Long idFunc) {
		List<Fafaladiprestamos>lst = entityManager.createQuery("from Fafaladiprestamos fp where " +
				"fp.gplanta.idGplanta =:id and fp.cantCuotas > fp.cuotasPagas")
				.setParameter("id", idFunc)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Fafaladiprestamos> getByFuncyTipo(Long idFunc, String tipo) {
		Boolean sSalud = false;
		if(tipo.equalsIgnoreCase("SeguroSaludDolares") || tipo.equalsIgnoreCase("SeguroSaludPesos")){
			sSalud = true;
		}
		List<Fafaladiprestamos>lst = entityManager.createQuery("from Fafaladiprestamos fp where " +
				"fp.gplanta.idGplanta =:id and fp.cantCuotas > fp.cuotasPagas and fp.prestamoSeguroSalud =:ssalud")
				.setParameter("id", idFunc)
				.setParameter("ssalud", sSalud)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Fafaladiprestamos> getVigentes() {
		List<Fafaladiprestamos> lst = entityManager.createQuery("from Fafaladiprestamos fp where " +
				"fp.cuotasPagas < fp.cantCuotas").getResultList();
		
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Fafaladiprestamos> getByTipo(String tipo) {
		List<Fafaladiprestamos> lst = new ArrayList<Fafaladiprestamos>();
		Boolean prstSS;
		if(tipo.equalsIgnoreCase("SeguroSaludDolares") || tipo.equalsIgnoreCase("SeguroSaludPesos")){
			prstSS = true;
		}
		else{
			prstSS = false;			
		}
		lst = entityManager.createQuery("from Fafaladiprestamos fp where fp.prestamoSeguroSalud =:prstSS")
				.setParameter("prstSS", prstSS)
				.getResultList();

		return lst;
	}


	public Integer getMaxNroPrestamoByTipo(String tipo) {
		Boolean prstSS;
		if(tipo.equalsIgnoreCase("SeguroSalud")){
			prstSS = true;
		}
		else{
			prstSS = false;
		}
		Integer nroPrest = (Integer)entityManager.createQuery("select max(fp.nroPrestamo) from Fafaladiprestamos fp " +
				"where fp.prestamoSeguroSalud =:prstSS").setParameter("prstSS", prstSS)
				.getSingleResult();
		
		return nroPrest;
	}


	public Gplanta getTitular(Fafaladiprestamos prst) {
		Gplanta func = (Gplanta)entityManager.createQuery("from Gplanta gp where gp.idGplanta =:id")
				.setParameter("id", prst.getGplanta().getIdGplanta())
				.getSingleResult();
		return func;
	}

	public Fafaladiprestamos getByNroyTipo(Integer nro, String tipo) {
		Boolean seguroSalud = false;
		if(tipo.equalsIgnoreCase("SeguroSaludDolares") || tipo.equalsIgnoreCase("SeguroSaludPesos")){
			seguroSalud = true;
		}
		Fafaladiprestamos prst = (Fafaladiprestamos)entityManager.createQuery("from Fafaladiprestamos fp where " +
				"fp.nroPrestamo =:nro and fp.prestamoSeguroSalud =:ss")
				.setParameter("nro", nro)
				.setParameter("ss", seguroSalud)
				.getSingleResult();
		return prst;
	}
		
}
