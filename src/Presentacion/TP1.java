package Presentacion;
import java.awt.EventQueue;
import java.awt.List;

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

	ArrayList<JLabel> listaLabels = new ArrayList<JLabel>();
	JLabel lblNewLabel_1 = new JLabel("");
	JLabel lblNewLabel_2 = new JLabel("");
	JLabel lblNewLabel_3 = new JLabel("");
	JLabel lblNewLabel_4 = new JLabel("");
	JLabel lblNewLabel_5 = new JLabel("");
	

	JButton btnGuardar = new JButton("Guardar");

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


		listaLabels.add(lblNewLabel_1);
		listaLabels.add(lblNewLabel_2);
		listaLabels.add(lblNewLabel_3);
		listaLabels.add(lblNewLabel_4);
		listaLabels.add(lblNewLabel_5);
		
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
					Frase frase;
					try {
						frase = new Frase((TemaFrase) cbTema
								.getSelectedItem());
						frases.add(frase);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				mostrarFrases(frases);
				btnGuardar.setVisible(true);
			}

			private void mostrarFrases(ArrayList<Frase> frases) {
				for (int i = 0; i < frases.size(); i++) {
					// CORREGIR!
					int contador = 0;
					while ((listaLabels.get(contador).getText() == "") && contador<listaLabels.size()){
						listaLabels.get(contador).setText(frases.get(i).toString());
					}
					contador ++ ;
				
				}
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

		lblNewLabel_1.setBounds(265, 177, 176, 19);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2.setBounds(265, 199, 176, 14);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3.setBounds(265, 224, 176, 14);
		frame.getContentPane().add(lblNewLabel_3);

		lblNewLabel_4.setBounds(265, 249, 176, 14);
		frame.getContentPane().add(lblNewLabel_4);

		lblNewLabel_5.setBounds(265, 274, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String ruta = "C:/frases.txt";
				File archivo = new File(ruta);
				BufferedWriter bw;
				try {
					bw = new BufferedWriter(new FileWriter(archivo));
					for (int i = 0 ; i < Integer.parseInt(cbCantidadFrases
							.getSelectedItem().toString()) ; i ++)
					{
						bw.write(lblNewLabel_1.getText());
						bw.newLine();
					}
					
					
					bw.close();
				} catch (IOException e) {
					
					// Exception

				}
			}
		});

		btnGuardar.setBounds(410, 287, 89, 23);
		frame.getContentPane().add(btnGuardar);
		btnGuardar.setVisible(false);
	}
}
