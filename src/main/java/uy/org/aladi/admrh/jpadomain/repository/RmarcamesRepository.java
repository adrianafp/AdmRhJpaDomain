package uy.org.aladi.admrh.jpadomain.repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import uy.org.aladi.admrh.jpadomain.entities.Rmarcames;


public interface RmarcamesRepository extends Repository<Rmarcames, Integer>{

	Rmarcames getByTarjetayFechahora(Short tarjeta, Date fecha, Time hora);
	Boolean tieneMarca(Short tarjeta, Date fecha);
	Rmarcames getByTarjetayMarcaImpar(Short tarjeta, Date fecha);
	List<Rmarcames> getUltimasLeidas();
	List<Date> getDiasLeidos();
	List<Rmarcames> getMarcasImpares();
	List<Rmarcames> getMarcasImparesSinUltimoDia(Date ultimodia);
	List<Rmarcames> getUltLeidasByTarjeta(Short tarjeta);
	List<Rmarcames> getSinAnalizarByTarjeta(Short tarjeta);
	List<Rmarcames> getTodasByTarjeta(Short tarjeta);
	String limpiezaPreviaAnalisis();
	Integer llegadasTarde(Short tarjeta);
	List<Rmarcames> getUltLeidasByTarjetaFecha();
	Date getPrimeraFecha();
	Date getUltimoDiaLeido();
	Date getFechaSiguienteAlCierre(Date fechaCierre);
	String pasajeDeMarcasaTmp(Date fechaCierre);
	String reponerDesdeTmp();
	List<Short> getTarjetasUltLeidas();
	List<Short> getTarjetasSinAnalizar();
	Boolean limpiarUltimaLeida(Date fecha);
	Boolean actualizarFechaAnalisis(Rmarcames registro);
	List<Rmarcames> getUltimasAnalizadas();
	List<Rmarcames> getByTarjetayCodigo(Short tarjeta, Short idcodigo);
	Boolean eliminarPorFuncionarioCodigosyFecha(Short tarjeta, String codigos, Date fecha);
	Boolean eliminarPorFuncionarioCodigosyFechas(Short tarjeta, String codigos, String fechas);
	List<Rmarcames> getByTarjetayDia(Short tarjeta, Date fecha);
	List<Date> getDiasByTarjeta(Short tarjeta);
	List<Rmarcames> getByTarjetaExcesoAt(Short tarjeta);
	List<Rmarcames> getElMes(Date fechaCierre);
	String eliminarElMes(Date fechaCierre);
	String eliminarDeTmp();
}
