package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fmutualistasplanes;
import uy.org.aladi.admrh.jpadomain.entities.Gcargas;
import uy.org.aladi.admrh.jpadomain.entities.Gmodcargas;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;

public interface GcargasRepository extends Repository<Gcargas, Integer>{

	List<Gcargas> getByFuncionario(Gplanta func);
	List<Gcargas> getByMutualistaPlan(Fmutualistasplanes plan);
	Gcargas getByFuncionarioyNombre(Long idFunc, String Nombre);
	List<Gcargas> getHijos();
	String deleteByIds(String ids);
	List<Gmodcargas> getModificaciones();
	List<Gmodcargas> getModifByFuncionario(Short tarjeta);
	
}
