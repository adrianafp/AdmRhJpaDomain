package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fafaladiprestamos;
import uy.org.aladi.admrh.jpadomain.entities.Fafaladiprstevolucion;

public interface FafaladiprstevolucionRepository extends Repository<Fafaladiprstevolucion, Integer> {

	List<Fafaladiprstevolucion> getByPrst(Fafaladiprestamos prst);
}
