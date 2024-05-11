//Implementar en JAVA el TDA Conjunto completo implementado con arreglos

package TPO;

public class TDA_Conjunto {
	int[] a;
	int cantidad;
	
	public void Agregar(int x) {
		if (!this.Pertenece(x)) {
			a[cantidad] = x;
			cantidad++;
		}
	}
	
	public boolean ConjuntoVacio() {
		return cantidad == 0;
	}
	
	public int Elegir() {
		return a[cantidad-1];
	}
	
	public void InicializarConjunto() {
		a = new int[100];
		cantidad = 0;
	}
	
	public boolean Pertenece(int x) {
		int i=0;
		while (i<cantidad && a[i]!=x) {
			i++;
		}
		return (i<cantidad);
	}
	
	public void Sacar(int x) {
		int i=0;
		while (i<cantidad && a[i]!=x) {
			i++;
		}
		if (i<cantidad) {
			a[i] = a[cantidad-1];
			cantidad--;
		}
		
	}
}