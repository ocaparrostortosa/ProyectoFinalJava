package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase Singlenton que nos crea la conexión a la base de datos y 
 * nos implementa el JDBC de sqlite3 en el proyecto.
 * 
 * @author Oscar Caparros
 *
 */
public class Conexion {
	private static Connection conexion = null;
	
	private Conexion(){
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:BD/cuentas.bd");
		} catch (SQLException e) {
			System.out.println("Problema en la conexion a la base de datos.");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC no encontrado.");
		}
	}
	
	/**
	 *  Único método público que nos permite obtener la instancia de la
	 *  conexión a la base de datos.
	 *  
	 * @return Connection
	 */
	public static Connection getInstance(){
		if(conexion == null)
			new Conexion();
		return conexion;
	}
	/**
	public static void main(String[] args) {
		Connection conexion = new Conexion().getInstance();
		System.out.println(conexion);
	}
	*/
}
