package ejecucion;

import java.util.ArrayList;
import java.util.Scanner;

import api.ConjuntoTDA;
import implementacion.ColaPrioridadAO;
import implementacion.ConjuntoTA;

public class Ejecutable {

	public static void mostrarConjunto(ConjuntoTDA A) {
		int x;
		if (A.ConjuntoVacio()) {
			System.out.print("Aún no se han registrado clientes en este tipo.");
		}
		while (!A.ConjuntoVacio()) {
			x = A.Elegir();
			A.Sacar(x);
			System.out.print("ID - " + x);
			if (!A.ConjuntoVacio()) {
				System.out.print("; ");
			}
		}
	}

	public static void main(String[] args) {
		boolean verificarID = true;
		boolean rangoPrioridad = true;
		int cant = 0;

		ColaPrioridadAO Cola = new ColaPrioridadAO();
		ConjuntoTA ConjuntoEmpresa = new ConjuntoTA();
		ConjuntoTA ConjuntoParticularCliente = new ConjuntoTA();
		ConjuntoTA ConjuntoParticularNoCliente = new ConjuntoTA();
		ArrayList<Integer> listaIDs = new ArrayList<>(); // Para verificar que no se repitan los IDs de clientes
															// cargados

		// Inicializo la cola de prioridades y las de conjuntos
		System.out.println("Inicializando la cola de prioridades y los conjuntos...");
		Cola.InicializarCola();
		ConjuntoEmpresa.InicializarConjunto();
		ConjuntoParticularCliente.InicializarConjunto();
		ConjuntoParticularNoCliente.InicializarConjunto();

		// Precarga de datos de prueba
		System.out.println("Precargando datos de prueba...");
		int[][] datosDePrueba = { { 101, 1 }, { 102, 1 }, { 103, 1 }, // Empresa
				{ 201, 2 }, { 202, 2 }, { 203, 2 }, // Particular Cliente
				{ 301, 3 }, { 302, 3 }, { 303, 3 }, // Particular No Cliente
		};

		for (int[] dato : datosDePrueba) {
			Cola.AcolarPrioridad(dato[0], dato[1]);
			listaIDs.add(dato[0]);
			cant++;
		}

		Scanner leer = new Scanner(System.in);

		// Solicitamos al usuario introducir un ID y una Prioridad por cliente
        while (verificarID) {
            System.out.print("Ingrese el ID del cliente [Para generar el informe ingrese 0]: ");
            int id = leer.nextInt();

            if (id != 0) { // con 0 finaliza el bucle de carga de datos
                if (!listaIDs.contains(id)) {
                    // pide el ingreso de una prioridad y comprueba que esta misma este en los
                    // parametros establecidos
                    // si es correcto, lo agrega a la cola, si NO lo es, lo vuelve a pedir
                    while (rangoPrioridad) {
                        System.out.print(
                                "Ingrese por número la prioridad de dicho cliente [Empresa (1) | Particular cliente (2) | Particular no cliente (3)]: ");
                        int prioridad = leer.nextInt();

                        if (prioridad < 1 || prioridad > 3) {
                            System.out.println("Valor inválido. Las prioridades pueden ser [1,2,3].");
                        } else {
                            cant++;
                            Cola.AcolarPrioridad(id, prioridad);
                            listaIDs.add(id);  // Agrega el ID al ArrayList con los IDs
                            rangoPrioridad = false;
                        }
                    }
                    rangoPrioridad = true;
                } else {
                    System.out.println("El ID " + id + " ya está registrado. Ingrese un ID diferente.");
                }
            } else { // Si finaliza la carga comprobamos que hayan mínimo 15 elementos cargados
                if (cant < 15) {
                    System.out.println("Deben cargarse al menos 15 clientes para generar el informe!");
                    System.out.println("Cantidad de clientes cargados: " + cant);
                } else {
                    verificarID = false;
                }
            }
        }


		// Verifica el tipo de prioridad para cargarlo al Conjunto correspondiente
		// Devolucion segun el tipo
		while (!Cola.ColaVacia()) {
			int p = Cola.Prioridad();
			if (p == 1) {
				ConjuntoEmpresa.Agregar(Cola.Primero());
			} else if (p == 2) {

				ConjuntoParticularCliente.Agregar(Cola.Primero());
			} else if (p == 3) {

				ConjuntoParticularNoCliente.Agregar(Cola.Primero());
			}
			Cola.Desacolar();
		}

		leer.close();

		// Devoluciones segun prioridades por tipo de cliente
		System.out.println("------------------------------------------------------------");
		System.out.println("------------------------Informe-----------------------------");
		System.out.println();
		System.out.println("Cantidad total de clientes registrados: " + cant);
		System.out.println();
		System.out.println();
		System.out.println("Clientes atendidos según tipo:");
		System.out.println();
		System.out.print("EMPRESA: ");
		mostrarConjunto(ConjuntoEmpresa);
		System.out.println();
		System.out.println();
		System.out.print("PARTICULAR CLIENTE: ");
		mostrarConjunto(ConjuntoParticularCliente);
		System.out.println();
		System.out.println();
		System.out.print("PARTICULAR NO CLIENTE: ");
		mostrarConjunto(ConjuntoParticularNoCliente);
		System.out.println();
		System.out.println("------------------------------------------------------------");

	}

}
