package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rmarcas;
import uy.org.aladi.admrh.jpadomain.repository.RmarcasRepository;

@Repository("rmarcasRepository")
public class JpaRmarcasRepository extends JpaRepository<Rmarcas, Long> implements RmarcasRepository, Serializable {

	private static final long serialVersionUID = 640853761630243688L;

	public JpaRmarcasRepository() {
		super(Rmarcas.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMarcasEntrada() {
		List<String> lstEntrada = entityManager.createNativeQuery("select * from rmarcasentrada").getResultList();
		return lstEntrada;
	}

	@Transactional(readOnly=false)
	public String importar(String filename){
		try{
			entityManager.joinTransaction();
	//		entityManager.createNativeQuery("load data local infile '" + filename + "' into table rmarcastxt fields terminated by \' \'")
			entityManager.createNativeQuery("load data local infile '" + filename + "' into table rmarcasentrada LINES TERMINATED BY '\n'")
			.executeUpdate();			
			return "success";			
		}
		catch(Exception ex){
			return ex.getMessage();
		}

	}


	@Override
	@Transactional(readOnly=false)
	public String pasarAmarcas() {
		try{

			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rmarcas").executeUpdate();
			List<String> lstentrada = this.getMarcasEntrada();
			for(String reg : lstentrada){
				Rmarcas rm = new Rmarcas();
				rm.setCeros(reg.substring(0, 8));
				rm.setTarjeta(reg.substring(8, 12));
				rm.setFecha(reg.substring(12, 20));
				rm.setHora(reg.substring(20, 22));
				rm.setMinutos(reg.substring(22, 24));
				rm.setSegundos(reg.substring(24, 26));
				rm.setResto(reg.substring(26));
				this.save(rm);
			}

	//		entityManager.createNativeQuery("insert into Rmarcas (tarjeta, fecha, hora, minutos, segundos, resto) " +
	//		 "select tarjeta, fecha, hora, minutos, segundos, resto from Rmarcastxt").executeUpdate();		
	//		entityManager.createNativeQuery("delete from Rmarcastxt").executeUpdate();
			entityManager.createNativeQuery("delete from Rmarcasentrada").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Long> marcasRepetidas() {
		try{
			List<Long> lstRepetidas = entityManager.createNativeQuery("select distinct rm.idrmarcas from Rmarcas rm " +
					"inner join Rmarcatmp rmt on rm.tarjeta = rmt.tarjeta and rm.fecha = rmt.fecha " +
					"and rm.hora = rmt.hora").getResultList();
			return lstRepetidas;
		}
		catch(Exception ex){
			return null;			
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String eliminarRepetidas(String ids) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from Rmarcas rm where rm.idrmarcas IN (" +
					ids +")").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String pasarAmarcaTmp() {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("insert into Rmarcatmp (tarjeta, fecha, hora) " +
					"select tarjeta, fecha, hora from Rmarcas rm").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String pasarAmarcOrig() {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("insert into Rmarcorig (ceros, tarjeta, fecha, hora, minutos, segundos, resto) " +
			 "select ceros, tarjeta, fecha, hora, minutos, segundos, resto from Rmarcas").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


	@Override
	@Transactional(readOnly=false)
	public String limpiar() {
		try{
			entityManager.joinTransaction();
			entityManager.createNativeQuery("delete from Rmarcas").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}

}
