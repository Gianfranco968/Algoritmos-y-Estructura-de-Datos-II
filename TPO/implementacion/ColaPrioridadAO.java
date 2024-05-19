package implementacion;

import api.ColaPrioridadTDA;

public class ColaPrioridadAO implements ColaPrioridadTDA {
	
	class Elemento {
		int valor;
		int prioridad;
	}
	Elemento[] elementos;	//creamos el arreglo de tipo Elemento
	int indice;				//y un indice o puntero quelo recorrerá
	
	@Override
	public void InicializarCola() {
		indice = 0;
		elementos = new Elemento[100];
	} // O(1) -> Costo constante

	@Override
	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		//Desplaza a derecha los elementos de la cola mientras
		//estos tengan mayor o igual prioridad que la de x
		//Las prioridades van de mayor a menor --> 1 > 2 > 3
		for (; j>0 && elementos[j-1].prioridad<=prioridad; j--) {
			elementos[j] = elementos[j-1];
		}
		elementos[j] = new Elemento();
		elementos[j].valor = x;
		elementos[j].prioridad = prioridad;
		indice++;
	}  // O(n) -> Costo lineal

	@Override
	public void Desacolar() {
		elementos[indice-1] = null;
		indice--;
	} // O(1) -> Costo constante

	@Override
	public int Primero() {
		return elementos[indice-1].valor;
	}  // O(1) -> Costo constante

	@Override
	public boolean ColaVacia() {
		return (indice == 0);
	}  // O(1) -> Costo constante

	@Override
	public int Prioridad() {
		return elementos[indice-1].prioridad;
	}  // O(1) -> Costo constante

}
