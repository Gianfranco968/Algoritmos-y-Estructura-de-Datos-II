package Implements;
import Interfaces.ColaTDA;

public class ColaTDA_Estrategia_1 implements ColaTDA{

	int [] cola;
	int indice;
	
	public void InicializarCola() {
		cola = new int[100];
		indice = 0;
	}
	public void Acolar(int x) {
		for(int i = indice - 1; i >= 0; i--) {
			cola[i+1] = cola[i];
		}
		cola[0] = x;
		indice++;
	}
	public void Desacolar() {
		indice--;
	}
	public boolean ColaVacia() {
		return (indice == 0);
	}
	public int Primero() {
		return cola[indice-1];
	}
	
}
