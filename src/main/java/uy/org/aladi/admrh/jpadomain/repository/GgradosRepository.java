package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Ggrados;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;

public interface GgradosRepository extends Repository<Ggrados, Short>{

	Ggrados getByFuncionario(Gplanta func);
	List<Ggrados> getAllOrdenados();
}
