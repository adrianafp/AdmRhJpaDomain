package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fparamfuncionario;
import uy.org.aladi.admrh.jpadomain.entities.summary.ParametrosFuncionarioSummary;

public interface FparamfuncionarioRepository extends Repository<Fparamfuncionario, Long>{

	List<Fparamfuncionario> getLstByTarjeta(Short tarjeta);
	List<ParametrosFuncionarioSummary> getLstSummaryByTarjeta(Short tarjeta);
	Fparamfuncionario getByTarjeta_Idpar(Short tarjeta, Long idpar);
}
