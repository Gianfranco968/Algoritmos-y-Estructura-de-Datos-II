package Interfaces;

public interface ConjuntoTDA {

	public void InicializarConjunto();
	public void Agregar(int x);
	public boolean ConjuntoVacio();
	public int Elegir();
	public boolean Pertenece(int x);
	public void Sacar(int x);
}
