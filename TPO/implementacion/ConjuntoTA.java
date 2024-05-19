package implementacion;

import api.ConjuntoTDA;

public class ConjuntoTA implements ConjuntoTDA {
	
	int[] a;
	int cantidad;
	
	@Override
	public void InicializarConjunto() {
		a = new int[100];
		cantidad = 0;
	}  // O(1) -> Costo constante

	@Override
	public void Agregar(int x) {
		if (!this.Pertenece(x)) {
			a[cantidad] = x;
			cantidad++;
		}
	} // O(n) -> Costo lineal

	@Override
	public void Sacar(int x) {
		int i=0;
		while (i<cantidad && a[i]!=x) {
			i++;
		}
		if (i<cantidad) {
			a[i] = a[cantidad-1];
			cantidad--;
		}
	} // O(n) -> Costo lineal

	@Override
	public boolean Pertenece(int x) {
		int i=0;
		while (i<cantidad && a[i]!=x) {
			i++;
		}
		return (i<cantidad);
	} // O(n) -> Costo lineal

	@Override
	public int Elegir() {
		return a[cantidad-1];
	} // O(1) -> Costo constante

	@Override
	public boolean ConjuntoVacio() {
		return cantidad == 0;
	} // O(1) -> Costo constante

}
