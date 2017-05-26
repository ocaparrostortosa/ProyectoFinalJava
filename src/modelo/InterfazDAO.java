package modelo;
/**
 * Interfaz creada para el modelo vista controlador donde la clase denominada
 * 'ClaseDAO' implementará los métodos para posteriormente sobreescribirlos y usarlos.
 * 
 * @author Oscar Caparros
 *
 */
public interface InterfazDAO {
	int obtenerCuentasDisponibles();
	double obtenerSaldoMedio();
	int borrarCuentasACero();
	String obtenerSaldosPeques();
	String arrancarTextArea();
}
