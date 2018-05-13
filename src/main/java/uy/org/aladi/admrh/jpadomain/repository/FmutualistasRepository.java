package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fmutualistas;
import uy.org.aladi.admrh.jpadomain.entities.Fmutualistasplanes;

public interface FmutualistasRepository extends Repository<Fmutualistas, Integer>{

	List<Fmutualistasplanes> getPlanesByMutualista(Fmutualistas mutual);
}
