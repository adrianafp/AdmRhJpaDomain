package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rcodigos;

public interface RcodigosRepository extends Repository<Rcodigos, Short> {

	List<Rcodigos> getCodigosDias();
	List<Rcodigos> getCodigosHoras();
	List<Rcodigos> getCodigosHorasSinCero();
	List<Rcodigos> getCodigosBoletas();
	List<Rcodigos> getCodigosLicencias();
	List<Rcodigos> getCodigosLicenciasUsuarios();
}
