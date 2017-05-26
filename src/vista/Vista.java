package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import controlador.Controlador;
import modelo.ClaseDAO;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
/**
 * Interfaz gráfica de la aplicación que dota de 3 botones que interactuan con el modelo y
 * el controlador a parte de un menú con una opción que nos muestra la hora y fecha actual a parte
 * de tener un textArea que nos muestra información que procede de los botones.
 * 
 * @author Oscar Caparros
 *
 */
@SuppressWarnings("serial")
public class Vista extends JFrame {

	private JPanel contentPane;
	private JButton btnSalir;
	private JButton btnBorrarCuentas;
	private JButton btnSaldosPeques;
	private JTextArea txtrTextarea;
	private JMenuItem mntmInformacion;
	private JMenu mnAbout;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					new Controlador(frame, new ClaseDAO());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor.
	 */
	public Vista() {
		inicializar();
	}
	/**
	 * Creando el frame.
	 */
	public void inicializar(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 303);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		mntmInformacion = new JMenuItem("Informacion");
		mnAbout.add(mntmInformacion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
		);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.1);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
					.addGap(23))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addGap(17))
		);
		
		JPanel panel_Izquierdo = new JPanel();
		splitPane.setLeftComponent(panel_Izquierdo);
		GridBagLayout gbl_panel_Izquierdo = new GridBagLayout();
		gbl_panel_Izquierdo.columnWidths = new int[]{157, 0};
		gbl_panel_Izquierdo.rowHeights = new int[]{25, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_Izquierdo.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_Izquierdo.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_Izquierdo.setLayout(gbl_panel_Izquierdo);
		
		btnSaldosPeques = new JButton("Saldos pequeños");
		GridBagConstraints gbc_btnSaldosPeques = new GridBagConstraints();
		gbc_btnSaldosPeques.insets = new Insets(0, 0, 5, 0);
		gbc_btnSaldosPeques.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSaldosPeques.gridx = 0;
		gbc_btnSaldosPeques.gridy = 0;
		panel_Izquierdo.add(btnSaldosPeques, gbc_btnSaldosPeques);
		
		btnBorrarCuentas = new JButton("Borrar cuentas");
		GridBagConstraints gbc_btnBorrarCuentas = new GridBagConstraints();
		gbc_btnBorrarCuentas.insets = new Insets(0, 0, 5, 0);
		gbc_btnBorrarCuentas.gridx = 0;
		gbc_btnBorrarCuentas.gridy = 2;
		panel_Izquierdo.add(btnBorrarCuentas, gbc_btnBorrarCuentas);
		
		btnSalir = new JButton("Salir");
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.gridx = 0;
		gbc_btnSalir.gridy = 6;
		panel_Izquierdo.add(btnSalir, gbc_btnSalir);
		
		JPanel panel_Derecho = new JPanel();
		splitPane.setRightComponent(panel_Derecho);
		panel_Derecho.setLayout(new GridLayout(0, 1, 0, 0));
		
		scrollPane = new JScrollPane();
		panel_Derecho.add(scrollPane);
		
		txtrTextarea = new JTextArea();
		scrollPane.setViewportView(txtrTextarea);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * Creando los getters necesarios.
	 */
	public JTextArea getTxtrTextarea() {
		return txtrTextarea;
	}

	public JMenuItem getMntmInformacion() {
		return mntmInformacion;
	}

	public JMenu getMnAbout() {
		return mnAbout;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JButton getBtnBorrarCuentas() {
		return btnBorrarCuentas;
	}

	public JButton getBtnSaldosPeques() {
		return btnSaldosPeques;
	}

}
