package Interfaces;

public interface ColaPrioridadTDA {

	public void InicializarColaPrioridad();
	public void AcolarPrioridad(int x, int p);
	public void Desacolar();
	public int Primero();
	public boolean ColaVacia();
	public int Prioridad();
}
