package TPO;

import java.util.Scanner;

public class Ejecucion {
	
	public static void main(String[] args) {
		
		boolean verificarID = true;
		boolean rangoPrioridad = true;
		int cant = 0;
		
		ColaTDA Cola = new ColaTDA();
		TDA_Conjunto ConjuntoPrioridad1 = new TDA_Conjunto();
		TDA_Conjunto ConjuntoPrioridad2 = new TDA_Conjunto();
		TDA_Conjunto ConjuntoPrioridad3 = new TDA_Conjunto();
		
		//Inicializo la cola de prioridades y las de conjuntos
		System.out.println("Inicializando la cola de prioridades y las de conjuntos...");
		Cola.InicializarCola();
		ConjuntoPrioridad1.InicializarConjunto();
		ConjuntoPrioridad2.InicializarConjunto();
		ConjuntoPrioridad3.InicializarConjunto();
		
		Scanner leer = new Scanner(System.in);
		
		//pide al usuario introducir un ID y una Prioridad por cliente
		
		while(verificarID) {
			System.out.print("Ingrese el ID del cliente [Finalizar con 0]: ");
			int id = leer.nextInt();
			
			//verifica si el usuario introdujo "0" para cortar el bucle
			//comprueba que el usuario haya introducido un minimo de 15 clientes
			
			if(id != 0) {
				
				//pide el ingreso de una prioridad y comprueba que esta misma este en los parametros establecidos
				//si es correcto, lo agrega a la cola, si NO lo es, lo vuelve a pedir
				
				while(rangoPrioridad) {
					System.out.print("Ingrese la prioridad de dicho cliente [1,2,3]: ");
					int prioridad = leer.nextInt();
					
					if(prioridad<1 || prioridad>3) {
						System.out.println("La prioridad debe estar dentro de [1,2,3]");
					}
					else {
						cant++;
						Cola.AcolarPrioridad(id, prioridad);
						rangoPrioridad = false;
					}
				}
				rangoPrioridad = true;
			}
			else{
				if(cant < 2) {
					System.out.println("Debe haber al menos 15 elementos!");
				}
				else {
					verificarID = false;
				}
			}
		}
		
		//verifica el tipo de prioridad de un ID para cargarlo al TDA Conjunto correspondiente
		
		if(Cola.Prioridad() == 1) {
			//CONJUNTO 1
		}
		else {
			if(Cola.Prioridad() == 2) {
				//CONJUNTO 2
			}
			else {
				if(Cola.Prioridad() == 3) {
					//CONJUNTO 3
				}
			}
		}
		leer.close();
		
		
	}
}