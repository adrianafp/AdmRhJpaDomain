package uy.org.aladi.admrh.jpadomain.daojpa;

import org.springframework.stereotype.Repository;

import uy.org.aladi.admrh.jpadomain.entities.Fprocedimientos;
import uy.org.aladi.admrh.jpadomain.repository.FprocedimientoRepository;

@Repository("procedimientoRepository")
public class JpaProcedimientoRepository  extends JpaRepository<Fprocedimientos, Integer> implements FprocedimientoRepository {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5206398919560692357L;

	public JpaProcedimientoRepository() {
		super(Fprocedimientos.class);
	}

}
