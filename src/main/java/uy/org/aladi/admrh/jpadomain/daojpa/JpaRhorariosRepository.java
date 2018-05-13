package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rhorarios;
import uy.org.aladi.admrh.jpadomain.repository.RhorariosRepository;

@Repository("rhorariosRepository")
public class JpaRhorariosRepository extends JpaRepository<Rhorarios, Long> implements RhorariosRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRhorariosRepository(){
		super(Rhorarios.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rhorarios> getByFuncionario(Short tarjeta) {
		List<Rhorarios> lst = entityManager.createQuery("from Rhorarios rhor where rhor.tarjeta =:tar " +
				"order by rhor.fechac, rhor.nroDia")
				.setParameter("tar", tarjeta)
				.getResultList();
		
		return lst;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Boolean horarioRepetidoFuncionario(Short tarjeta, Date fechac,
			Date fechaf) {
		try{
			List<Rhorarios> horarios = new ArrayList<Rhorarios>();
			horarios = entityManager.createQuery("from Rhorarios rhor where rhor.tarjeta =:tar and " +
			"(rhor.fechac >=:fecha1 or rhor.fechaf >=:fecha2)")
			.setParameter("tar", tarjeta)
			.setParameter("fecha1", fechac)
			.setParameter("fecha2", fechac)
			.getResultList();
			if(horarios.size() > 0){
				return true;
			}
			else{
				horarios = entityManager.createQuery("from Rhorarios rhor where rhor.tarjeta =:tar and " +
				" rhor.fechaf >=:fecha")
				.setParameter("tar", tarjeta)
				.setParameter("fecha", fechaf)
				.getResultList();
				if(horarios.size() > 0){
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
	public Boolean actualizacionSolapadaFuncionario(Short tarjeta,
			Long idausencia, Date fechac, Date fechaf) {
		try{
			List<Rhorarios> horarios = new ArrayList<Rhorarios>();
			horarios = entityManager.createQuery("from Rhorarios rhor where rhor.tarjeta =:tar and " +
			"rhor.idRHorarios <> :id and (rhor.fechac >=:fecha1 or rhor.fechaf >=:fecha2)")
			.setParameter("tar", tarjeta)
			.setParameter("id", idausencia)
			.setParameter("fecha1", fechac)
			.setParameter("fecha2", fechac)
			.getResultList();
			if(horarios.size() > 0){
				return true;
			}
			else{
				horarios = entityManager.createQuery("from Rhorarios rhor where rhor.tarjeta =:tar and " +
				"rhor.idRHorarios <> :id and rhor.fechaf >=:fecha2")
				.setParameter("tar", tarjeta)
				.setParameter("id", idausencia)
				.setParameter("fecha2", fechaf)
				.getResultList();
				if(horarios.size() > 0){
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
	public List<Rhorarios> getTodosOrdenados() {
		return entityManager.createQuery("from Rhorarios rhor order by rhor.fechac, rhor.tarjeta, rhor.nroDia")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rhorarios> getActuales() {
		java.sql.Date hoy = new java.sql.Date(new Date().getTime());
		return entityManager.createQuery("from Rhorarios rhor where rhor.fechaf >=:hoy order by rhor.tarjeta, rhor.fechac, rhor.nroDia")
				.setParameter("hoy", hoy)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rhorarios> getAnterioresPorFuncionario(Short tarjeta,
			Date fechaf) {
		try{
			List<Rhorarios> lsthor = entityManager.createQuery("from Rhorarios rhor where rhor.tarjeta =:tar and " +
					"rhor.fechaf <:fecha")
					.setParameter("tar", tarjeta)
					.setParameter("fecha", fechaf)
					.getResultList();
				return lsthor;			
		}
		catch (Exception ex){
			return null;
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String eliminarGrupo(String ids) {
		
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rhorarios rhor where rhor.idRHorarios in " +
					"(" + ids + ")")
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rhorarios> getByFuncionarioFecha(Short tarjeta, Date fecha) {
		List<Rhorarios> lst = entityManager.createQuery("from Rhorarios rhor where rhor.tarjeta =:tar and " +
				"rmm.fechac <=:fec1 and rmm.fechaf >=:fec2")
				.setParameter("tar", tarjeta)
				.setParameter("fec1", fecha)
				.setParameter("fec2", fecha)
				.getResultList();
		
		return lst;
	}


	@Override
	public Rhorarios getByFuncionarioFechaDia(Short tarjeta, Date fecha,
			String dia) {
		try{
			Rhorarios horario = (Rhorarios)entityManager.createQuery("from Rhorarios rhor where rhor.tarjeta =:tar and " +
					"rhor.fechac <=:fec1 and rhor.fechaf >=:fec2 and rhor.dia =:dia")
					.setParameter("tar", tarjeta)
					.setParameter("fec1", fecha)
					.setParameter("fec2", fecha)
					.setParameter("dia", dia)
					.getSingleResult();
			
			return horario;			
		}
		catch(NonUniqueResultException nuex){
			throw new NonUniqueResultException();
		}
		catch(NoResultException nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rhorarios> getByFuncHEnfermedad(Short tarjeta, Date fechac,
			Date fechaf) {
		try{
			List<Rhorarios> lsthor = entityManager.createQuery("from Rhorarios rhor where rhor.tarjeta =:tar and " +
					"(rhor.fechac >=:f1 or rhor.fechaf <=:f2) and rhor.motivo like '%Enf. C/Certificado'")
					.setParameter("tar", tarjeta)
					.setParameter("f1", fechac)
					.setParameter("f2", fechaf)
					.getResultList();
				return lsthor;			
		}
		catch (Exception ex){
			return null;
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String eliminarAntiguos(Date fechaTope) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rhorarios rho where rho.fechaf <:ftope")
			.setParameter("ftope", fechaTope)
			.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


}
