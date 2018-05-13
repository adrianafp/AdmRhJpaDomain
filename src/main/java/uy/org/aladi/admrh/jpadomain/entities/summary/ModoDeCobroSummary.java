package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ModoDeCobroSummary implements Serializable
{

	private static final long serialVersionUID = 3956756995681943847L;
	private String banco;
	private BigDecimal total;
	private List<FuncModoCobroSummary> lstFunc;
	
	public ModoDeCobroSummary(){
		
	}
	
	public ModoDeCobroSummary(String banco, BigDecimal total, List<FuncModoCobroSummary> lstFunc){
		this.banco = banco;
		this.total = total;
		this.setLstFunc(lstFunc);
	}
	
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}

	public List<FuncModoCobroSummary> getLstFunc() {
		return lstFunc;
	}

	public void setLstFunc(List<FuncModoCobroSummary> lstFunc) {
		this.lstFunc = lstFunc;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
}
