package uy.org.aladi.admrh.jpadomain.daojpa;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fadicionesdescf;
import uy.org.aladi.admrh.jpadomain.exceptions.FadicionesdescfException;
import uy.org.aladi.admrh.jpadomain.repository.FadicionesdescfRepository;

@Repository("fadicionesdescfRepository")
public class JpaFadicionesdescfRepository extends JpaRepository<Fadicionesdescf, Long> implements FadicionesdescfRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6162525824842700305L;

	public JpaFadicionesdescfRepository() {
		super(Fadicionesdescf.class);
	}

	public Fadicionesdescf aporteFunc(Short tarjeta) {
		if(tarjeta == null){
			return null;			
		}
		Short cod = Short.valueOf("69");
		Fadicionesdescf adic = (Fadicionesdescf)entityManager.createQuery("from Fadicionesdescf ad " +
				"where ad.tarjeta=:tar and ad.fcodigos.idFcodigos =:cod")
				.setParameter("tar", tarjeta)
				.setParameter("cod", cod)
				.getSingleResult();
		return adic;
	}

	@Transactional(readOnly=false)
	public void deleteByFuncImporte(Short tarjeta, BigDecimal importe) throws FadicionesdescfException {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fadicionesdescf fad where fad.tarjeta =:id " +
					"and fad.importe =:importe")
					.setParameter("id", tarjeta)
					.setParameter("importe", importe)
					.executeUpdate();
		}
		catch(Exception ex){
			throw new FadicionesdescfException("No fue posible eliminar el registro correspondiente en la tabla de Adiciones y descuentos del fondo");
		}
	}

	@Transactional(readOnly = false)
	public void actualizacionPorCierredeCta(Short tarjeta) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("update Fadicionesdescf fad set fad.registro = 1 where fad.tarjeta =:tar")
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
	public List<Fadicionesdescf> getByFuncionario(Short tarjeta) {
		return entityManager.createQuery("from Fadicionesdescf adf where adf.tarjeta =:tar")
				.setParameter("tar", tarjeta)
				.getResultList();
	}

	@Override
	@Transactional(readOnly=false)
	public String eliminarTodos() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fadicionesdescf adf ").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@Override
	public String limpiarMesAnterior(String mesLiq) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Fadicionesdescf adf where " +
			"adf.mesLiquidacion <> :mesL")
			.setParameter("mesL", mesLiq)
			.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Fadicionesdescf> getTodas() {
		return entityManager.createQuery("from Fadicionesdescf adf order by adf.tarjeta, " +
				"adf.sumaResta, adf.fcodigos.idFcodigos")
				.getResultList();
	}


}
