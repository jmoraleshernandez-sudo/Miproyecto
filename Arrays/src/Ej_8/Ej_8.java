package Ej_8;
import java.util.Scanner;
//8. Realiza un programa que pida la temperatura media (entero) que ha hecho en cada mes de un
//determinado año y que muestre a continuación un diagrama de barras horizontales con esos datos.
//Las barras del diagrama se pueden dibujar a base de asteriscos o cualquier otro carácter.

public class Ej_8 {
	
	
	private static final int NUMERO_MESES = 12;
	private static final String[] MESES = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
	private static Scanner teclado = new  Scanner(System.in);
	
	public static void main(String[] args) {
		int[] temperaturas = new int[NUMERO_MESES];
		
		pedirTemperaturasMeses(temperaturas);
		
		imprimirTemperaturasGrafica(temperaturas);

	}
	public static void pedirTemperaturasMeses(int[] array) {
		for(int i = 0;i<array.length;i++) {
			do {
				System.out.print("Introduce la temperatura media de "+MESES[i]+" :");
				array[i] = Integer.parseInt(teclado.nextLine());
			}while(array[i]<0);
			
		}
	}
	public static void imprimirTemperaturasGrafica(int[] array) {
		for(int i = 0;i<array.length;i++) {
			System.out.print(MESES[i]+"\t");
			for(int x =0;x<array[i];x++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
