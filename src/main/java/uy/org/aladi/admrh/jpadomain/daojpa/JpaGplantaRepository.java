package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fmutualistasplanes;
import uy.org.aladi.admrh.jpadomain.entities.Ggrados;
import uy.org.aladi.admrh.jpadomain.entities.Gparametros;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.repository.GplantaRepository;
import uy.org.aladi.admrh.jpadomain.repository.criteria.GplantaSearchCriteria;

@Repository("gplantaRepository")
public class JpaGplantaRepository extends JpaRepository<Gplanta, Long> implements GplantaRepository, Serializable{

	private static final long serialVersionUID = -6387107505436349066L;

	public JpaGplantaRepository(){
		super(Gplanta.class);
	}

	public Gplanta getById(Long id) {
		Gplanta func = null;
		if(id != null){
			func = (Gplanta)entityManager.find(Gplanta.class, id);
		}
		return func;
	}

	public Gplanta getByTarjeta(Short tarjeta) {
		Gplanta func = null;
		try{
			func = (Gplanta)entityManager.createQuery("from Gplanta g where g.tarjeta =:nro")
					.setParameter("nro", tarjeta).getSingleResult();
			return func;
			
		}
		catch(NoResultException nex){
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Gplanta> getByCriteria(GplantaSearchCriteria criteria){
		List<Gplanta> lst = null;
		String fegreso = criteria.getFechaEgreso();
		String q = null;
		if(fegreso == null){
			q = "Select p from " + Gplanta.class.getSimpleName() + " p where p.egreso is null order by p.tarjeta";			
			lst = entityManager.createQuery(q).getResultList();
		}
		else{
			q = "Select p from " + Gplanta.class.getSimpleName() + " p where p.egreso =:egre order by p.tarjeta";			
			lst = entityManager.createQuery(q).setParameter("egre", fegreso).getResultList();
		}
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Gplanta> getByMutualistaPlan(Fmutualistasplanes plan) {
		try{
			List<Gplanta> lst = entityManager.createQuery("from Gplanta g where " +
					"g.fmutualistasplanes.idFmutualistasPlanes =:id")
					.setParameter("id", plan.getIdFmutualistasPlanes())
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getByBanco(Integer idBco) {
		try{
			List<Gplanta> lst = entityManager.createQuery("from Gplanta g where " +
					"g.fbancosModocobro.idBcoMdoCobro =:id")
					.setParameter("id", idBco)
					.getResultList();
			return lst;
		}
		catch(NoResultException nex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Gplanta> getUltimosIngresos() {
		Boolean ui = true;
		List<Gplanta> lst = entityManager.createQuery("from Gplanta gp where gp.ultimoIngreso =:ulti " +
				"order by gp.tarjeta")
				.setParameter("ulti", ui)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Gplanta> getCambiosAntiguedad() {
		Gparametros gparam = (Gparametros)entityManager.createQuery("from Gparametros g where " +
				"g.gcodigo = 1").getSingleResult();
		Integer mesliq = Integer.valueOf(gparam.getSvalor().substring(4));
		List<Gplanta> lst = entityManager.createQuery("from Gplanta gp where MONTH(gp.ingreso) =:mes")
				.setParameter("mes", mesliq)
				.getResultList();
		
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Short> getTarjetasEgresos(){
		Boolean egresoFin = true;
		List<Gplanta> lst = entityManager.createQuery("from Gplanta gp where gp.egreso <> null and gp.egresoFinanzas =:egresoFin")
				.setParameter("egresoFin", egresoFin)
				.getResultList();
		List<Short> lstTarjetas = new ArrayList<Short>();
		Short tarjeta;
		for(Gplanta f:lst){
			tarjeta = f.getTarjeta();
			lstTarjetas.add(tarjeta);
		}
		return lstTarjetas;
	}
	
	@SuppressWarnings("unchecked")
	public List<Short> getTarjetasIngresos(Date fecha)
	{
		List<Gplanta> lst = entityManager.createQuery("from Gplanta gp where gp.ingreso >:fecha")
				.setParameter("fecha", fecha)
				.getResultList();
		List<Short>lstTarjetas = new ArrayList<Short>();
		Short tarjeta;
		for(Gplanta f:lst){
			tarjeta = f.getTarjeta();
			lstTarjetas.add(tarjeta);
		}
		return lstTarjetas;
	}

	@SuppressWarnings("unchecked")
	public List<Gplanta> getFuncsNotInGroup(String tarjetas) {
		List<Gplanta> lstgrupo = new ArrayList<Gplanta>();
		if(tarjetas.equals("")){
			lstgrupo = entityManager.createQuery("from Gplanta gp where gp.egreso is null order by gp.tarjeta").getResultList();
		}
		else{
			lstgrupo = entityManager.createQuery("from Gplanta gp where " +
				"gp.tarjeta NOT IN (" + tarjetas + ") order by gp.tarjeta").getResultList();
		}
		return lstgrupo;
	}

	public BigDecimal getBasico(Short tarjeta) {
				
		Ggrados grado = (Ggrados)entityManager.createQuery("select ggrados from Gplanta gp where gp.tarjeta =:tar")
				.setParameter("tar", tarjeta)
				.getSingleResult();
		
		return grado.getBasico();
	}

	public BigDecimal getCambioBasico(Short tarjeta, String mesLiquidacion) {
		BigDecimal sueldoMes = BigDecimal.ZERO;
		try{
			sueldoMes = (BigDecimal)entityManager.createQuery("select fsm.sueldomes from Fsueldomes fsm " +
					"where fsm.tarjeta =:tar and fsm.anioMes =:am")
					.setParameter("tar", tarjeta)
					.setParameter("am", mesLiquidacion)
					.getSingleResult();
			return sueldoMes;			
		}
		catch(NoResultException nex){
			return sueldoMes;
		}
	}

	public BigDecimal getComplementoBasico(Long idFunc) {
		BigDecimal complemento = BigDecimal.ZERO;
		try{
			complemento = (BigDecimal)entityManager.createQuery("Select fcb.importeComplemento from Fcomplementobasico fcb where " +
					"fcb.idGplanta =:id")
					.setParameter("id", idFunc)
					.getSingleResult();
			return complemento;			
		}
		catch(NoResultException nex){
			return complemento;
		}
	}

	@Override
	public String getNombre(Short tarjeta) {
		try{
			return (String)entityManager.createQuery("select gp.nombre from Gplanta gp where gp.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.getSingleResult();
		}
		catch(Exception ex){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getLosQueMarcan() {
		
		Boolean marca = true;
		List<Gplanta> lst = entityManager.createQuery("from Gplanta gp where gp.marcas =:marca and gp.egreso is null")
				.setParameter("marca", marca)
				.getResultList();
		return lst;
	}

	@Override
	public Short getTarjetaMenor() {
		Short tmenor = (Short)entityManager.createQuery("select Min(gp.tarjeta) from Gplanta gp")
				.getSingleResult();
		return tmenor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getLosQueNoMarcan() {
		Boolean marca = false;
		List<Gplanta> lst = entityManager.createQuery("from Gplanta gp where gp.marcas =:marca and gp.egreso is null")
				.setParameter("marca", marca)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getOrdenByCategoria() {
		return entityManager.createQuery("from Gplanta gp order by gp.gcategorias.idGCatetoria, gp.tarjeta")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getOrdenByDepto() {
		return entityManager.createQuery("from Gplanta gp order by gp.gorganigrama.idGOrganigrama, gp.tarjeta")
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getLosQueMarcanByDepto() {
		Boolean marca = true;
		List<Gplanta> lst = entityManager.createQuery("from Gplanta gp where gp.marcas =:marca and gp.egreso is null " +
				"order by gp.gorganigrama.idGOrganigrama, gp.tarjeta")
				.setParameter("marca", marca)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getTodosByTarjeta() {
		return entityManager.createQuery("from Gplanta gp where gp.egreso is null order by gp.tarjeta").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Gplanta> getConEgresos() {
		List<Gplanta> lst = entityManager.createQuery("from Gplanta gp order by gp.tarjeta")
				.getResultList();
		return lst;
	}

}
