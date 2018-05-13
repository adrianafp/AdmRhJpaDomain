package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class LiquidacionSummary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3887424049159996073L;
	private String column1;
	private String column2;
	private String column4;
	private BigDecimal column6;
	private BigDecimal column8;
	
	public LiquidacionSummary(){
		
	}
	
	public LiquidacionSummary(String titulo1, String titulo2, String titulo3, BigDecimal importe,
				BigDecimal total){
		this.column1 = titulo1;
		this.column2 = titulo2;
		this.column4 = titulo3;
		this.column6 = importe;
		this.column8 = total;
	}
	
	public String getColumn1() {
		return column1;
	}
	public void setColumn1(String column1) {
		this.column1 = column1;
	}
	public String getColumn2() {
		return column2;
	}
	public void setColumn2(String column2) {
		this.column2 = column2;
	}
	public String getColumn4() {
		return column4;
	}
	public void setColumn4(String column4) {
		this.column4 = column4;
	}
	public BigDecimal getColumn6() {
		return column6;
	}
	public void setColumn6(BigDecimal column6) {
		this.column6 = column6;
	}
	public BigDecimal getColumn8() {
		return column8;
	}
	public void setColumn8(BigDecimal column8) {
		this.column8 = column8;
	}
	

}
