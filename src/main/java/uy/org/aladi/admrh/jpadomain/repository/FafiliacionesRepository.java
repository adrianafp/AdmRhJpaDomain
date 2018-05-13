package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fafiliaciones;
import uy.org.aladi.admrh.jpadomain.entities.Fmutualistasplanes;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;

public interface FafiliacionesRepository extends Repository<Fafiliaciones, Long>{

	List<Fafiliaciones> getByFuncionario(Gplanta func);
	List<Fafiliaciones> getByMutualistaPlan(Fmutualistasplanes plan);

}
