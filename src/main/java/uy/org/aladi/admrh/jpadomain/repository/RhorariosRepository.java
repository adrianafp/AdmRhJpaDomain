package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rhorarios;

public interface RhorariosRepository extends Repository<Rhorarios, Long>{

	List<Rhorarios> getTodosOrdenados();
	List<Rhorarios> getByFuncionario(Short tarjeta);
	List<Rhorarios> getByFuncionarioFecha(Short tarjeta, Date fecha);
	Rhorarios getByFuncionarioFechaDia(Short tarjeta, Date fecha, String dia);
	Boolean horarioRepetidoFuncionario(Short tarjeta, Date fechac, Date fechaf);
	Boolean actualizacionSolapadaFuncionario(Short tarjeta, Long idhorario, Date fechac, Date fechaf);
	List<Rhorarios> getAnterioresPorFuncionario(Short tarjeta, Date fechaf);
	String eliminarGrupo(String ids);
	List<Rhorarios> getByFuncHEnfermedad(Short tarjeta, Date fechac, Date fechaf);
	List<Rhorarios> getActuales();
	String eliminarAntiguos(Date fechaTope);
}
