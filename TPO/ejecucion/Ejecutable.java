package ejecucion;

import java.util.Scanner;

import api.ConjuntoTDA;
import implementacion.ColaPrioridadAO;
import implementacion.ConjuntoTA;

public class Ejecutable {
	
	public static void mostrarConjunto(ConjuntoTDA A) {
		int x;
		while(!A.ConjuntoVacio()) {
			x = A.Elegir();
			A.Sacar(x);
			System.out.print("- " + x);
			if(!A.ConjuntoVacio()) {
				System.out.print("\n");
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
		
		//Inicializo la cola de prioridades y las de conjuntos
		System.out.println("Inicializando la cola de prioridades y los conjuntos...");
		Cola.InicializarCola();
		ConjuntoEmpresa.InicializarConjunto();
		ConjuntoParticularCliente.InicializarConjunto();
		ConjuntoParticularNoCliente.InicializarConjunto();
		
		Scanner leer = new Scanner(System.in);
		
		//pedimos al usuario introducir un ID y una Prioridad por cliente
		while(verificarID) {
			System.out.print("Ingrese el ID del cliente [Finalizar con 0]: ");
			int id = leer.nextInt();

			if(id != 0) {	//con 0 finaliza el bucle de carga de datos
				
				//pide el ingreso de una prioridad y comprueba que esta misma este en los parametros establecidos
				//si es correcto, lo agrega a la cola, si NO lo es, lo vuelve a pedir
				while(rangoPrioridad) {
					System.out.print("Ingrese la prioridad de dicho cliente [1,2,3]: ");
					int prioridad = leer.nextInt();
					
					if(prioridad<1 || prioridad>3) {
						System.out.println("Valor inválido. Las prioridades pueden ser [1,2,3].");
					}
					else {
						cant++;
						Cola.AcolarPrioridad(id, prioridad);
						rangoPrioridad = false;
					}
				}
				rangoPrioridad = true;
			}
			else{	//si finaliza la carga comprobamos que hayan minimo 15 elementos(clientes)
				if(cant < 2) {
					System.out.println("Debe haber al menos 15 elementos!");
				}
				else {
					verificarID = false;
				}
			}
		}
		
		//verifica el tipo de prioridad para cargarlo al Conjunto correspondiente
		//devolucion segun el tipo
		while(!Cola.ColaVacia()) {
			int p = Cola.Prioridad();
			if(p == 1) {
				ConjuntoEmpresa.Agregar(Cola.Primero());
			}
			else if(p == 2) {
				
				//CONJUNTO 2
			}
			else if(p == 3) {
				
				//CONJUNTO 3
			}
			Cola.Desacolar();
		}		
		
		
		leer.close();
		
		//devoluciones segun prioridades
		System.out.println("Clientes atendidos según tipo:");
		System.out.println("EMPRESA:");
		mostrarConjunto(ConjuntoEmpresa);
		
		System.out.println("PARTICULAR CLIENTE:");
		//mostrarConjunto(ConjuntoEmpresa);
		
		System.out.println("PARTICULAR NO CLIENTE:");
		//mostrarConjunto(ConjuntoEmpresa);
		
	}

}
