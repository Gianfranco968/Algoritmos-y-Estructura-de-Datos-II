package Implements;
import Interfaces.ConjuntoTDA;
import Interfaces.DiccionarioSimpleTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA{

	class Elemento{
		int clave;
		int valor;
	}
	Elemento[] elementos;
	int cantidad;
	
	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cantidad = 0;
	}
	public void Agregar(int clave, int valor) {
		int posicion = Clave2Indice(clave);
		if(posicion == -1) {
			posicion = cantidad;
			elementos[posicion] = new Elemento();
			cantidad++;
		}
		elementos[posicion].valor = valor;
	}
	private int Clave2Indice(int clave) {
		int i = cantidad - 1;
		while(i >= 0 && elementos[i].clave != clave) {
			i--;
		}
		return i;
	}
	public void Eliminar(int clave) {
		int posicion = Clave2Indice(clave);
		if(posicion != -1) {
			elementos[posicion] = elementos[cantidad - 1];
			cantidad--;
		}
	}
	public int Recuperar(int clave) {
		int posicion = Clave2Indice(clave);
		return elementos[posicion].valor;
	}
	public ConjuntoTDA Claves() {
		ConjuntoTDA c = new Conjunto_TDA();
		c.InicializarConjunto();
		
		for(int i = 0; i < cantidad; i++) {
			c.Agregar(elementos[i].clave);
		}
		return c;
	}
}
