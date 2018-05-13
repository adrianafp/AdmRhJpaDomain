package uy.org.aladi.admrh.jpadomain.repository;

import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Gplanta;
import uy.org.aladi.admrh.jpadomain.entities.Gvinculofuncionariocargo;

public interface GvinculofuncionariocargoRepository extends Repository<Gvinculofuncionariocargo, Long>{

	List<Gvinculofuncionariocargo> getByFuncionario(Gplanta func);
	List<Gvinculofuncionariocargo> getAllOrdenadosByFecha();
	List<Gvinculofuncionariocargo> getByVinculo(Short vinculo);
	Gvinculofuncionariocargo getUltimoByFuncionario(Gplanta func);
	List<Gvinculofuncionariocargo> getPosterioresA(Date fecha);
	List<Gplanta> getTodosEnProceso();
	List<Gvinculofuncionariocargo> getUltimosCambios();
}
