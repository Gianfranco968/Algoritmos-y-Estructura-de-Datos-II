package Implements;
import Interfaces.PilaTDA;

public class PilaTDA_Estrategia_1 implements PilaTDA{

	int [] pila;
	int indice;
	
	public void InicializarPila() {
		pila = new int[100];
		indice = 0;
	}
	public void Apilar(int x) {
		pila[indice] = x;
		indice++;
	}
	public void Desapilar() {
		indice--;
	}
	public boolean PilaVacia() {
		return (indice == 0);
	}
	public int Tope() {
		return pila[indice-1];
	}
}
