package uy.org.aladi.admrh.jpadomain.daojpa;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Usuario;
import uy.org.aladi.admrh.jpadomain.repository.UsuarioRepository;

@Repository("usuarioRepository")
public class JpaUsuarioRepository extends JpaRepository<Usuario, Long> implements UsuarioRepository {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -932772709222128023L;

	public JpaUsuarioRepository() {
		super(Usuario.class);
	}

	public Usuario getByUserName(String userName) {
		try{
			Usuario user = (Usuario)entityManager.createQuery("from Usuario u where u.username =:user")
					.setParameter("user", userName)
					.getSingleResult();
			return user;
			
		}
		catch(Exception ex){
			return null;
		}
	}

	@Override
	public Usuario getByidGplanta(Long idgplanta) {
		try{
			Usuario user = (Usuario)entityManager.createQuery("from Usuario u where u.idGplanta =:idgp")
					.setParameter("idgp", idgplanta)
					.getSingleResult();
			return user;
			
		}
		catch(Exception ex){
			return null;
		}
	}

}
