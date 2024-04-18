package TPO;

public class Ejecucion_TDA_Conjunto {

	public static void main(String[] args) {
		
		TDA_Conjunto Imp = new TDA_Conjunto();
		
		//Inicio el conjunto
		System.out.println("Inicializando el conjunto...");
		Imp.InicializarConjunto();
				
		//Verifico si está vacia
		System.out.println("¿El conjunto se encuentra vacio?: " + Imp.ConjuntoVacio());
		
		//Agregro elementos al conjunto
		System.out.println("Agregando elementos al conjunto...");
		Imp.Agregar(45);
		Imp.Agregar(30);
		Imp.Agregar(72);
		Imp.Agregar(22);
		
		//Verifico si el 30 pertenece al conjunto
		System.out.println("¿El 30 pertenece al conjunto?: " + Imp.Pertenece(30));
		
		//Saco el elemento del conjunto
		System.out.println("Sacando el elemento del conjunto...");
		Imp.Sacar(30);
		
		//Elijo un elemento dentro del conjunto y lo muestro
		System.out.println("Eligiendo un elemento del conjunto...");
		System.out.println("El elemento elegido es: " + Imp.Elegir());
	}
}