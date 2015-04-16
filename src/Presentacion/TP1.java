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
		opciones.add(5);
		for (int i = 0; i < opciones.size(); i++) {
			this.cbCantidadFrases.addItem(opciones.get(i));
		}
	}
	
	private void bindcbComplejidadGramatical() {
		ArrayList<Integer> opciones = new ArrayList<Integer>();
		opciones.add(1);
		opciones.add(2);
		opciones.add(3);
		opciones.add(4);
		this.cbComplejidadGramatical.removeAllItems();
		for (int i = 0; i < opciones.size(); i++) {
			this.cbComplejidadGramatical.addItem(opciones.get(i));
		}
	}
	
	private void bindcbNivelAgresividad() {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Bajo");
		opciones.add("Medio");
		opciones.add("Alto");
		this.cbNivelAgresividad.removeAllItems();
		for (int i = 0; i < opciones.size(); i++) {
			this.cbNivelAgresividad.addItem(opciones.get(i));
		}
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
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
		lblTema.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTema.setBounds(10, 71, 99, 14);
		frame.getContentPane().add(lblTema);
		cbTema.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbTema.setBounds(124, 68, 74, 20);
		frame.getContentPane().add(cbTema);
		cbCantidadFrases.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbCantidadFrases.setBounds(124, 100, 74, 20);
		frame.getContentPane().add(cbCantidadFrases);

		JLabel lblCantidadDeFrases = new JLabel("Cantidad de frases:");
		lblCantidadDeFrases.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCantidadDeFrases.setBounds(10, 103, 99, 14);
		frame.getContentPane().add(lblCantidadDeFrases);

		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblMensaje.setText("");
				ArrayList<Frase> frases = new ArrayList<Frase>();
				int cantidad = Integer.parseInt(cbCantidadFrases
						.getSelectedItem().toString());
				for (int i = 0; i < cantidad; i++) {
					Frase frase = null;
					try {
						frase = new Frase((TemaFrase) cbTema.getSelectedItem(), obtenerComplejidad(), obtenerAgresividad());

					} catch (Exception e) {
						lblMensaje
								.setText(e.toString());
					}
					frases.add(frase);
				}

				mostrarFrases(frases);
				btnGuardar.setVisible(true);
			}

			private int obtenerAgresividad() {
				int agresividad;
				try
				{
					agresividad = Integer.parseInt(cbNivelAgresividad.getSelectedItem().toString());
				}
				catch (Exception e)
				{
					agresividad = -1;
				}
				return agresividad;
			}

			private String obtenerComplejidad() {
				String complejidad = "";
				try
				{
					complejidad = cbComplejidadGramatical.getSelectedItem().toString();
				}
				catch (Exception e)
				{
					// No se puede convertir
				}
				return complejidad;
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
		lblNivelDeAgresividad.setFont(new Font("Tahoma", Font.PLAIN, 11));

		lblNivelDeAgresividad.setBounds(251, 71, 137, 14);
		frame.getContentPane().add(lblNivelDeAgresividad);
		lblNivelDeAgresividad.setVisible(false);
		cbNivelAgresividad.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbNivelAgresividad.setBounds(383, 68, 63, 20);
		frame.getContentPane().add(cbNivelAgresividad);
		cbNivelAgresividad.setVisible(false);
		lblComplejidadGramatical.setFont(new Font("Tahoma", Font.PLAIN, 11));

		lblComplejidadGramatical.setBounds(251, 102, 122, 17);
		frame.getContentPane().add(lblComplejidadGramatical);
		lblComplejidadGramatical.setVisible(false);
		cbComplejidadGramatical.setFont(new Font("Tahoma", Font.PLAIN, 11));

		cbComplejidadGramatical.setBounds(383, 100, 63, 20);
		frame.getContentPane().add(cbComplejidadGramatical);
		cbComplejidadGramatical.setVisible(false);
		btnMostrarOpcionesAvanzadas.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnMostrarOpcionesAvanzadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnMostrarOpcionesAvanzadas.getText() == "Mostrar opciones avanzadas") {
					btnMostrarOpcionesAvanzadas
							.setText("Ocultar opciones avanzadas");
					lblNivelDeAgresividad.setVisible(true);
					lblComplejidadGramatical.setVisible(true);
					cbNivelAgresividad.setVisible(true);
					bindcbNivelAgresividad();
					cbComplejidadGramatical.setVisible(true);
					bindcbComplejidadGramatical();
				} else {
					btnMostrarOpcionesAvanzadas
							.setText("Mostrar opciones avanzadas");
					lblNivelDeAgresividad.setVisible(false);
					lblComplejidadGramatical.setVisible(false);
					cbNivelAgresividad.setVisible(false);
					cbNivelAgresividad.removeAllItems();
					cbComplejidadGramatical.setVisible(false);
					cbComplejidadGramatical.removeAllItems();
				}

			}
		});
		btnMostrarOpcionesAvanzadas.setBounds(20, 131, 188, 23);
		frame.getContentPane().add(btnMostrarOpcionesAvanzadas);

		lblFrases.setBounds(265, 128, 234, 133);
		frame.getContentPane().add(lblFrases);
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				 {
				  JFileChooser file=new JFileChooser();
				  file.showSaveDialog(null);
				  File guarda =file.getSelectedFile();
				  if(guarda !=null)
				  {
				    FileWriter  save=new FileWriter(guarda+".html");
					save.write(lblFrases.getText());
				    save.close();
				    lblMensaje.setText("Frases guardadas en: " + guarda + ".html");
				    }
				 }
				  catch(IOException ex)
				  {
					  lblMensaje.setText("No han podido guardar las frases");
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
