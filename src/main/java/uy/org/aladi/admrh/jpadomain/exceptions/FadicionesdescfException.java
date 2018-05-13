package uy.org.aladi.admrh.jpadomain.exceptions;

public class FadicionesdescfException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3011588705057554125L;
	private String msg;

	public FadicionesdescfException(String msg){
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
