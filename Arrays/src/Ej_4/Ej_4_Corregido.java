package Ej_4;

import java.util.Random;
//import java.util.Arrays;

//Crea un programa que cree 60 números aleatorios de 0 a 100 (usa una constante para fijar este
//número).
//Muestra:
//La media de los números leídos.
//El dígito en el que más números terminan.
//En qué dígitos no ha terminado ningún número.
//Cuántos números terminan en cada uno de los dígitos (0 .. 9)

public class Ej_4_Corregido {

	// Constantes
	private static final int CANTIDAD_CIFRAS = 10;
	private static final int MAXIMO_NUMERO = 100;
	private static final int MINIMO_NUMERO = 0;
	private static final int CANTIDAD_NUMEROS = 60;

	// Generador de números aleatorios
	public static Random serieAleatoria = new Random();

	public static void main(String[] args) {
		double media;
		int ultimoNumeroMasComun;

		int[] numeros = new int[CANTIDAD_NUMEROS];
		int[] frecuencia = new int[CANTIDAD_CIFRAS];

		generarNumerosAleatorios(numeros, MINIMO_NUMERO, MAXIMO_NUMERO);
//		System.out.println("La array es:"+Arrays.toString(numeros)); // Comprobar la array

		// Calculo valores
		media = calcularMediaArray(numeros);
		frecuencia = calcularFrecuenciaTerminaciones(numeros);
		ultimoNumeroMasComun = averiguarPosicionConMayorValor(frecuencia);

		// Imprimo resultados
		System.out.println("Media:" + media);
		System.out.println("Dígito en el que más números terminan: " + ultimoNumeroMasComun);
		imprimirDigitosQueNoAparecen(frecuencia);
		imprimirFrecuenciaTerminacion(frecuencia);

	}
	
	/**
	 * Calcula la frecuencia de en que dígitos acaban los valores de un array entero.
	 * @param array Array del que se quiere saber la frecuencia.
	 * @return Array de frecuencias.
	 */
	public static int[] calcularFrecuenciaTerminaciones(int[] array) {
		// Creo 2 listas, 1 para saber el último dígito y la otra para
		// contar la frecuencia de cada dígito.
		int[] digitosListaIngresada = new int[array.length];

		// Cada posicion equivale a su numero(posicion[0]= digito "0",
		// posicion[1]= digito "1")

		int[] cantidadDigitos = new int[10];
		// Averiguo el ultimo digito de cada elemento del array y lo meto en otra.
		digitosListaIngresada = averiguarUltimoDigitoEnCadaElementoArray(array);

		// Calculo la frecuencia de cada digito en la array
		cantidadDigitos = calcularFrecuenciaNumeroEnArray(digitosListaIngresada);

		return cantidadDigitos;
	}

	/**
	 * Genera números aleatorios para llenar una array .
	 * 
	 * @param array        Array a rellenar con números aleatorios.
	 * @param numeroMinimo Numero mínimo aleatorio que puede salir.
	 * @param numeroMaximo Numero máximo aleatorio que puede salir.
	 */
	public static void generarNumerosAleatorios(int[] array, int numeroMinimo, int numeroMaximo) {
		for (int i = 0; i < array.length; i++) {
			array[i] = serieAleatoria.nextInt(numeroMinimo, numeroMaximo + 1);
		}
	}

	/**
	 * Como su nombre indica, calcula la media de los números de una array.
	 * 
	 * @param array
	 * @return
	 */
	public static double calcularMediaArray(int[] array) {
		double media;
		int acumulador = 0;
		for (int i = 0; i < array.length; i++) {
			acumulador = acumulador + array[i];
		}
		media = (double) acumulador / array.length;

		return media;
	}

	/**
	 * Esta funcion calcula la frecuencia de un número ( del 0 al 9)en una array y
	 * devuelve otra con la frecuencia de cada numero.
	 * 
	 * @param array Array de la que se va a calcular la frecuencia de cada numero
	 * @return Lista con las frecuencias de los números.
	 */
	public static int[] calcularFrecuenciaNumeroEnArray(int[] array) {
		int digito = 0;
		int[] frecuencia = new int[10];

		// Este bucle va sumando la cantidad de numeros que aparece en la lista
		// introducida a la lista frecuencia.

		for (int i = 0; i < array.length; i++) {
			digito = array[i];
			frecuencia[digito]++;
		}
		return frecuencia;
	}

	/**
	 * Como su nombre indica esta funcion recoje una array y traspasa los últimos
	 * digitos de cada valor a otra lista.
	 * 
	 * @param array Array de la que se quiere recojer los dígitos.
	 * @return Array con los últimos digitos
	 */
	public static int[] averiguarUltimoDigitoEnCadaElementoArray(int[] array) {
		int[] digitosListaIngresada = new int[array.length];
		// Este bucle saca todos los dígitos finales del array anterior
		for (int i = 0; i < array.length; i++) {
			digitosListaIngresada[i] = array[i]%10;
		}
		return digitosListaIngresada;
	}

	/**
	 * Este otro bucle recorre la lista de valores y pilla la posicion del que es
	 * mas grande.
	 * 
	 * @param array
	 * @return
	 */
	public static int averiguarPosicionConMayorValor(int[] array) {
		int posicionMayorValor = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > array[posicionMayorValor]) {
				posicionMayorValor = i;

			}
		}
		return posicionMayorValor;
	}

	/**
	 * Imprime cuales son los valores en que no acaban los números.
	 * 
	 * @param array
	 */
	public static void imprimirDigitosQueNoAparecen(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				System.out.println("Ningún número ha acabado en el dígito: " + i);
			}
		}

	}

	/**
	 * Esta función imprime la cantidad de números que acaban en cada dígito del 0
	 * al 9 en un array introducido.
	 * 
	 * @param array
	 */
	public static void imprimirFrecuenciaTerminacion(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " números han acabado en: " + i);
		}
	}
}
