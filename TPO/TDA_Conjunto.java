//Implementar en JAVA el TDA Conjunto completo implementado con arreglos

package TPO;

public class TDA_Conjunto implements InterfazConjunto {
	int[] a;
	int cantidad;
	
	@Override
	public void Agregar(int x) {
		if (!this.Pertenece(x)) {
			a[cantidad] = x;
			cantidad++;
		}
	}
	
	@Override
	public boolean ConjuntoVacio() {
		return cantidad == 0;
	}
	
	@Override
	public int Elegir() {
		return a[cantidad-1];
	}
	
	@Override
	public void InicializarConjunto() {
		a = new int[100];
		cantidad = 0;
	}
	
	@Override
	public boolean Pertenece(int x) {
		int i=0;
		while (i<cantidad && a[i]!=x) {
			i++;
		}
		return (i<cantidad);
	}
	
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
		
	}
}