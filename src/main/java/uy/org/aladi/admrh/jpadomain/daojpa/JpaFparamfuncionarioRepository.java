package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fparamfuncionario;
import uy.org.aladi.admrh.jpadomain.entities.summary.ParametrosFuncionarioSummary;
import uy.org.aladi.admrh.jpadomain.repository.FparamfuncionarioRepository;

@Repository("fparamfuncionarioRepository")
public class JpaFparamfuncionarioRepository extends JpaRepository<Fparamfuncionario, Long> implements FparamfuncionarioRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5295612510457227876L;


	public JpaFparamfuncionarioRepository(){
		super(Fparamfuncionario.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Fparamfuncionario> getLstByTarjeta(Short tarjeta) {
		if(tarjeta == null){
			return null;
		}
		
		List<Fparamfuncionario>lst = new ArrayList<Fparamfuncionario>();
		try{
			lst = entityManager.createQuery("select pf from Fparamfuncionario pf where " +
					"pf.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ParametrosFuncionarioSummary> getLstSummaryByTarjeta(
			Short tarjeta) {
		if(tarjeta == null){
			return null;
		}
		
		List<Fparamfuncionario>lst = new ArrayList<Fparamfuncionario>();
		try{
			lst = entityManager.createQuery("select pf from Fparamfuncionario pf where " +
					"pf.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.getResultList();

			List<ParametrosFuncionarioSummary> lstSummary = new ArrayList<ParametrosFuncionarioSummary>();
			for(Fparamfuncionario fpf : lst){
				ParametrosFuncionarioSummary pfs = new ParametrosFuncionarioSummary();
				pfs.setIdFparamFuncionario(fpf.getIdFparamFuncionario());
				pfs.setIdFcodigos(fpf.getIdFcodigos());
				pfs.setIdFparametros(fpf.getFparametros().getIdFparametros());
				pfs.setDescripcion(fpf.getFparametros().getDescripcion());
				pfs.setSimbolo(fpf.getFparametros().getSimbolo());
				pfs.setValorParametro(fpf.getFparametros().getValorParametro());
				pfs.setTarjeta(fpf.getTarjeta());
				lstSummary.add(pfs);
			}
			return lstSummary;			
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	public Fparamfuncionario getByTarjeta_Idpar(Short tarjeta, Long idpar) {
		try{
			Fparamfuncionario parametro = (Fparamfuncionario) entityManager.createQuery("select pf from Fparamfuncionario pf where " +
					"pf.tarjeta =:tar and pf.idFparametros =:idpar")
					.setParameter("tar", tarjeta)
					.setParameter("idpar", idpar)
					.getSingleResult();
			return parametro;
		}
		catch(Exception ex){
			return null;
		}
		
	}

}
