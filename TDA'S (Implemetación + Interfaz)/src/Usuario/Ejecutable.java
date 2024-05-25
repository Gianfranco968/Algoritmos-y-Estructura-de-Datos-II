package Usuario;
import Implements.ColaTDA_Estrategia_1;
import Implements.PilaTDA_Estrategia_1;
import Interfaces.PilaTDA;
import Interfaces.ColaTDA;

public class Ejecutable {
	
	public static void main(String[] args) { 

		System.out.print("Verificar");
		Ejecutable ejecutable = new Ejecutable();
		ejecutable.VerificarCapicua();
	}
	public void VerificarCapicua() {
		
		ColaTDA_Estrategia_1 colaOrigen = new ColaTDA_Estrategia_1();
		ColaTDA_Estrategia_1 colaDestino = new ColaTDA_Estrategia_1();
		PilaTDA_Estrategia_1 pila = new PilaTDA_Estrategia_1();
		
		colaOrigen.InicializarCola();
        pila.InicializarPila();
		colaDestino.InicializarCola();
		
        colaOrigen.Acolar(1);
        colaOrigen.Acolar(2);
        colaOrigen.Acolar(3);
        
        pila.Apilar(3);
        pila.Apilar(2);
        pila.Apilar(3);
        
		while(!colaOrigen.ColaVacia()) {
			colaDestino.Acolar(colaOrigen.Primero());
			colaOrigen.Desacolar();
		}
		while(!colaDestino.ColaVacia()) {
			if(colaDestino.Primero() == pila.Tope()) {
				colaDestino.Desacolar();
				pila.Desapilar();
			}else {
				System.out.print("No es capicua");
				return;
			}
		}
	}	
}
