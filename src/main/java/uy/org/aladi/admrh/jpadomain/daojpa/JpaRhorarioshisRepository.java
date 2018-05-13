package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rhorarioshis;
import uy.org.aladi.admrh.jpadomain.repository.RhorarioshisRepository;

@Repository("rhorarioshisRepository")
public class JpaRhorarioshisRepository extends JpaRepository<Rhorarioshis, Long> implements RhorarioshisRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRhorarioshisRepository(){
		super(Rhorarioshis.class);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rhorarioshis> getTodosOrdenados() {
		return entityManager.createQuery("from Rhorarioshis rhor order by rhor.fechac, rhor.tarjeta, rhor.nroDia")
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rhorarioshis> getByFuncionario(Short tarjeta) {
		try{
			List<Rhorarioshis> lst = entityManager.createQuery("from Rhorarioshis rhor where rhor.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.getResultList();
			
			return lst;
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rhorarioshis> getByFuncHEnfermedad(Short tarjeta,
			Date fechac, Date fechaf) {
		try{
			List<Rhorarioshis> lst = entityManager.createQuery("from Rhorarioshis rhor where rhor.tarjeta =:tar " +
					"and (rhor.fechac >= :f1 or rhor.fechaf <= :f2) and rhor.motivo like '%Enf. C/Certificado'")
					.setParameter("tar", tarjeta)
					.setParameter("f1", fechac)
					.setParameter("f2", fechaf)
					.getResultList();
			
			return lst;
		}
		catch(Exception ex){
			return null;
		}
	}


	@Transactional
	@Override
	public String agregarNuevos(Date fechaTope) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Rhorarioshis (dia, entradaM, " +
					"entradaT, fechac, fechaf, idGPlanta, motivo, nombre, " +
					"nroDia, salidaM, salidaT, tarjeta, tipoHorario) " + 
					"select hor.dia, hor.entradaM, hor.entradaT, hor.fechac, " +
					"hor.fechaf, hor.idGPlanta, hor.motivo, hor.nombre, " +
					"hor.nroDia, hor.salidaM, hor.salidaT, hor.tarjeta, hor.tipoHorario " +
					"from Rhorarios hor where hor.fechaf <:ftope")
					.setParameter("ftope", fechaTope)
					.executeUpdate();
			return "success";			
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	
}
