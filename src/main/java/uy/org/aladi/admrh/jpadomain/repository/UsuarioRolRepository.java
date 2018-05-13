package uy.org.aladi.admrh.jpadomain.repository;

import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rol;
import uy.org.aladi.admrh.jpadomain.entities.Usuario;
import uy.org.aladi.admrh.jpadomain.entities.UsuarioRol;

public interface UsuarioRolRepository extends Repository<UsuarioRol, Long> {

	List<Rol> getIdRoles(Long idUsuario);
	List<Usuario> getIdUsuarios(Long idRol);
	String deleteGrupo(String ids);
}
