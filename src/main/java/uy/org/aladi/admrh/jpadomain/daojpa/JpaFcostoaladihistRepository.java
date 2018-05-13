package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Fcostoaladihist;
import uy.org.aladi.admrh.jpadomain.repository.FcostoaladihistRepository;

@Repository("fcostoaladihistRepository")
public class JpaFcostoaladihistRepository extends JpaRepository<Fcostoaladihist, Long> implements FcostoaladihistRepository{


	private static final long serialVersionUID = 1216941432307383299L;

	public JpaFcostoaladihistRepository(){
		super(Fcostoaladihist.class);
	}
	

	@Transactional(readOnly=false)
	public Boolean insertFromAnual(){
		Boolean ret;	
		try{
			entityManager.createQuery("insert into Fcostoaladihist (mesAnio, idGplanta, " +
					"tarjeta, nombre, basico, aguinaldo, antiguedad, aporte, cargas, " +
					"compensa, excAtFliar, hextras, representacion, segAccidT, segSalud, " +
					"segVida, vivienda, otrosMas, otrosMenos, total)" +
					"select ca.mesAnio, ca.gplanta.idGplanta, ca.tarjeta, ca.nombre, " +
					"ca.basico, ca.aguinaldo, ca.antiguedad, ca.aporte, ca.cargas, ca.compensa, " +
					"ca.excAtFliar, ca.hextras, ca.representacion, ca.segAccidT, ca.segSalud, " +
					"ca.segVida, ca.vivienda, ca.otrosMas, ca.otrosMenos, ca.total from " +
					"Fcostoaladianual ca").executeUpdate();
			ret = true;
		}
		catch(Exception ex){
			ret = false;
		}
		return ret;
	}
	

	@Override
	@Transactional(readOnly=false)
	public Boolean insertFromAnualByFuncionario(Short tarjeta) {
		Boolean ret;		
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Fcostoaladihist (mesAnio, idGplanta, " +
					"tarjeta, nombre, basico, aguinaldo, antiguedad, aporte, cargas, " +
					"compensa, excAtFliar, hextras, representacion, segAccidT, segSalud, " +
					"segVida, vivienda, otrosMas, otrosMenos, total)" +
					"select ca.mesAnio, ca.gplanta.idGplanta, ca.tarjeta, ca.nombre, " +
					"ca.basico, ca.aguinaldo, ca.antiguedad, ca.aporte, ca.cargas, " +
					"ca.compensa, ca.excAtFliar, ca.hextras, ca.representacion, ca.segAccidT, " +
					"ca.segSalud, ca.segVida, ca.vivienda, ca.otrosMas, ca.otrosMenos, ca.total from " +
					"Fcostoaladianual ca where ca.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.executeUpdate();
			ret = true;
		}
		catch(Exception ex){
			ret = false;
		}
		return ret;
	}

	@Override
	@Transactional(readOnly=false)
	public Boolean insertFromEgresoByFuncionario(Short tarjeta) {
		Boolean ret;		
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("insert into Fcostoaladihist (mesAnio, idGplanta, " +
					"tarjeta, nombre, basico, aguinaldo, antiguedad, aporte, cargas, " +
					"compensa, excAtFliar, hextras, representacion, segAccidT, segSalud, " +
					"segVida, vivienda, otrosMas, otrosMenos, total)" +
					"select ca.mesAnio, ca.idGplanta, ca.tarjeta, ca.nombre, " +
					"ca.basico, ca.aguinaldo, ca.antiguedad, ca.aporte, ca.cargas, ca.compensa, " +
					"ca.excAtFliar, ca.hextras, ca.representacion, ca.segAccidT, ca.segSalud, " +
					"ca.segVida, ca.vivienda, ca.otrosMas, ca.otrosMenos, ca.total from " +
					"Fcostoaladiegresos ca where ca.tarjeta =:tar")
					.setParameter("tar", tarjeta)
					.executeUpdate();
			ret = true;
		}
		catch(Exception ex){
			ret = false;
		}
		return ret;
	}


	@Override
	public Boolean insertByAnioMes(String anioMes) {
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Fcostoaladihist> selectByAnioMes(String anioMes) {
		return entityManager.createQuery("from Fcostoaladihist fch where fch.mesAnio =:ma")
				.setParameter("ma", anioMes)
				.getResultList();
	}


}
