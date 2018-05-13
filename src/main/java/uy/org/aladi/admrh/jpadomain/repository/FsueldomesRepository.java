package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fsueldomes;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;

public interface FsueldomesRepository extends Repository<Fsueldomes, Long> {
	List<Fsueldomes> getByFunc(Gplanta func);
	Fsueldomes getByFuncyAnioMes(Gplanta func, String aniomes);
}
