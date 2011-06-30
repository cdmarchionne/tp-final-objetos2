package gui;

import gui.abstractGui.AbstractGUIFrame;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.interfaces.AlumnoIMPL;
import model.interfaces.CatedraIMPL;
import model.interfaces.MateriaIMPL;
import model.interfaces.UniversidadIMPL;
import universidad.Universidad;

public class InscribirAlumnoFrame extends AbstractGUIFrame {
	private static final long serialVersionUID = 1L;

	private JList listaAlumnos, listaMaterias, listaCatedras;

	public InscribirAlumnoFrame(JFrame frame) {
		super(frame);
	}

	@Override
	protected void init() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel.add(this.mkListaAlumnos());
		panel.add(this.mkListaMaterias());
		panel.add(this.mkListaCatedras());

		this.getPanel().add(panel);
		this.getPanel().add(this.mkBotonInscribir());
	}

	private JButton mkBotonInscribir() {
		JButton botonInscribir = new JButton("Inscribir");

		botonInscribir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CatedraIMPL catedra = (CatedraIMPL) InscribirAlumnoFrame.this.getListaCatedras()
						.getSelectedValue();
				AlumnoIMPL alumno = (AlumnoIMPL) InscribirAlumnoFrame.this.getListaAlumnos()
						.getSelectedValue();
				Universidad.getInstance().inscribirAlumno(alumno, catedra);

				InscribirAlumnoFrame.this.actualizar();
			}
		});

		return botonInscribir;
	}

	protected void actualizar() {
		this.actualizarListaMaterias();
		this.resetearListaCatedras();
	}

	protected void resetearListaCatedras() {
		this.getListaCatedras().setListData(new Vector<CatedraIMPL>());
	}

	/**
	 * actualiza la lista de materias segun la seleccion de la lista de alumnos
	 */
	protected void actualizarListaMaterias() {
		Universidad universidad = Universidad.getInstance();
		AlumnoIMPL alumno = (AlumnoIMPL) this.getListaAlumnos().getSelectedValue();
		this.getListaMaterias().setListData(
				new Vector<MateriaIMPL>(universidad.materiasInscribibles(alumno)));
	}

	private Component mkListaCatedras() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Catedras"));

		JList listaCatedras = new JList();
		// listaCatedras.setSize(new Dimension(100, 50));
		listaCatedras.setPreferredSize(new Dimension(100, 150));
		this.setListaCatedras(listaCatedras);

		panel.add(new JScrollPane(this.getListaCatedras()));

		return panel;
	}

	/**
	 * lista de las materias. Cada vez que se hace una seleccion, se actualizan
	 * las catedras disponibles
	 */
	private JComponent mkListaMaterias() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Materias"));

		JList listaMaterias = new JList();
		// listaMaterias.setSize(new Dimension(100, 50));
		listaMaterias.setPreferredSize(new Dimension(100, 150));
		//
		listaMaterias.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!(InscribirAlumnoFrame.this.getListaMaterias().getSelectedValue() == null)) {
					InscribirAlumnoFrame.this.actualizarListaCatedras();
				}
			}
		});

		this.setListaMaterias(listaMaterias);

		panel.add(new JScrollPane(listaMaterias));
		return panel;
	}

	protected void actualizarListaCatedras() {
		MateriaIMPL materia = (MateriaIMPL) this.getListaMaterias().getSelectedValue();
		this.getListaCatedras().setListData(new Vector<CatedraIMPL>(materia.getCatedras()));
	}

	/**
	 * lista de alumnos. Cada vez que se hace una seleccion, se actualizan las
	 * materias disponibles
	 * (las catedras se resetean)
	 */
	private JComponent mkListaAlumnos() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Alumnos"));

		UniversidadIMPL universidad = Universidad.getInstance();
		Vector<AlumnoIMPL> alumnos = new Vector<AlumnoIMPL>(universidad.getAlumnos()); // por
																						// si
																						// devuelven
																						// ArrayList

		JList listaAlumnos = new JList(alumnos);
		// listaAlumnos.setSize(new Dimension(100, 50));
		listaAlumnos.setPreferredSize(new Dimension(100, 150));

		listaAlumnos.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				InscribirAlumnoFrame.this.actualizar();
			}
		});

		this.setListaAlumnos(listaAlumnos);

		panel.add(new JScrollPane(listaAlumnos));
		return panel;
	}

	/**
	 * selecciona un alumno de la lista. Sirve para la ejecucion desde el frame
	 * de alumnos
	 */
	public void seleccionarAlumno(AlumnoIMPL alumno) {
		this.getListaAlumnos().setSelectedValue(alumno, true);
	}

	// setters&getters
	private void setListaAlumnos(JList alumnos) {
		listaAlumnos = alumnos;
	}

	public JList getListaAlumnos() {
		return listaAlumnos;
	}

	private void setListaMaterias(JList materias) {
		listaMaterias = materias;
	}

	public JList getListaMaterias() {
		return listaMaterias;
	}

	private void setListaCatedras(JList catedras) {
		listaCatedras = catedras;
	}

	public JList getListaCatedras() {
		return listaCatedras;
	}
}
