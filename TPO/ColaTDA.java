//Implementar en lenguaje JAVA el TDA Cola con prioridades completo 
//usando la estrategia de implementación 2 (desarrollada en clase)

package TPO;
	
public class ColaTDA implements InterfazCola {
	
	class Elemento {
		int valor;
		int prioridad;
	}
	Elemento[] elementos;
	int indice;
	
	@Override
	public void InicializarCola() {
		indice = 0;
		elementos = new Elemento[100];
	}
	
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
	}
	
	@Override
	public void Desacolar() {
		elementos[indice-1] = null;
		indice--;
	}
	
	@Override
	public int Primero() {
		return elementos[indice-1].valor;
	}
	
	@Override
	public boolean ColaVacia() {
		return (indice == 0);
	}
	
	@Override
	public int Prioridad() {
		return elementos[indice-1].prioridad;
	}
}