package uy.org.aladi.admrh.jpadomain.repository.criteria;

public class GplantaSearchCriteria extends RangeCriteria{

	private Short tarjeta;
	private String fechaEgreso;

	public Short getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(String fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	
}
