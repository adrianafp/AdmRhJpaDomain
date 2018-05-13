package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uy.org.aladi.admrh.jpadomain.entities.Rol;
import uy.org.aladi.admrh.jpadomain.entities.Usuario;
import uy.org.aladi.admrh.jpadomain.entities.UsuarioRol;
import uy.org.aladi.admrh.jpadomain.repository.UsuarioRolRepository;

@Repository("usuarioRolRepository")
public class JpaUsuarioRolRepository extends JpaRepository<UsuarioRol, Long> implements UsuarioRolRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2441650122332841297L;
	
	public JpaUsuarioRolRepository() {
		super(UsuarioRol.class);
	}

	@SuppressWarnings("unchecked")
	public List<Rol> getIdRoles(Long idUsuario) {
		List<Rol> lst = entityManager.createQuery("select ur.rol from UsuarioRol ur where ur.usuario.idUsuario =:id")
				.setParameter("id", idUsuario)
				.getResultList();
		return lst;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getIdUsuarios(Long idRol) {
		List<Usuario> lst = entityManager.createQuery("select ur.usuario from UsuarioRol ur where ur.rol.idRol =:id")
				.setParameter("id", idRol)
				.getResultList();
		return lst;
	}

	@Override
	@Transactional(readOnly=false)
	public String deleteGrupo(String ids) {
		try{
			entityManager.joinTransaction();
			entityManager.createQuery("delete from UsuarioRol ur where ur.idusuarioRol IN (" + ids + ")").executeUpdate();
			return "success";
		}
		catch(Exception ex){
			return ex.getMessage();
		}
	}


}
