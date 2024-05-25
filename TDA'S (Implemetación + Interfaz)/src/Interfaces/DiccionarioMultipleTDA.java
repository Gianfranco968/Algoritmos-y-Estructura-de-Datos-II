package Interfaces;

public interface DiccionarioMultipleTDA {

	public void InicializarDiccionario();
	public void Agregar(int clave, int valor);
	public void Eliminar(int clave);
	public void EliminarValor(int clave, int valor);
	ConjuntoTDA Recuperar(int clave);
	ConjuntoTDA Claves();
}
