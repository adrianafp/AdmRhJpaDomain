package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rausentes;
import uy.org.aladi.admrh.jpadomain.repository.RausentesRepository;

@Repository("rausentesRepository")
public class JpaRausentesRepository extends JpaRepository<Rausentes, Long> implements RausentesRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRausentesRepository(){
		super(Rausentes.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rausentes> getByFuncionario(Short tarjeta) {
		List<Rausentes> lst = entityManager.createQuery("from Rausentes raus where raus.tarjeta =:tar order by raus.fechac desc")
				.setParameter("tar", tarjeta)
				.getResultList();
		
		return lst;
	}


	@Override
	public Rausentes getByFuncionarioyFecha(Short tarjeta, Date fecha) {
		try{
			return (Rausentes)entityManager.createQuery("from Rausentes raus where " +
					"raus.tarjeta =:tar and raus.fechac <=:fecha1 and raus.fechaf >=:fecha2")
					.setParameter("tar", tarjeta)
					.setParameter("fecha1", fecha)
					.setParameter("fecha2", fecha)
					.getSingleResult();
		}
		catch(NoResultException ex){
			return null;
		}
		catch(Exception nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public Boolean ausenciaRepetidaFuncionario(Short tarjeta, Date fechac,
			Date fechaf) {
		try{
			List<Rausentes> ausencias = new ArrayList<Rausentes>();
			ausencias = entityManager.createQuery("from Rausentes raus where raus.tarjeta =:tar and " +
			"(raus.fechac <=:fecha1 and raus.fechaf >=:fecha2)")
			.setParameter("tar", tarjeta)
			.setParameter("fecha1", fechac)
			.setParameter("fecha2", fechaf)
			.getResultList();
			if(ausencias.size() > 0){
				return true;
			}
			else{
				ausencias = entityManager.createQuery("from Rausentes raus where raus.tarjeta =:tar and " +
					"(raus.fechac >=:fecha1 and raus.fechaf <=:fecha2)")
					.setParameter("tar", tarjeta)
					.setParameter("fecha1", fechac)
					.setParameter("fecha2", fechaf)
					.getResultList();
				if(ausencias.size() > 0){
					return true;
				}	
				else{
					ausencias = entityManager.createQuery("from Rausentes raus where raus.tarjeta =:tar and " +
						"(raus.fechac <=:fecha1 and raus.fechaf >=:fecha2)")
						.setParameter("tar", tarjeta)
						.setParameter("fecha1", fechaf)
						.setParameter("fecha2", fechaf)
						.getResultList();
					if(ausencias.size() > 0){
						return true;
					}	
				}
			}
			
			return false;
		}
		catch(NoResultException nex){
			return false;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public Boolean actualizacionSolapadaFuncionario(Short tarjeta,
			Long idausencia, Date fechac, Date fechaf) {
		try{
			List<Rausentes> ausencias = new ArrayList<Rausentes>();
			ausencias = entityManager.createQuery("from Rausentes raus where raus.tarjeta =:tar and " +
			"raus.idRausentes <> :id and (raus.fechac >=:fecha1 or raus.fechaf >=:fecha2)")
			.setParameter("tar", tarjeta)
			.setParameter("id", idausencia)
			.setParameter("fecha1", fechac)
			.setParameter("fecha2", fechac)
			.getResultList();
			if(ausencias.size() > 0){
				return true;
			}
			else{
				ausencias = entityManager.createQuery("from Rausentes raus where raus.tarjeta =:tar and " +
				"raus.idRausentes <> :id and raus.fechaf >=:fecha2")
				.setParameter("tar", tarjeta)
				.setParameter("id", idausencia)
				.setParameter("fecha2", fechaf)
				.getResultList();
				if(ausencias.size() > 0){
					return true;
				}
			}
			return false;
		}
		catch(NoResultException nex){
			return false;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rausentes> getTodosOrdenados() {
		return entityManager.createQuery("from Rausentes raus order by raus.fechac desc")
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rausentes> getByFuncionarioyFechas(Short tarjeta, Date fechac,
			Date fechaf) {
		try{
			return entityManager.createQuery("from Rausentes raus where raus.tarjeta =:tar " +
					"and ((raus.fechac >= :f1 and raus.fechac <=:f2) or (raus.fechac <= :f3 and raus.fechaf >= :f4)) order by raus.fechac desc")
					.setParameter("tar", tarjeta)
					.setParameter("f1", fechac)
					.setParameter("f2", fechaf)
					.setParameter("f3", fechac)
					.setParameter("f4", fechac)
					.getResultList();
			
		}
		catch(Exception ex){
			return null;
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String eliminarAntiguos(Date fechaTope) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rausentes rau where rau.fechaf <:ftope")
			.setParameter("ftope", fechaTope)
			.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rausentes> getByFuncionarioCodigoyAnio(Short tarjeta,
			Short cod, Integer anio) {
		try{
			List<Rausentes> lst = entityManager.createQuery("from Rausentes rau where rau.tarjeta =:tar and " +
					"rau.rcodigos.idRcodigos =:cod and year(rau.fechac) =:anio")
					.setParameter("tar", tarjeta)
					.setParameter("cod", cod)
					.setParameter("anio", anio)
					.getResultList();
			return lst;
			
		}
		catch(NoResultException nex){
			return null;
		}
	}

}
