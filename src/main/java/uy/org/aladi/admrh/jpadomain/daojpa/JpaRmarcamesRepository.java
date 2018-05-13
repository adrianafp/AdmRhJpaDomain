package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rmarcames;
import uy.org.aladi.admrh.jpadomain.repository.RmarcamesRepository;

@Repository("rmarcamesRepository")
public class JpaRmarcamesRepository extends JpaRepository<Rmarcames, Integer> implements RmarcamesRepository, Serializable {

	private static final long serialVersionUID = 640853761630243688L;

	public JpaRmarcamesRepository() {
		super(Rmarcames.class);
	}


	@Override
	public Rmarcames getByTarjetayFechahora(Short tarjeta, Date fecha, Time hora) {
		try{
			Short idCod = Short.valueOf("0");
			Rmarcames rm = (Rmarcames)entityManager.createQuery("from Rmarcames rmm where rmm.tarjeta =:tar " +
					"and rmm.fecha1 =:f1 and rmm.hora1 =:h1 and rmm.rcodigos.idRcodigos =:cod")
					.setParameter("tar", tarjeta)
					.setParameter("f1", fecha)
					.setParameter("h1", hora)
					.setParameter("cod", idCod)
					.getSingleResult();
			return rm;
		}
		catch(Exception ex){
			return null;
		}
	}


