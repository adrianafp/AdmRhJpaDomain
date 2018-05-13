package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class MutualistaPlanesSummary implements Serializable {

	private static final long serialVersionUID = -1413504480651514400L;
	private String mutualista;
	private String plan;
	private BigDecimal cuota;
	
	public MutualistaPlanesSummary(){
		
	}
	
	public MutualistaPlanesSummary(String mutualista, String plan, BigDecimal cuota){
		this.mutualista = mutualista;
		this.plan = plan;
		this.cuota = cuota;
	}
	
	public String getMutualista() {
		return mutualista;
	}
	public void setMutualista(String mutualista) {
		this.mutualista = mutualista;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public BigDecimal getCuota() {
		return cuota;
	}
	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}
	
}
