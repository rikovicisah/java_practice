package practice.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int[] niz = {5,73,7,6,23,7,2,8,23,10};

		Arrays.sort(niz);
		for(int b : niz)
			System.out.print( b + ",");
		
		//---------------------------------------------
		//Kolekcija
		System.out.printf("\n Kolekcija \n");
		
		List lista = Arrays.asList(1,2,3,4);
		
		lista.stream()
		.forEach(System.out::print);
		
		System.out.printf("\n Iterator \n");
		Iterator<Integer> it = lista.iterator();
		while(it.hasNext()) { System.out.println(it.next()); }
		
		System.out.printf("\n List Iterator \n");
		ListIterator<Integer> litlista = lista.listIterator(lista.size());
		while(litlista.hasPrevious()) {
			System.out.print(litlista.previous() + ", ");
		}
		
		//Mape
		System.out.printf("\n Mapa \n");
		HashMap<Integer, Integer> mapa = new HashMap<>();
		mapa.put(1, 100);
		mapa.put(2, 300);
		mapa.put(3, 400);
		mapa.put(4, 600);
		
		Iterator<Entry<Integer, Integer>> lit = mapa.entrySet().iterator();
		
		while(lit.hasNext()) {
			Entry<Integer, Integer> en = lit.next();
			System.out.println("Key : " + en.getKey() + " Value : " + en.getValue());
		}
		//------------------------------------------------
		
		System.out.printf("\n Big Decimal \n");
		
		double a = 0.02, b = 0.03;
		double c = b - a;
		System.out.println("Double razlika : " + c);
		
		BigDecimal _a = new BigDecimal("0.02");
		BigDecimal _b = new BigDecimal("0.03");
		BigDecimal _c = _b.subtract(_a);
		System.out.println("BigDecimal razlika : " + _c);
		
		//------------------------------------------------
		System.out.printf("\n Exception  \n");
		
		try {
			Scanner unos = new Scanner(System.in);
			System.out.println("Unesite broj");
			int broj = 0;
			
			broj = unos.nextInt();
			if(broj > 100) throw new Greska();
			else System.out.println("Uneseni broj je : " + broj);
			
		}catch (Greska e) {
			System.out.println(e.toStringD("Unesen je veci broj"));
		}finally {
			
		}
		
		//------------------------------------------------
		System.out.printf("\n Datum i vrijeme  \n");
		
		LocalDate date = LocalDate.parse(LocalDate.now().toString());
		System.out.println("Datum : " + date);
		
		DateTimeFormatter dateTimeFormatterIspisa = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Formatiran datum " + dateTimeFormatterIspisa.format(date));
		
		//------------------------------------------------
		System.out.printf("\n Decimal Format  \n");
		
		DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
		double brojD = 4590834095.30845;
		System.out.println("Vrijednost : " + decimalFormat.format(brojD));
		
		//------------------------------------------------
		System.out.printf("\n  Character stream  \n");
		
		try(FileWriter fw = new FileWriter("text.txt");
				FileReader fr = new FileReader("text.txt");){
			
			fw.write("TEKDJS");
			fw.flush();
			fw.close();
			
			int cr = 0;
			while((cr = fr.read()) != -1) {
				System.out.print((char)cr);
			}
			
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//------------------------------------------------
		System.out.printf("\n  Byte stream  \n");
		
		try(FileOutputStream fos = new FileOutputStream("text2.txt");
				FileInputStream fis = new FileInputStream("text2.txt");){
			
			fos.write("Tekst".getBytes());
			fos.flush();
			fos.close();
			
			int cB = 0;
			while((cB = fis.read()) != -1) {
				System.out.print((char)cB);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//------------------------------------------------
		System.out.printf("\n  Object stream  \n");
		Users user = new Users();
		Users user2 = new Users();
		user.setIme("Mustafa");
		user.setGodine(20);
		
		try(ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream("useri.txt"));
				ObjectInputStream dis = new ObjectInputStream(new FileInputStream("useri.txt"))){
			
			dos.writeObject(user);
			dos.flush();
			dos.close();
			
			user2 = (Users) dis.readObject();
			System.out.println("Ime je : " + user2.getIme() + " godine : " + user2.getGodine());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//------------------------------------------------
	    System.out.printf("\n  Lambda  \n");
		
	    Function<Integer, Integer> func = broj -> { return broj * broj; };
		System.out.println("Rezultat je : "  + func.apply(4));
		
		//------------------------------------------------
	    System.out.printf("\n  Files  \n");
	    
	    try {
	    	FileWriter fw2 = new FileWriter("ispis.txt");
	    	Path path = Paths.get("ispis.txt");
	    	List<Integer> tekst = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	    	
	    	for(Integer bdd : tekst) fw2.write(bdd + "\n");
	    	fw2.close();
	    	
			List<String> listad = Files.readAllLines(path);
			
			for (String rijec : listad) {
				System.out.println(rijec + ", ");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
		
	}
}
