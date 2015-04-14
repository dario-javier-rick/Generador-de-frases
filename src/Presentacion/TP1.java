package Presentacion;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import Logica.Frase;
import Logica.TemaFrase;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TP1 {

	private JFrame frame;

	JComboBox cbCantidadFrases = new JComboBox();
	JComboBox cbTema = new JComboBox();

	JButton btnMostrarOpcionesAvanzadas = new JButton(
			"Mostrar opciones avanzadas");
	JLabel lblNivelDeAgresividad = new JLabel("Nivel de agresividad:");
	JLabel lblComplejidadGramatical = new JLabel("Complejidad gramatical:");
	JComboBox cbComplejidadGramatical = new JComboBox();
	JComboBox cbNivelAgresividad = new JComboBox();

	JLabel lblFrases = new JLabel("");

	JButton btnGuardar = new JButton("Guardar");
	JLabel lblMensaje = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TP1 window = new TP1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TP1() {
		initialize();
	}

	private void bindcbTema() {
		ArrayList<TemaFrase> temas = new ArrayList<TemaFrase>();
		temas.add(TemaFrase.Amistad);
		temas.add(TemaFrase.Amor);
		temas.add(TemaFrase.Salud);
		for (int i = 0; i < temas.size(); i++) {
			this.cbTema.addItem(temas.get(i));
		}
	}

	private void bindcbCantidadFrases() {
		ArrayList<Integer> opciones = new ArrayList<Integer>();
		opciones.add(1);
		opciones.add(2);
		opciones.add(3);
		opciones.add(4);
		for (int i = 0; i < opciones.size(); i++) {
			this.cbCantidadFrases.addItem(opciones.get(i));
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(100, 100, 525, 359);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		bindcbTema();
		bindcbCantidadFrases();

		JLabel lblNewLabel = new JLabel("Generador autom\u00E1tico de frases");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(68, 11, 353, 35);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblTema = new JLabel("Tema:");
		lblTema.setBounds(10, 71, 46, 14);
		frame.getContentPane().add(lblTema);

		cbTema.setBounds(124, 68, 74, 20);
		frame.getContentPane().add(cbTema);

		cbCantidadFrases.setBounds(124, 100, 74, 20);
		frame.getContentPane().add(cbCantidadFrases);

		JLabel lblCantidadDeFrases = new JLabel("Cantidad de frases:");
		lblCantidadDeFrases.setBounds(10, 103, 101, 14);
		frame.getContentPane().add(lblCantidadDeFrases);

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Frase> frases = new ArrayList<Frase>();
				int cantidad = Integer.parseInt(cbCantidadFrases
						.getSelectedItem().toString());
				for (int i = 0; i < cantidad; i++) {
					Frase frase = null;
					try {
						frase = new Frase((TemaFrase) cbTema.getSelectedItem());

					} catch (IOException e) {
						lblMensaje
								.setText("No se ha podido generar las frases");
					}
					frases.add(frase);
				}

				mostrarFrases(frases);
				btnGuardar.setVisible(true);
			}

			private void mostrarFrases(ArrayList<Frase> frases) {
				String texto = "<html>";
				for (int i = 0; i < frases.size(); i++) {
					texto = texto + frases.get(i) + "<br>";
				}
				lblFrases.setText(texto);
			}
		});

		btnGenerar.setBounds(68, 173, 89, 23);
		frame.getContentPane().add(btnGenerar);

		lblNivelDeAgresividad.setBounds(265, 71, 106, 14);
		frame.getContentPane().add(lblNivelDeAgresividad);
		lblNivelDeAgresividad.setVisible(false);

		cbNivelAgresividad.setBounds(413, 68, 28, 20);
		frame.getContentPane().add(cbNivelAgresividad);
		cbNivelAgresividad.setVisible(false);

		lblComplejidadGramatical.setBounds(265, 103, 123, 14);
		frame.getContentPane().add(lblComplejidadGramatical);
		lblComplejidadGramatical.setVisible(false);

		cbComplejidadGramatical.setBounds(413, 100, 28, 20);
		frame.getContentPane().add(cbComplejidadGramatical);
		cbComplejidadGramatical.setVisible(false);

		btnMostrarOpcionesAvanzadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnMostrarOpcionesAvanzadas.getText() == "Mostrar opciones avanzadas") {
					btnMostrarOpcionesAvanzadas
							.setText("Ocultar opciones avanzadas");
					lblNivelDeAgresividad.setVisible(true);
					lblComplejidadGramatical.setVisible(true);
					cbNivelAgresividad.setVisible(true);
					cbComplejidadGramatical.setVisible(true);
				} else {
					btnMostrarOpcionesAvanzadas
							.setText("Mostrar opciones avanzadas");
					lblNivelDeAgresividad.setVisible(false);
					lblComplejidadGramatical.setVisible(false);
					cbNivelAgresividad.setVisible(false);
					cbComplejidadGramatical.setVisible(false);
				}

			}
		});
		btnMostrarOpcionesAvanzadas.setBounds(20, 131, 188, 23);
		frame.getContentPane().add(btnMostrarOpcionesAvanzadas);

		lblFrases.setBounds(265, 128, 234, 133);
		frame.getContentPane().add(lblFrases);

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				// Titulo que llevara la ventana
				chooser.setDialogTitle("Titulo");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					System.out.println("Directorio: "
							+ chooser.getCurrentDirectory());

					String ruta = chooser.getCurrentDirectory().toString()
							+ "/" + "frases.txt";
					File archivo = new File(ruta);
					BufferedWriter bw;
					try {
						bw = new BufferedWriter(new FileWriter(archivo));
						for (int i = 0; i < Integer.parseInt(cbCantidadFrases
								.getSelectedItem().toString()); i++) {
							bw.write(lblFrases.getText());
							bw.newLine();
						}
						bw.close();
						lblMensaje.setText("Frases guardadas en " + ruta);
					} catch (IOException e) {
						// Exception
					}

				} else {
					lblMensaje.setText("No ha seleccionado el directorio");
				}
			}
		});

		btnGuardar.setBounds(20, 238, 89, 23);
		frame.getContentPane().add(btnGuardar);

		lblMensaje.setBounds(20, 272, 426, 38);
		frame.getContentPane().add(lblMensaje);
		btnGuardar.setVisible(false);
	}
}
