package uy.org.aladi.admrh.jpadomain.daojpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Rol;
import uy.org.aladi.admrh.jpadomain.repository.RolRepository;
import uy.org.aladi.admrh.jpadomain.repository.UsuarioRolRepository;

@Repository("rolRepository")
public class JpaRolRepository extends JpaRepository<Rol, Long> implements RolRepository{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5815170276463195343L;

	@Autowired
	UsuarioRolRepository usuarioRolRepository;
	
	public JpaRolRepository() {
		super(Rol.class);
	}

	public List<Rol> getByUser(Long idUsuario) {
		
		List<Rol> lst = usuarioRolRepository.getIdRoles(idUsuario); 
						
		return lst;
	}

	@Override
	public Rol getByDescPublic(String desc) {
		return (Rol)entityManager.createQuery("from Rol r where r.descPublic =:desc")
				.setParameter("desc", desc)
				.getSingleResult();
	}

	@Override
	public Rol getByDesc(String desc) {
		return (Rol)entityManager.createQuery("from Rol r where r.descripcion =:desc")
				.setParameter("desc", desc)
				.getSingleResult();
	}

}
