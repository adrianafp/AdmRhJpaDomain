package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.FbancosModocobro;

public interface FbancosModoCobroRepository extends Repository<FbancosModocobro, Integer>{

	List<FbancosModocobro> getBancos();
	FbancosModocobro findByName(String name);
}
