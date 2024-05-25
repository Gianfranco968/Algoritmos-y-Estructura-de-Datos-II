package Implements;
import Interfaces.PilaTDA;

public class PilaTDA_Estrategia_2 implements PilaTDA {

	int [] pila;
	int indice;
	
	public void InicializarPila() {
		pila = new int[100];
		indice = 0;
	}
	public void Apilar(int x) {
		for(int i = indice - 1; i > indice; i--) {
			pila[i+1] = pila[i];
		}
		pila[0] = x;
		indice++;
	}
	public void Desapilar() {
		for(int i = 0; i < indice; i++) {
			pila[i] = pila[i+1];
		}indice--;
	}
	public boolean PilaVacia() {
		return (indice == 0);
	}
	public int Tope() {
		return pila[0];
	}
}