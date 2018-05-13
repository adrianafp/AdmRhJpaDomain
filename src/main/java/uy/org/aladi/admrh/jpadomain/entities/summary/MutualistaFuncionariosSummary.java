package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class MutualistaFuncionariosSummary implements Serializable {

	private static final long serialVersionUID = -5691437143155107888L;
	private String mutualista;
	private BigDecimal totMutualista;
	private List<FuncAfiliaSummary> lstFuncionarios;
		
	public MutualistaFuncionariosSummary(){
		
	}

	public String getMutualista() {
		return mutualista;
	}

	public void setMutualista(String mutualista) {
		this.mutualista = mutualista;
	}

	public List<FuncAfiliaSummary> getLstFuncionarios() {
		return lstFuncionarios;
	}

	public void setLstFuncionarios(List<FuncAfiliaSummary> lstFuncionarios) {
		this.lstFuncionarios = lstFuncionarios;
	}

	public BigDecimal getTotMutualista() {
		return totMutualista;
	}

	public void setTotMutualista(BigDecimal totMutualista) {
		this.totMutualista = totMutualista;
	}
	
	
}
