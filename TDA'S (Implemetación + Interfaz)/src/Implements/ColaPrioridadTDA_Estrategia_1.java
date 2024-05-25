package Implements;
import Interfaces.ColaPrioridadTDA;

public class ColaPrioridadTDA_Estrategia_1 implements ColaPrioridadTDA{

	int [] elementos;
	int [] prioridades;
	int indice;
	
	public void InicializarColaPrioridad() {
		elementos = new int[100];
		prioridades = new int[100];
		indice = 0;
	}
	public void AcolarPrioridad(int x, int prioridad) {
		int j = indice;
		for ( ; j > 0 && prioridades[j-1] >= prioridad; j--) {
			elementos[j] = elementos[j-1];
			prioridades[j] = prioridades[j-1];
		}
		elementos[j] = x;
		prioridades[j] = prioridades[j-1];
		indice++;
	}
	public void Desacolar() {
		indice--;
	}
	public int Primero() {
		return elementos[indice-1];
	}
	public boolean ColaVacia() {
		return (indice == 0);
	}
	public int Prioridad() {
		return prioridades[indice-1];
	}
	
	
}
