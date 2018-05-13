package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Usuario;

public interface UsuarioRepository extends Repository<Usuario, Long>{

	Usuario getByUserName(String userName);
	Usuario getByidGplanta(Long idgplanta);
	
}
