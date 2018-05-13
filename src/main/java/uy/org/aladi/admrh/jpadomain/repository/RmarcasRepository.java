package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rmarcas;

public interface RmarcasRepository extends Repository<Rmarcas, Long>{

	String importar(String filename);	
	List<String> getMarcasEntrada();
	String pasarAmarcas();
	List<Long> marcasRepetidas();
	String eliminarRepetidas(String ids);
	String pasarAmarcaTmp();
	String pasarAmarcOrig();
	String limpiar();

}
