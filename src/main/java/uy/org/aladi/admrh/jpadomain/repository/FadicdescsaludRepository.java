package uy.org.aladi.admrh.jpadomain.repository;

import java.math.BigDecimal;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Fadicionesdescsalud;

public interface FadicdescsaludRepository extends Repository<Fadicionesdescsalud, Integer>{
	String eliminarTodos();
	List<Short> getCodigosByMesLiquidacion(String mesLiquidacion);
	BigDecimal getSumaByCodigo(Short codigo, String mesLiquidacion);
	BigDecimal getSumaByCodigoyMutualista(Short codigo, Integer codMut, String mesLiquidacion);
	List<Fadicionesdescsalud> getByCodigoyMesLiquidacion(Short codigo, String mesLiquidacion);
}
