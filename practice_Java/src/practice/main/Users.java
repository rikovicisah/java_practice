package practice.main;

import java.io.Serializable;

public class Users implements Serializable{
	private String ime;
	private int godine;
	
	public Users() {
		
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getGodine() {
		return godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}
	
	
}
