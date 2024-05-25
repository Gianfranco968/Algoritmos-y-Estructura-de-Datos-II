package Implements;
import Interfaces.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA{

	class Elemento{
		int clave;
		int[] valores;
		int cantidadValores;
	}
	Elemento[] elementos;
	int cantidadClaves;
	
	public void InicializarDiccionario() {
		elementos = new Elemento[100];
		cantidadClaves = 0;
	}
	public void Agregar(int clave, int valor) {
		int posicionC = Clave2Indice(clave);
		if(posicionC == -1) {
			posicionC = cantidadClaves;
			elementos[posicionC] = new Elemento();
			elementos[posicionC].clave = clave;
			elementos[posicionC].cantidadValores = 0;
			elementos[posicionC].valores = new int[100];
			cantidadClaves++;
		}
		Elemento e = elementos[posicionC];
		int posicionV = Valor2Indice(e, valor);
		if(posicionV == -1) {
			e.valores[e.cantidadValores] = valor;
			e.cantidadValores++;
		}
	}
	private int Clave2Indice(int clave) {
		int i = cantidadClaves - 1;
		while(i >= 0 && elementos[i].clave != clave) {
			i--;
		} return i;
	}
	public void Eliminar(int clave) {
		int posicion = Clave2Indice(clave);
		if(posicion != -1) {
			elementos[posicion] = elementos[cantidadClaves - 1];
			cantidadClaves--;
		}
	}
	 public void EliminarValor(int clave, int valor) {
		 int posicionC = Clave2Indice(clave);
		 if (posicionC!=-1) {
			 Elemento e = elementos[posicionC];
			 int posicionV = Valor2Indice(e, valor);
			 if(posicionV != -1) {
				 e.valores[posicionV] = e.valores[e.cantidadValores - 1];
				 e.cantidadValores--;
				 if(e.cantidadValores == 0) {
					 Eliminar(clave);
				 }
			 }
		 }
	 }
	 private int Valor2Indice(Elemento e, int valor) {
		 int i = e.cantidadValores-1;
		 while(i >= 0 && e.valores[i] != valor) {
			 i--;
		 } 
		 return i;
	}
	 public Conjunto_TDA Recuperar(int clave) {
		 Conjunto_TDA c = new Conjunto_TDA();
		 c.InicializarConjunto();
		 int posicion = Clave2Indice(clave);
		 if (posicion!=-1) {
		 Elemento e = elementos[posicion];
		 for(int i=0; i < e.cantidadValores; i++){
			 c.Agregar(e.valores[i]);
		 	}
		 }
		 return c;
	}
	 public Conjunto_TDA Claves() {
		 Conjunto_TDA c=new Conjunto_TDA();
		 c.InicializarConjunto();
		 
		 for(int i = 0; i < cantidadClaves; i++){
			 c.Agregar(elementos[i].clave);
		 }
		 return c;
	} 
}