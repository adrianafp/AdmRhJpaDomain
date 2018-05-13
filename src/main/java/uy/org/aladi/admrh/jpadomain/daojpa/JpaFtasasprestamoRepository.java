package uy.org.aladi.admrh.jpadomain.daojpa;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Ftasasprestamo;
import uy.org.aladi.admrh.jpadomain.repository.FtasasprestamoRepository;

@Repository("ftasasprestamoRepository")
public class JpaFtasasprestamoRepository extends JpaRepository<Ftasasprestamo, Integer> implements FtasasprestamoRepository {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7054163755630438922L;
	public JpaFtasasprestamoRepository() {
		super(Ftasasprestamo.class);
	}
	

}
