package TPO;

public interface InterfazCola {

	public void InicializarCola();
	public void AcolarPrioridad(int x, int prioridad);
	public void Desacolar();
	public int Primero();
	public boolean ColaVacia();
	public int Prioridad();

}