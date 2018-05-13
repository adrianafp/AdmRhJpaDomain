package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Gcategorias;
import uy.org.aladi.admrh.jpadomain.entities.Gplanta;

public interface GcategoriasRepository extends Repository<Gcategorias, Integer>{

	Gcategorias getByFuncionario(Gplanta func);
}
