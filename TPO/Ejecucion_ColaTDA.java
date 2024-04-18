package TPO;

public class Ejecucion_ColaTDA {

	public static void main(String[] args) {
		
		ColaTDA Imp2 = new ColaTDA();
		
		//Inicio la cola
		System.out.println("Inicializando la cola...");
		Imp2.InicializarCola();
		
		//Verifico si está vacia
		System.out.println("¿La cola se encuentra vacia?: " + Imp2.ColaVacia());
		
		//Agrego algunos elementos dentro de la cola
		System.out.println("Agregando elementos a la cola...");
		Imp2.AcolarPrioridad(14,0);
		
		//Muestro el primer elemento de la cola
		System.out.println("El primer elemento de la cola es: " + Imp2.Primero());
		Imp2.AcolarPrioridad(2,1);
		Imp2.AcolarPrioridad(67,1);
		Imp2.AcolarPrioridad(91,3);
		
		//Desacolo un elemento de la cola
		System.out.println("Desacolando elemento");
		Imp2.Desacolar();
		
		//Verifico y muestro por pantalla el primer elemento luego de desacolar el anterior
		System.out.println("El primer elemento de la cola es: " + Imp2.Primero());
		
		//Verifico nuevamente si la cola está vacia
		System.out.println("¿La cola está vacía?: " + Imp2.ColaVacia());
	}
}