package SimonDice;

import java.util.Random;
import java.util.Scanner;

public class engine {

	/*
	 * Metodo de colores
	 */
	public enum tColores {
		Rojo, Dorado, Verde, Azul
	}

	static int MAX_COLORES_SEQ = 12;
	tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

	/**
	 * Metodo para relacionar los colores con 
	 * @param _color
	 * @return
	 */
	public tColores charToColor(char _color) {
		tColores eleccion = null;
		char LetraColores = Character.toLowerCase(_color); // Para q no diferencie entre mayusculas y minusculas
		switch (LetraColores) {
		case 'r':
			eleccion = tColores.Rojo;
			break;
		case 'a':
			eleccion = tColores.Azul;
			break;
		case 'v':
			eleccion = tColores.Verde;
			break;
		case 'd':
			eleccion = tColores.Dorado;
			break;
		default:
			System.out.println("No existe ningun color asi en el juego");

		}
		return eleccion;

	}

	/**
	 * Metodo para relacionar los colores con numeros para el arrays
	 * @param _numero
	 * @return
	 */
	public static tColores intToColor(int _numero) {
		tColores numeros = null;
		switch (_numero) {
		case 1:
			numeros = tColores.Rojo;
			break;
		case 2:
			numeros = tColores.Azul;
			break;
		case 3:
			numeros = tColores.Verde;
			break;
		case 4:
			numeros = tColores.Dorado;
			break;

		}
		return numeros;
	}

	/**
	 * Metodo para gererar una secuencia ramdon
	 * @param _numColores
	 */
	public void generarSecuencia(int _numColores) {

		int limite = MAX_COLORES_SEQ - 1;
		for (int i = 0; i < secuenciaColores.length; i++) {
			Random random = new Random();
			int aleatorio = random.nextInt(1, 5);
			secuenciaColores[i] = intToColor(aleatorio);
		}
	}

	/**
	 * Metodo para mostrar el array
	 * @param _numero
	 */
	void mostrarSecuencia(int _numero) {
		for (int i = 0; i < _numero; i++) {
			System.out.print(secuenciaColores[i] + " ");
		}
	}

	/**
	 * Metodo para comparar la secuencia y ver si a ganado o a perdido
	 * @param _index
	 * @param _color
	 * @return
	 */
	boolean comprobarColor(int _index, tColores _color) {
		return secuenciaColores[_index] == _color;

	}

	/**
	 * Metodo para ejecutar un menu para jugar
	 */
	public void menu() {
		System.out.println("");
		System.out.println("Presiona-1 para salir");
		System.out.println("");
		System.out.println("Presiona-2 para jugar");
	}

	/*
	 * Metodo para que muestre el mensaje de biembenida al jugador
	 */
	public void inicio() {
		// Memsaje de biembenida
		System.out.println("Biembenido a Simon Dice");
		System.out.print("Introduce tu nombre: ");
		Scanner scNombre = new Scanner(System.in);
		String nombre = scNombre.nextLine();
		System.out.println("");
		System.out.println("Biembenido a Simon Dice " + nombre);

		play();
	}

	/**
	 * Metodo para que se ejecute el programa
	 */
	public void play() {

		menu();

		// Introducir numeros para empezar a jugar
		Scanner menu = new Scanner(System.in);
		int _menu = menu.nextInt();

		if (_menu == 1) {
			System.out.println("Saliste del juego");
		} else if (_menu == 2) {
			generarSecuencia(12);

			// Comienzo del juego
			for (int i = 0; i < MAX_COLORES_SEQ; i++) {
				System.out.println(" ");

				// Mostrar la secuencia
				mostrarSecuencia(3 + i);
				System.out.println("");

				// Limpiar la pantalla y pulsar el ENTER para introducir la secuencia
				System.out.println("Pulsa ENTER para comenzar");
				Scanner comenzar = new Scanner(System.in);
				String ENTER = comenzar.nextLine();
				if (ENTER == ENTER) {
					for (int i1 = 0; i1 < 30; i1++)
						System.out.println();
				}

				// Introducir los colores y comprobar que estan bien
				System.out.println("Introduce los colores");

				for (int j = 0; j < 3 + i; j++) {

					char letraColor = new Scanner(System.in).next().charAt(0);
					tColores Color_Elegido = charToColor(letraColor);

					if (comprobarColor(j, Color_Elegido)) {
						System.out.println("Color correcto");
					} else {
						System.out.println("Has fallado");
						play();
					}
				}
			}
		}
	}
}
