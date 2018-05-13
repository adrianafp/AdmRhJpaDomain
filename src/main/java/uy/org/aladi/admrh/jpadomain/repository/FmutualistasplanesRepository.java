package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fafiliaciones;
import uy.org.aladi.admrh.jpadomain.entities.Fmutualistas;
import uy.org.aladi.admrh.jpadomain.entities.Fmutualistasplanes;
import uy.org.aladi.admrh.jpadomain.entities.Gcargas;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;

public interface FmutualistasplanesRepository extends Repository<Fmutualistasplanes, Integer>{

	List<Fmutualistasplanes> getPlanesByMutualista(Fmutualistas mutual);
	List<Gplanta> getFuncByPlan(Fmutualistasplanes plan);
	List<Gcargas> getCargasByPlan(Fmutualistasplanes plan);
	List<Fafiliaciones> getAfilByPlan(Fmutualistasplanes plan);
}
