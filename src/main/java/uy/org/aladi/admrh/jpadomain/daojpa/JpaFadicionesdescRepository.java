package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fadicionesdesc;
import uy.org.aladi.admrh.jpadomain.repository.FadicionesdescRepository;

@Repository("fadicionesdescRepository")
public class JpaFadicionesdescRepository extends JpaRepository<Fadicionesdesc, Long> implements FadicionesdescRepository {

	private static final long serialVersionUID = 6162525824842700305L;

	public JpaFadicionesdescRepository() {
		super(Fadicionesdesc.class);
	}


	@Transactional(readOnly = false)
	public void actualizacionPorCierredeCta(Short tarjeta) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("update Fadicionesdesc fad set fad.registro = 1 where fad.tarjeta =:tar")
			.setParameter("tar", tarjeta)
			.executeUpdate();
			return;
		}
		catch(Exception ex){
			return;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fadicionesdesc> getConRegNulo(Short tarjeta) {
		return entityManager.createQuery("from Fadicionesdesc fad where fad.tarjeta =:tar " +
				"and fad.registro is null")
				.setParameter("tar", tarjeta)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Fadicionesdesc> getByFuncionario(Short tarjeta) {
		return entityManager.createQuery("from Fadicionesdesc fad where fad.tarjeta =:tar")
				.setParameter("tar", tarjeta)
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fadicionesdesc> getByFuncionarioyCodigo(Short tarjeta,
			Short codigo) {
		List<Fadicionesdesc> lstcod = new ArrayList<Fadicionesdesc>();
		lstcod = entityManager.createQuery("from Fadicionesdesc fad where fad.tarjeta =:tar " +
		"and fad.fcodigos.idFcodigos =:cod")
		.setParameter("tar", tarjeta)
		.setParameter("cod", codigo)
		.getResultList();
		return lstcod;
	}


	@Override
	@Transactional(readOnly=false)
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fadicionesdesc fad ").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fadicionesdesc> getSumas() {
		return entityManager.createQuery("from Fadicionesdesc fad where fad.sumaResta =:sr ")
				.setParameter("sr", Short.valueOf("1"))
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fadicionesdesc> getRestas() {
		return entityManager.createQuery("from Fadicionesdesc fad where fad.sumaResta =:sr ")
				.setParameter("sr", Short.valueOf("2"))
				.getResultList();
	}


	@Override
	@Transactional
	public String eliminarMesAnterior(String mesLiquidacion) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fadicionesdesc fad where fad.mesLiquidacion <:ames")
			.setParameter("ames", mesLiquidacion)
			.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@Override
	@Transactional
	public String eliminarByCodigo(Short idCod) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fadicionesdesc fad where fad.fcodigos.idFcodigos =:icod ")
			.setParameter("icod", idCod)
			.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fadicionesdesc> getTodas() {
		return entityManager.createQuery("from Fadicionesdesc fad order by fad.tarjeta, fad.sumaResta, " +
				"fad.fcodigos.idFcodigos")
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Short> getTarjetas() {
		return entityManager.createQuery("select distinct fad.tarjeta from Fadicionesdesc fad").getResultList();
	}

}
