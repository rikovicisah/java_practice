package practice.main;

public class Greska extends Exception{
	public Greska() {
		
	}
	
	public String toString() {
		return "Desila se greska";
	}
	
	public String toStringD(String tekst) {
		return tekst;
	}
}