	@Override
	public Rmarcames getByTarjetayMarcaImpar(Short tarjeta, Date fecha) {
		try{
			Rmarcames rm = (Rmarcames)entityManager.createQuery("from Rmarcames rmm where " +
					"rmm.tarjeta =:tar and rmm.fecha1 =:fecha1 and rmm.hora2 is null")
					.setParameter("tar", tarjeta)
					.setParameter("fecha1", fecha)
					.getSingleResult();
			return rm;
			
		}
		catch(NoResultException  nex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcames> getUltimasLeidas() {
		try{
			Boolean ulect = true;
			List<Rmarcames> lst = entityManager.createQuery("from Rmarcames rmm where rmm.ultlect =:ulec order by rmm.tarjeta, rmm.fecha1, rmm.hora1")
					.setParameter("ulec", ulect)
					.getResultList();
			return lst;
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Date> getDiasLeidos() {
		try{
			List<Date> fechas = entityManager.createQuery("select distinct rmm.fecha1 from Rmarcames rmm").getResultList();
			return fechas;
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Boolean tieneMarca(Short tarjeta, Date fecha) {

		try{
			List<Rmarcames> lstrm = entityManager.createQuery("from Rmarcames rmm where rmm.tarjeta =:tar " +
				"and rmm.fecha1 =:f1 ")
				.setParameter("tar", tarjeta)
				.setParameter("f1", fecha)
				.getResultList();
			if(lstrm.size() == 0){
				return false;
			}
			else{
				return true;				
			}
		}
		catch(NoResultException ex){
			return false;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcames> getMarcasImpares() {
		try{
			Boolean ulect = true;
			List<Rmarcames> lst = entityManager.createQuery("from Rmarcames rmm where rmm.ultlect =:ulec and " +
					"rmm.fecha2 is null")
					.setParameter("ulec", ulect)
					.getResultList();
			return lst;
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcames> getMarcasImparesSinUltimoDia(Date ultimodia) {
		try{
			List<Rmarcames> lst = entityManager.createQuery("from Rmarcames rmm where " +
					"rmm.fecha1 <:dia and rmm.fechaAnalisis is null and rmm.fecha2 is null")
					.setParameter("dia", ultimodia)
					.getResultList();
			return lst;
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcames> getUltLeidasByTarjeta(Short tarjeta) {
		try{
			Boolean ulect = true;
			List<Rmarcames> lst = entityManager.createQuery("from Rmarcames rmm where rmm.ultlect =:ulec " +
					"and rmm.tarjeta =:tar order by rmm.fecha1, rmm.hora1")
					.setParameter("ulec", ulect)
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
	public List<Rmarcames> getSinAnalizarByTarjeta(Short tarjeta) {
		try{
			List<Rmarcames> lst = entityManager.createQuery("from Rmarcames rmm where rmm.fechaAnalisis is null " +
					"and rmm.tarjeta =:tar order by rmm.fecha1, rmm.hora1")
					.setParameter("tar", tarjeta)
					.getResultList();
			return lst;
		}
		catch(Exception ex){
			return null;
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String limpiezaPreviaAnalisis() {
		try{
			Boolean ulect = true;
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rmarcames rmm where rmm.rcodigos.idRcodigos <> 0 and " +
			"rmm.rcodigos.idRcodigos <> 84 and rmm.ultlect =:ulec")
			.setParameter("ulec", ulect)
			.executeUpdate();
			entityManager.createQuery("update Rmarcames rmm set rmm.fechaAnalisis = null where " +
					"rmm.ultlect =:ulec")
					.setParameter("ulec", ulect)
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail";
		}
		
		
	}
	
	@Override
	@Transactional(readOnly=false)
	public Boolean limpiarUltimaLeida(Date fecha) {
		try{
			Boolean ultlect = false;
			java.sql.Date fec = new java.sql.Date(fecha.getTime());
			entityManager.joinTransaction();
			entityManager.createQuery("update Rmarcames rmm set rmm.ultlect =:ulec " +
					"where rmm.fecha1 <>:fecha")
				.setParameter("ulec", ultlect)
				.setParameter("fecha", fec)
				.executeUpdate();
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}

	@Override
	@Transactional(readOnly=false)
	public Boolean actualizarFechaAnalisis(Rmarcames registro) {
		try{
			java.sql.Date hoy = new java.sql.Date(new Date().getTime());
			Integer id = registro.getIdRmarcames();
			entityManager.joinTransaction();
			entityManager.createQuery("update Rmarcames rmm set rmm.fechaAnalisis =:hoy " +
					" where rmm.idRmarcames =:id")
					.setParameter("hoy", hoy)
					.setParameter("id", id)
					.executeUpdate();
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}


	@Override
	public Integer llegadasTarde(Short tarjeta) {
		
		try{
			Integer veces = 0;
			Short cod = Short.valueOf("11");
			Long lveces = (Long)entityManager.createQuery("select count(*) from Rmarcames rmm " +
			"where rmm.tarjeta =:tar and rmm.rcodigos.idRcodigos =:cod")
			.setParameter("tar", tarjeta)
			.setParameter("cod", cod)
			.getSingleResult();
			
			veces = lveces.intValue();
			return veces;
		}
		catch(NoResultException nex){
			return 0;
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcames> getUltLeidasByTarjetaFecha() {
		try{
			Boolean ulect = true;
			List<Rmarcames> lst = entityManager.createQuery("from Rmarcames rmm where rmm.ultlect =:ulec " +
					"order by rmm.tarjeta, rmm.fecha1, rmm.hora1")
					.setParameter("ulec", ulect)
					.getResultList();
			return lst;
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	public Date getPrimeraFecha() {
		try{
			Date fecha = (Date)entityManager.createQuery("select Min(rmm.fecha1) from Rmarcames rmm").getSingleResult();
			return fecha;
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	public Date getUltimoDiaLeido() {
		try{
			Date fecha = (Date)entityManager.createQuery("select Max(rmm.fecha1) from Rmarcames rmm").getSingleResult();
			return fecha;
		}
		catch(Exception ex){
			return null;
		}
	}


	@Override
	public Date getFechaSiguienteAlCierre(Date fechaCierre) {
		try{
			Date fecha = (Date)entityManager.createQuery("select Min(rmm.fecha1) from Rmarcames rmm " +
					"where rmm.fecha1 >:fc")
					.setParameter("fc", fechaCierre)
					.getSingleResult();
			return fecha;
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	@Transactional(readOnly=false)
	public String pasajeDeMarcasaTmp(Date fechaCierre) {
		try{
			Date fecha = (Date)entityManager.createQuery("select Min(rmm.fecha1) from Rmarcames rmm " +
					"where rmm.fecha1 >:fc")
					.setParameter("fc", fechaCierre)
					.getSingleResult();
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rmarcamestmp rmt").executeUpdate();
			entityManager.createNativeQuery("insert into Rmarcamestmp (idRmarcames, idGplanta, Tarjeta, " + 
					"Fecha1, Hora1, Fecha2, Hora2, idRCodigos, observ, Ultlect, FechaAnalisis) " +
					"select idRmarcames, idGplanta, Tarjeta, Fecha1, Hora1, Fecha2, Hora2, idRcodigos, observ, " +
					"Ultlect, FechaAnalisis from Rmarcames rm where rm.fecha1 >:fec")
					.setParameter("fec", fecha)
					.executeUpdate();
			
			entityManager.createQuery("delete from Rmarcames rm where rm.fecha1 >:fec ")
					.setParameter("fec", fecha)
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail" + ex.getMessage();
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String reponerDesdeTmp() {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("insert into Rmarcames (idGplanta, Tarjeta, " + 
					"Fecha1, Hora1, Fecha2, Hora2, idRCodigos, observ, Ultlect, FechaAnalisis) " +
					"select idGplanta, Tarjeta, Fecha1, Hora1, Fecha2, Hora2, idRcodigos, observ, " +
					"Ultlect, FechaAnalisis from Rmarcamestmp ")
					.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return "fail" + ex.getMessage();
		}
	
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Short> getTarjetasUltLeidas() {
		try{
			Boolean ulect = true;
			List<Short> tarjetas = entityManager.createQuery("select distinct rmm.tarjeta from " +
					"Rmarcames rmm where rmm.ultlect =:ulec")
					.setParameter("ulec", ulect)
					.getResultList();
			return tarjetas;
		}
		catch(Exception ex){
			return null;			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Short> getTarjetasSinAnalizar() {
		try{
			List<Short> tarjetas = entityManager.createQuery("select distinct rmm.tarjeta from " +
					"Rmarcames rmm where rmm.fechaAnalisis is null")
					.getResultList();
			return tarjetas;
		}
		catch(Exception ex){
			return null;			
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcames> getUltimasAnalizadas() {
		try{
			java.sql.Date fecha = (java.sql.Date)entityManager.createQuery("select Max(rmm.fechaAnalisis) " +
					"from Rmarcames rmm")
					.getSingleResult();
			return entityManager.createQuery("from Rmarcames rmm where rmm.fechaAnalisis =:fec " +
					"order by rmm.tarjeta, rmm.fecha1, rmm.hora1")
					.setParameter("fec", fecha)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcames> getTodasByTarjeta(Short tarjeta) {
		try{
			List<Rmarcames> lst = entityManager.createQuery("from Rmarcames rmm where " +
					"rmm.tarjeta =:tar order by rmm.fecha1, rmm.hora1")
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
	public List<Rmarcames> getByTarjetayCodigo(Short tarjeta, Short idcodigo) {
		try{
			Date ultimoDia = this.getUltimoDiaLeido();
			List<Rmarcames> lst = entityManager.createQuery("from Rmarcames rmm where " +
					"rmm.tarjeta =:tar and rmm.rcodigos.idRcodigos =:cod and rmm.fecha1 < :udia " + 
					"order by rmm.fecha1, rmm.hora1")
					.setParameter("tar", tarjeta)
					.setParameter("cod", idcodigo)
					.setParameter("udia", ultimoDia)
					.getResultList();
			return lst;
		}
		catch(Exception ex){
			return null;
		}
	}


	@Override
	@Transactional(readOnly=false)
	public Boolean eliminarPorFuncionarioCodigosyFecha(Short tarjeta,
			String codigos, Date fecha) {
		java.sql.Date fec = new java.sql.Date(fecha.getTime());
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rmarcames rm where rm.tarjeta =:tarj " +
					"and rm.rcodigos.idRcodigos IN (" + codigos +") and rm.fecha1 =:fec")
					.setParameter("tarj", tarjeta)
					.setParameter("fec", fec)
					.executeUpdate();
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}


	@Override
	@Transactional(readOnly=false)
	public Boolean eliminarPorFuncionarioCodigosyFechas(Short tarjeta,
			String codigos, String fechas) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rmarcames rm where rm.tarjeta =:tarj " +
					"and rm.rcodigos.idRcodigos IN (" + codigos +") and rm.fecha1 IN (" +
					fechas + ")")
					.setParameter("tarj", tarjeta)
					.executeUpdate();
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcames> getByTarjetayDia(Short tarjeta, Date fecha) {
		List<Rmarcames> lstrm = entityManager.createQuery("from Rmarcames rmm where rmm.tarjeta =:tar " +
				"and rmm.fecha1 =:f1 ")
				.setParameter("tar", tarjeta)
				.setParameter("f1", fecha)
				.getResultList();
		return lstrm;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Date> getDiasByTarjeta(Short tarjeta) {
		try{
			Date ultimoDia = this.getUltimoDiaLeido();
			List<Date> fechas = entityManager.createQuery("select distinct rmm.fecha1 from Rmarcames rmm " +
					"where rmm.tarjeta =:tarj and rmm.fecha1 <:udia")
					.setParameter("tarj", tarjeta)
					.setParameter("udia", ultimoDia)
					.getResultList();
			return fechas;
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcames> getByTarjetaExcesoAt(Short tarjeta) {
		try{
			Date ultimoDia = this.getUltimoDiaLeido();
			Short cod1 = Short.valueOf("12");
			Short cod2 = Short.valueOf("41");
			List<Rmarcames> lst = entityManager.createQuery("from Rmarcames rmm where " +
					"rmm.tarjeta =:tar and (rmm.rcodigos.idRcodigos =:cod1 or rmm.rcodigos.idRcodigos =:cod2) " + 
					" and rmm.fecha1 <> :udia order by rmm.fecha1, rmm.hora1")
					.setParameter("tar", tarjeta)
					.setParameter("cod1", cod1)
					.setParameter("cod2", cod2)
					.setParameter("udia", ultimoDia)
					.getResultList();
			return lst;
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	@Transactional
	public String eliminarElMes(Date fechaCierre) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rmarcames rmm where rmm.fecha1 <=:fcierre")
			.setParameter("fcierre", fechaCierre)
			.executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Rmarcames> getElMes(Date fechaCierre) {

		try{
			return entityManager.createQuery("from Rmarcames rmm where rmm.fecha1 <=:fcierre")
					.setParameter("fcierre", fechaCierre)
					.getResultList();
		}
		catch(Exception ex){
			return null;
		}
	}

	@Transactional
	@Override
	public String eliminarDeTmp() {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rmarcamestmp rmt").executeUpdate();
			return "success";			
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

}
