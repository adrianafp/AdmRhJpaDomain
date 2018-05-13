package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rausenteh;
import uy.org.aladi.admrh.jpadomain.repository.RausentehRepository;

@Repository("rausentehRepository")
public class JpaRausentehRepository extends JpaRepository<Rausenteh, Long> implements RausentehRepository{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1744910423715446514L;


	public JpaRausentehRepository(){
		super(Rausenteh.class);
	}


	@Transactional
	@Override
	public String agregarNuevos(Date fechaTope) {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("insert into Rausenteh (fechac, fechaf, " +
			"idGplanta, idRcodigos, motivo, tarjeta)" +
			"select rau.fechac, rau.fechaf, rau.idGplanta, rau.idRcodigos, " +
			"rau.motivo, rau.tarjeta from Rausentes rau where rau.fechaf <:ftope")
			.setParameter("ftope", fechaTope)
			.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}



	@Override
	public List<Rausenteh> getTodosOrdenados() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Rausenteh> getByFuncionario(Short tarjeta) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Rausenteh> getByFuncionarioyFechas(Short tarjeta, Date fechac,
			Date fechaf) {
		// TODO Auto-generated method stub
		return null;
	}



	@SuppressWarnings({"unchecked" })
	@Override
	public List<Rausenteh> getByFuncionarioCodigoyAnio(Short tarjeta,
			Short cod, Integer anio) {
		try{
			List<Rausenteh> lst = entityManager.createQuery("from Rausenteh raus where " +
					"raus.tarjeta =:tar and raus.idRcodigos =:cod and year(raus.fechaf) =:anio")
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
