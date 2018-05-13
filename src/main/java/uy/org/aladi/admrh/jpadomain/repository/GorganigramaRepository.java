package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Gorganigrama;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;

public interface GorganigramaRepository extends Repository<Gorganigrama, Short>{

	List<Gplanta> getByDepto(Short id);
	List<Gplanta> getLosQueMarcanByDepto(Short id);
}
