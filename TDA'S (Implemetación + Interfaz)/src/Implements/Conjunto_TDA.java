package Implements;
import Interfaces.ConjuntoTDA;

public class Conjunto_TDA implements ConjuntoTDA {

	int [] conjunto;
	int cantidad;
	
	public void InicializarConjunto() {
		conjunto = new int[100];
		cantidad = 0;
	}
	public void Agregar(int x) {
		while(!this.Pertenece(x)) {
			conjunto[cantidad] = x;
			cantidad++;
		}
	}
	public boolean Pertenece(int x) {
		int i = 0;
		while(i < cantidad && conjunto[i]!=x) {
			i++;
		}return (i < cantidad);
	}
	public boolean ConjuntoVacio() {
		return (cantidad == 0);
	}
	public int Elegir() {
		return conjunto[cantidad-1];
	}
	public void Sacar(int x) {
		int i = 0;
		while (i < cantidad && conjunto[cantidad] != x){
			i++;
		}if (i < cantidad) {
			conjunto[i] = conjunto[cantidad-1];
			cantidad--;
		}
	}
}
