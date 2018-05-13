package uy.org.aladi.admrh.jpadomain.daojpa;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fcomplementobasico;
import uy.org.aladi.admrh.jpadomain.repository.FcomplementobasicoRepository;

@Repository("fcomplementobasicoRepository")
public class JpaFcomplementobasicoRepository extends JpaRepository<Fcomplementobasico, Integer> implements FcomplementobasicoRepository, Serializable{

	private static final long serialVersionUID = 7909608091815875483L;


	public JpaFcomplementobasicoRepository() {
		super(Fcomplementobasico.class);
	}

	@Override
	public Fcomplementobasico getByFunc(Long idGplanta) {
		try{
			return(Fcomplementobasico)entityManager.createQuery("from Fcomplementobasico fcb where fcb.idGplanta =:id" )
					.setParameter("id", idGplanta)
					.getSingleResult();
		}
		catch(Exception ex){
			return null;			
		}
	}

	
}
