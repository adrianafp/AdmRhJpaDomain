package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rol;

public interface RolRepository extends Repository<Rol, Long> {

	List<Rol> getByUser(Long idUsuario);
	Rol getByDescPublic(String desc);
	Rol getByDesc(String desc);
	
}
