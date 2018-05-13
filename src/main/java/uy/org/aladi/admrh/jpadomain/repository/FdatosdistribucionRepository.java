package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Fdatosdistribintereses;

public interface FdatosdistribucionRepository extends Repository<Fdatosdistribintereses, Long> {

	Fdatosdistribintereses getPorMesDistrib(String mesDistrib);
	String getMesUltimaDistribucion();
}
