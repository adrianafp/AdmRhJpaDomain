package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fsolicitudprestamos;

public interface FsolicitudprestamosRepository extends Repository<Fsolicitudprestamos, Integer> {

	List<Fsolicitudprestamos> getByFunc(Long idFunc);
	Fsolicitudprestamos getUltimaByFunc(Long idFunc);
	List<Fsolicitudprestamos> getByCesion();
	List<Fsolicitudprestamos> getPrstsByTipo(Short tipo);
	void deletePorCierreCta(Short tarjeta);
	List<Fsolicitudprestamos> getOrdenadosByTarjeta();
	List<Fsolicitudprestamos> getEnviadasSinProcesar();
	List<Fsolicitudprestamos> getEnviadasAComisionSinProcesar();
	List<Fsolicitudprestamos> getEnviadasAFinanzasSinProcesar();
}
