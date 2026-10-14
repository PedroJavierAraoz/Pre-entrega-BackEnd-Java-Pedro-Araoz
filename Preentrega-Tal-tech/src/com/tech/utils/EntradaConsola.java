package com.tech.utils;

import java.util.Scanner;

public final class EntradaConsola {
	private EntradaConsola() {
	}

	public static int leerEntero(Scanner scanner, String mensaje) {
		while (true) {
			System.out.print(mensaje);
			String entrada = leerLinea(scanner);
			try {
				return Integer.parseInt(entrada.trim());
			} catch (NumberFormatException exception) {
				System.out.println("Ingrese un numero entero valido.");
			}
		}
	}

	public static double leerDouble(Scanner scanner, String mensaje) {
		while (true) {
			System.out.print(mensaje);
			String entrada = leerLinea(scanner).trim().replace(',', '.');
			try {
				double valor = Double.parseDouble(entrada);
				if (Double.isFinite(valor)) {
					return valor;
				}
			} catch (NumberFormatException exception) {
				// Se muestra el mensaje de error comun debajo.
			}
			System.out.println("Ingrese un numero decimal valido.");
		}
	}

	public static String leerTexto(Scanner scanner, String mensaje) {
		System.out.print(mensaje);
		return leerLinea(scanner);
	}

	private static String leerLinea(Scanner scanner) {
		if (scanner == null) {
			throw new IllegalArgumentException("El scanner no puede ser null");
		}
		if (!scanner.hasNextLine()) {
			throw new IllegalStateException("No hay mas datos para leer");
		}
		return scanner.nextLine();
	}
}