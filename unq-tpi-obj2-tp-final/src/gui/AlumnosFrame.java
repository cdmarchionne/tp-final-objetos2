package gui;

import gui.abstractGui.AbstractGUIFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.interfaces.AlumnoIMPL;
import model.interfaces.UniversidadIMPL;
import universidad.Universidad;

public class AlumnosFrame extends AbstractGUIFrame {
	private static final long serialVersionUID = 1L;
	private JList listaAlumnos;

	public AlumnosFrame(JFrame frame) {
		super(frame);
	}

	@Override
	protected void init() {
		this.getPanel().setLayout(new BoxLayout(this.getPanel(), BoxLayout.Y_AXIS));

		JPanel alumnosPanel = new JPanel();
		alumnosPanel.setLayout(new FlowLayout());

		alumnosPanel.add(this.mkListaAlumnos());
		alumnosPanel.add(this.mkBotonesAlumnos());

		this.getPanel().add(alumnosPanel);
	}

	/**
	 * Crea un panel con los botones Analitico, Inscribir, Coeficiente
	 */
	private JPanel mkBotonesAlumnos() {
		JPanel botonesAlumnos = new JPanel();
		botonesAlumnos.setLayout(new BoxLayout(botonesAlumnos, BoxLayout.Y_AXIS));

		botonesAlumnos.add(this.mkBotonAnalitico());
		botonesAlumnos.add(this.mkBotonInscribir());
		botonesAlumnos.add(this.mkBotonCoeficiente());

		return botonesAlumnos;
	}

	/**
	 * Boton que al ser presionado me crea la ventana de coeficiente del alumno
	 */
	private JButton mkBotonCoeficiente() {
		JButton botonCoeficiente = new JButton("Coeficiente");

		botonCoeficiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AlumnosFrame.this.setVisible(false);
				new CoeficienteFrame(AlumnosFrame.this, (AlumnoIMPL) AlumnosFrame.this
						.getListaAlumnos().getSelectedValue());
			}
		});

		return botonCoeficiente;
	}

	/**
	 * Boton que al ser presionado me crea la ventana de inscripcion de alumnos
	 * con el alumno seleccionado
	 */
	private JButton mkBotonInscribir() {
		JButton botonInscribir = new JButton("Inscribir Alumno");

		botonInscribir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AlumnosFrame.this.setVisible(false);
				InscribirAlumnoFrame response = new InscribirAlumnoFrame(AlumnosFrame.this);
				response.seleccionarAlumno((AlumnoIMPL) AlumnosFrame.this.getListaAlumnos()
						.getSelectedValue());
			}
		});

		return botonInscribir;
	}

	/**
	 * Boton que al ser presionado me crea una ventana de analiticos
	 */
	private JButton mkBotonAnalitico() {
		JButton botonAnalitico = new JButton("Ver Analitico");

		botonAnalitico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AlumnosFrame.this.setVisible(false);
				new AnaliticoFrame(AlumnosFrame.this, (AlumnoIMPL) AlumnosFrame.this
						.getListaAlumnos().getSelectedValue());
			}
		});

		return botonAnalitico;
	}

	/**
	 * Crea la lista de alumnos y la setea como variable de instancia
	 */
	private JScrollPane mkListaAlumnos() {
		UniversidadIMPL universidad = Universidad.getInstance();
		Vector<AlumnoIMPL> alumnos = new Vector<AlumnoIMPL>(universidad.getAlumnos()); // por
																						// si
																						// devuelven
																						// ArrayList

		JList listaDeAlumnos = new JList(alumnos);
		// listaAlumnos.setSize(new Dimension(100, 50));
		listaDeAlumnos.setPreferredSize(new Dimension(100, 150));
		this.setListaAlumnos(listaDeAlumnos);

		return new JScrollPane(listaDeAlumnos);
	}

	// setters&getters
	protected void setListaAlumnos(JList listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}

	protected JList getListaAlumnos() {
		return listaAlumnos;
	}
}
