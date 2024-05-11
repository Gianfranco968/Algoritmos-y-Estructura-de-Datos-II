package TPO;

import java.util.Scanner;

public class Ejecucion {
	
	public static void main(String[] args) {
		
		boolean verificar = true;
		int cant = 0;
		
		ColaTDA Cola = new ColaTDA();

		//Iniciar la cola de prioridades
		System.out.println("Inicializando la cola de prioridades...");
		Cola.InicializarCola();
		
		Scanner leer = new Scanner(System.in);
		//
		while(verificar) {
			System.out.println("Ingrese el ID del cliente [Finalizar con 0]: ");
			int id = leer.nextInt();
			
			if(id != 0) {
				System.out.println("Ingrese la prioridad de dicho cliente: ");
				int prioridad = leer.nextInt();
				cant++;
				Cola.AcolarPrioridad(id, prioridad);
			}
			else{
				if(cant < 15) {
					System.out.println("Debe haber al menos 15 elementos!");
				}
				else {
					break;
				}
			}
		}
		leer.close();
	}
	
//	public static ColaPrioridadTDA copiar(ColaPrioridadTDA X) {
//		ColaPrioridadTDA aux = new ColaPrioridadLD();
//		ColaPrioridadTDA copia = new ColaPrioridadLD();
//		while(!X.ColaVacia()) {
//			aux.AcolarPrioridad(X.Primero(), X.Prioridad());
//			X.Desacolar();
//		}
//		while(!aux.ColaVacia()) {
//			X.AcolarPrioridad(aux.Primero(), aux.Prioridad());
//			copia.AcolarPrioridad(aux.Primero(), aux.Prioridad());
//			aux.Desacolar();
//		}
//		return copia;
//	}
//	
//	public static void mostrarColaPrioridad(ColaPrioridadTDA Z) {
//		ColaPrioridadTDA aux = copiar(Z);
//		System.out.print("<");
//		while(!aux.ColaVacia()) {
//			System.out.print("(" + aux.Primero() + ", " + aux.Prioridad()+")");
//			aux.Desacolar();
//			if(!aux.ColaVacia())
//				System.out.print(", ");
//		}
//		System.out.println(">");
//	}
}