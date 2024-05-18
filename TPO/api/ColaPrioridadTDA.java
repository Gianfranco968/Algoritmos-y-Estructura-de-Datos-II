package api;

public interface ColaPrioridadTDA {
	public void InicializarCola();						//sin precondiciones
	public void AcolarPrioridad(int x, int prioridad);	//cola inicializada
	public void Desacolar();							//cola inicializada y no vacia
	public int Primero();								//cola inicializada y no vacia
	public boolean ColaVacia();							//cola inicializada
	public int Prioridad();								//cola inicializada y no vacia
}
