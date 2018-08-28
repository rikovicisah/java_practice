package advanced.java;

import java.beans.MethodDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Advanced_Main {
	public static void main(String[] args) {

		//------------------------------
		System.out.println("Generic methods");
		Integer[] n = {1,2,3,4,5,6,7,8,9,10};
		ispis(n);
		
		//------------------------------
		System.out.println("Generic classes");
		
		List<Lubenica> listaLubenica = new ArrayList<>();
		List<Banana> listaBanana = new ArrayList<>();
		
		Lubenica l1 = new Lubenica();
		Lubenica l2 = new Lubenica();
		Lubenica l3 = new Lubenica();
		
		listaLubenica.add(l1);
		listaLubenica.add(l2);
		listaLubenica.add(l3);
		
		Banana b1 = new Banana();
		Banana b2 = new Banana();
		Banana b3 = new Banana();
		
		listaBanana.add(b1);
		listaBanana.add(b2);
		listaBanana.add(b3);
		
		System.out.println();
		
		ispisVoca(listaLubenica);
		ispisVoca(listaBanana);
		
		//------------------------------
		System.out.println("Reflection");
		
		try {
			Lubenica lubenica = new Lubenica();
			Class klasa = lubenica.getClass();
			
			Method[] metode = klasa.getDeclaredMethods();
			
			for(Method m : metode) {
				if(m.getParameterCount() == 0)
				m.invoke(lubenica);
				if(m.getParameterCount() == 1)
					m.invoke(lubenica, "Primjer teksta" );
				if(m.getParameterCount() == 2)
					System.out.println("Zbir je : " + m.invoke(lubenica, 2,3));
				
			}
			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//------------------------------
		System.out.println("Events");
		
		
		
		
	}
	
	
	public static <T> void ispis(T[] is) {
		for(T b : is) System.out.print(b + ", ");
	}
	
	public static void ispisVoca(List<? extends Voce> lista){
		for (Voce voce : lista) voce.ispis();
	}
}
