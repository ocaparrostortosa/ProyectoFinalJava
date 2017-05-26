package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

import modelo.ClaseDAO;
import vista.Vista;
/**
 * Clase principal controlador que como su nombre indica se dedica
 * a las tareas principales entre la vista y el modelo y controla la aplicación.
 * 
 * @author Oscar Caparros
 *
 */
public class Controlador implements ActionListener {

	private Vista vista;
	private ClaseDAO claseDao;
	private String contenidoTextArea = "";
	
	/**
	 * Controlador.
	 */
	public Controlador(Vista vista, ClaseDAO claseDao) {
		super();
		this.vista = vista;
		this.claseDao = claseDao;
		actionListener(this);
		accionIniciarAplicacion();
	}

	/**
	 * Sobreescribimos el actionPerfomed.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String contenido = e.getActionCommand();
		vista.getTxtrTextarea().setText("");
		switch (contenido) {
		case "Saldos pequeños":
			accionSaldosPeques();
			break;
		case "Borrar cuentas":
			accionBorrarCuentas();
			break;
		case "About":
			accionAbout();
			break;
		case "Informacion":
			accionInformacion();
			break;
		case "Salir":
			accionSalir();
			break;
		default:
			break;
		}
	}
	
	/**
	 * Creando el metodo actionListener.
	 */
	public void actionListener(ActionListener escuchador){
		vista.getBtnBorrarCuentas().addActionListener(escuchador);
		vista.getBtnSaldosPeques().addActionListener(escuchador);
		vista.getBtnSalir().addActionListener(escuchador);
		vista.getMnAbout().addActionListener(escuchador);
		vista.getMntmInformacion().addActionListener(escuchador);
	}
	
	/**
	 * Creamos distintos métodos que se encargarán de las funciones
	 * realizadas por los botones. Esto lo hacemos para separar el código y que 
	 * sea más legible.
	 */
	
	//Accion al iniciarse la aplicación
	public void accionIniciarAplicacion(){
		contenidoTextArea = claseDao.arrancarTextArea();
		vista.getTxtrTextarea().setText(contenidoTextArea);
	}
	
	//Accion para el botón Salarios pequeños
	public void accionSaldosPeques(){
		contenidoTextArea = claseDao.obtenerSaldosPeques();
		vista.getTxtrTextarea().setText(contenidoTextArea);
	}
	
	//Accion para el botón Borrar cuentas
	public void accionBorrarCuentas(){
		int contador = claseDao.borrarCuentasACero();
		vista.getTxtrTextarea().setText("Numero de cuentas con 'salario=0' borradas: (" + contador + ").");
	}
	
	//Accion para el menú About (en este caso vacío).
	public void accionAbout(){
		
	}
	
	//Accion para la opción del menú 'About/Informacion'
	public void accionInformacion(){
		String titulo = "Fecha y hora actual:";
		String contenido = LocalDate.now() + "\n" + LocalDateTime.now().getHour() + ":" + 
				LocalDateTime.now().getMinute() + "'" + 
				LocalDateTime.now().getSecond();
		new JOptionPane();
		JOptionPane.showMessageDialog(null, contenido, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	//Accion para el botón Salir
	public void accionSalir(){
		FileOutputStream out;		
		String adicional = claseDao.arrancarTextArea() + "\t" + LocalDate.now() + "\n";
		try {
			out = new FileOutputStream(new File("LOGS/logs.txt"), true);
			PrintWriter pw = new PrintWriter(out);
			pw.flush();
			pw.write(adicional);
			pw.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichero no encontrado logst.txt");
		}
		System.exit(0);
	}
	
	/**
	public static void main(String[] args) {		
		
	}
	*/

}
