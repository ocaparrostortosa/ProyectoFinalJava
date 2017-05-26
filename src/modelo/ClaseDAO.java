package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Clase que implementa métodos de la interfaz denominada 'InterfazDAO' que nos 
 * permite interactuar con la base de datos y crear futuras acciones para la vista.
 * 
 * @author Oscar Caparros
 *
 */
public class ClaseDAO implements InterfazDAO {
	
	private Connection conexion = Conexion.getInstance();
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private String sql = "";

	//Sobreescribimos el método implementado de la interfaz para obtener todas las cuentas disponibles.
	@Override
	public int obtenerCuentasDisponibles() {
		int cuentasDisponibles = 0;
		//select count(*) from cuenta;
		sql = "SELECT COUNT(saldo) FROM cuenta";
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);
			cuentasDisponibles = resultSet.getInt(1);
			
		} catch (SQLException e) {
			System.out.println("Error a la hora de obtener las cuentas disponibles.");;
		}
		
		return cuentasDisponibles;
	}

	//Sobreescribimos el método implementado de la interfaz para obtener el saldo medio.
	@Override
	public double obtenerSaldoMedio() {
		double saldoMedio = 0;
		//select avg(saldo) from cuenta;
		sql = "SELECT AVG(saldo) FROM cuenta";
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);
			saldoMedio = resultSet.getDouble(1);
		} catch (SQLException e) {
			System.out.println("Error al obtener el saldo medio.");
		}
		
		return saldoMedio;
	}
	
	//Sobreescribimos el método implementado de la interfaz para borrar las cuentas con salario igual a 0.
	@Override
	public int borrarCuentasACero() {
		int contador = 0;
		//delete from cuenta where saldo=0;
		sql = "DELETE FROM cuenta WHERE saldo=0;";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			contador = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al eliminar las cuentas a cero.");
		}
		return contador;
	}

	//Sobreescribimos el método implementado de la interfaz para al arrancar establecer un texto en el text area.
	@Override
	public String arrancarTextArea() {
		String contenidoTextArea = "";
		
		contenidoTextArea += "Nº cuentas disponibles: " + obtenerCuentasDisponibles() + "\n";
		contenidoTextArea += "Saldo medio: " + obtenerSaldoMedio() + "\n";
		
		return contenidoTextArea;
	}

	//Sobreescribimos el método implementado de la interfaz para obtener todas las cuentas con salario menor a 1000.
	@Override
	public String obtenerSaldosPeques() {
		String saldosPeques = "";
		sql = "SELECT * FROM cuenta WHERE saldo<1000;";
		try {
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()){
				saldosPeques += resultSet.getString(1) + ";";
				saldosPeques += resultSet.getString(2) + ";";
				saldosPeques += resultSet.getString(3) + "\n";
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener los saldos pequeños.");
		}
		
		return saldosPeques;
	}
	
	/**
	public static void main(String[] args) {
		//System.out.println(new ClaseDAO().obtenerCuentasDisponibles());
		//System.out.println(new ClaseDAO().obtenerSaldoMedio());
		//System.out.println(new ClaseDAO().borrarCuentasACero());
		//System.out.println(new ClaseDAO().arrancarTextArea());
		System.out.println(new ClaseDAO().obtenerSaldosPeques());
	}
	*/


}
