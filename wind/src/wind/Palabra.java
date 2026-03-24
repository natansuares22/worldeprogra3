package wind;

import java.awt.Color;

public class Palabra {
 private String palabra ;
 char[] letras;
 char[] letrasadividanas;
 int largo;
 StringBuilder oculta;
Palabra(String pal){
	this.palabra= pal;
	letras= pal.toCharArray();
	this.largo= pal.length();
	this.oculta=Ocultar();
}


void compararpalabras(String comparar) {
	char[] letrasacomparar =comparar.toCharArray();
	for (int i=0; i<largo;i++) {
		if (LetraEnUbicacion(letrasacomparar[i], i)) {
			mostrar(letrasacomparar[i], i);
		}
	}
}
boolean LetraEnPalabra(char x) {
	for (int i=0; i<largo; i++) {
		if (x==palabra.charAt(i))
			return true;
	}
	return false;
}
boolean LetraEnUbicacion(char x, int ubi) {
	if (ubi<0|| ubi>largo)
		return false;
	if (this.palabra.charAt(ubi)==x)
		return true;
	return false;
}
void mostrar(char x, int ubi) {
	if (LetraEnUbicacion(x,ubi)) {
		this.oculta.setCharAt(ubi, x);
	}
	
}
char LetraEnPalabra2(char x) {
	for (int i=0; i<largo; i++) {
		if (x==palabra.charAt(i))
			return x;
	}
	return '*';
}

Color[] colores(String pal) {
	Color[] cols= new Color[largo];
	char[] letrasacomparar =pal.toCharArray();
	for (int i=0; i<largo;i++) {
		cols[i]= colorletra(letrasacomparar[i], i);
	}
	return cols;
}
Color  colorletra(char x, int ubi) {
	if (LetraEnUbicacion(x,ubi))
		return Color.green;
	if (LetraEnPalabra(x))
		return Color.yellow;
	
	return Color.red;
}

void compararpalabra2(String comparar) {
	
}

StringBuilder Ocultar() {
	StringBuilder oculto= new StringBuilder(this.largo);
	for (int i =0; i<largo; i++) {
		oculto.append('*');
	}
	return oculto;
}
void printoculto() {
	System.out.println(oculta);
}
}
