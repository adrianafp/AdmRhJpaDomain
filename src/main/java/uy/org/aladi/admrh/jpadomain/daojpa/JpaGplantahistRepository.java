package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Gplantahist;
import uy.org.aladi.admrh.jpadomain.repository.GplantahistRepository;

@Repository("gplantahistRepository")
public class JpaGplantahistRepository extends JpaRepository<Gplantahist, Long> implements GplantahistRepository, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4255001147168295770L;

	public JpaGplantahistRepository() {
		super(Gplantahist.class);
	}


	@Override
	public Gplantahist getByTarjeta(Short tarjeta) {
		try{
			Gplantahist fh = (Gplantahist)entityManager.createQuery("from Gplantahist gh where gh.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.getSingleResult();
			return fh;
		}
		catch(Exception ex){
			return null;
		}
	}


	@Override
	public String nombre(Short tarjeta) {
		try{
			return (String)entityManager.createQuery("select gph.nombre from Gplantahist gph where " +
					"gph.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.getSingleResult();
		}
		catch(Exception ex){
			return null;
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Short> getTarjetasEgresadosEnPeriodo(Date inicio, Date fin) {
		List<Short> lstTarjeta = new ArrayList<Short>();
		java.sql.Date fecinicio = new java.sql.Date(inicio.getTime());
		java.sql.Date fecfin = new java.sql.Date(fin.getTime());
		try{
			lstTarjeta = entityManager.createQuery("select distinct gph.tarjeta from Gplantahist gph " +
					"where gph.egreso >= :fecinicio and gph.egreso <= :fecfin")
					.setParameter("fecinicio", fecinicio)
					.setParameter("fecfin", fecfin)
					.getResultList();
			return lstTarjeta;
		}
		catch(Exception ex){
			return null;
		}
	}

}
