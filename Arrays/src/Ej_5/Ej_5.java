package Ej_5;
import java.util.Arrays;
import java.util.Random;
//5. Crear un programa que sirva para crear una combinación de números de la lotería Primitiva. Debe
//crear una combinación de 6 números diferentes entre 1 y 49.

public class Ej_5 {
	
	
	private static final int NUMERO_MAXIMO = 49;
	private static final int NUMERO_MINIMO = 1;
	private static final int CANTIDAD_NUMEROS = 6;
	public static void main(String[] args) {
		int[] combinacion = new int[CANTIDAD_NUMEROS-1];
		int numero;
		
		generarNumerosAleatorios(combinacion, NUMERO_MINIMO, NUMERO_MAXIMO);
		
		numero = sacarDigitosDeCadaElementoArray(combinacion);
		
		System.out.println("La array es:"+Arrays.toString(combinacion)); // Comprobar la array
		
		System.out.println(numero);
	}
	/**
	 * Genera números aleatorios para llenar una array .
	 * 
	 * @param array        Array a rellenar con números aleatorios.
	 * @param numeroMinimo Numero mínimo aleatorio que puede salir.
	 * @param numeroMaximo Numero máximo aleatorio que puede salir.
	 */
	public static void generarNumerosAleatorios(int[] array, int numeroMinimo, int numeroMaximo) {
		Random serieAleatoria = new Random();//Lo meto aquí para hacer lo más portable, preguntar por ello.
		for (int i = 0; i < array.length; i++) {
			array[i] = serieAleatoria.nextInt(numeroMinimo, numeroMaximo + 1);
		}
	}
	/**
	 * Como su nombre indica esta funcion recoje una array y traspasa los digitos
	 * a un valor entero 
	 * @param array Array de la que se quiere recojer los dígitos.
	 * @return Entero con los digitos
	 */
	public static int sacarDigitosDeCadaElementoArray(int[] array) {
		int numero,aux,multiplicador;
		
		//Version sin errores pero no perfecta.
		numero = array[0];//Asigno el primer valor del array al numero para simplificarlo.
		
		for (int i = 1; i < array.length; i++) {
			//Asigno el valor de la lista a aux para poder sacarle las cifras
			aux = array[i];
			//Compruebo cuantas cifras tiene y hago la potencia según.
			multiplicador = (int) Math.pow(10,averiguarCifrasEntero(aux));
			
			//Aquí multiplico por la cantidad de digitos que tiene y luego le sumo el valor
			numero = (numero*multiplicador)+aux;
		}
		
//		Version con error cuando hay numeros pares pero más limpia.
//		numero = 0;
//		
//		for (int i = 0; i < array.length; i++) {
//			//Asigno el valor de la lista a aux para poder sacarle las cifras
//			aux = array[i];
//			//Compruebo cuantas cifras tiene y hago la potencia según.
//			multiplicador = (int) Math.pow(10,averiguarCifrasEntero(aux));
//			
//			//Aquí multiplico por la cantidad de digitos que tiene y luego le sumo el valor
//			numero = (numero*multiplicador)+aux;
//		}
		return numero;
	}
	/**
	 * Averigua cuantas cifras tiene un número entero.
	 * @param numero Número del que se quieren saber las cifras.
	 * @return El número de cifras que tiene.
	 */
	public static int averiguarCifrasEntero(int numero) {
		int cifras = 0;
		do {
			numero = numero / 10;
			cifras++;
		} while (numero != 0);
		return cifras;
	}
	
	
}
