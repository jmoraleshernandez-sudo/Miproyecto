package Ej_1;
import java.util.Scanner;

//1. Crea un programa que solicite 20 números y luego los muestre en el orden inverso al que se
//introdujeron.



public class Ej_1 {

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] numeros = new int[20];
		
		for(int i =0;i<numeros.length;i++) {
			System.out.print("Introduce un número:");
			numeros[i]= Integer.parseInt(teclado.nextLine());
		}
		
		for(int i=numeros.length;i>0;i--) {
			System.out.println(numeros[i-1]);
		}
	}

}
