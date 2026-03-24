package wind;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palabra one= new Palabra ("bueno");
		
		one.printoculto();
		System.out.println(one.LetraEnPalabra('a'));
		System.out.println(one.LetraEnUbicacion('b', 0));
		Color[] colores=one.colores("buena");
		for (Color x: colores) {
			System.out.println(x.toString());
		}
		one.mostrar('b', 0);
		one.printoculto();
	}

}
