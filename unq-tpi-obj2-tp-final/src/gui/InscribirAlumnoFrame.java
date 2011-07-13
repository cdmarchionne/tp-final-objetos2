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
import model.interfaces.PlanDeEstudioIMPL;
import model.interfaces.UniversidadIMPL;
import universidad.Universidad;

public class InscribirAlumnoFrame extends AbstractGUIFrame {
	private static final long serialVersionUID = 1L;

	private JList listaAlumnos, listaPlanes, listaMaterias, listaCatedras;

	public InscribirAlumnoFrame(JFrame frame) {
		super(frame);
	}

	@Override
	protected void init() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel.add(this.mkListaAlumnos());
		panel.add(this.mkListaPlanes());
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
				AlumnoIMPL alumno = (AlumnoIMPL) InscribirAlumnoFrame.this.getListaAlumnos()
						.getSelectedValue();
				PlanDeEstudioIMPL plan = (PlanDeEstudioIMPL) InscribirAlumnoFrame.this
						.getListaPlanes().getSelectedValue();
				MateriaIMPL materia = (MateriaIMPL) InscribirAlumnoFrame.this.getListaMaterias()
						.getSelectedValue();
				CatedraIMPL catedra = (CatedraIMPL) InscribirAlumnoFrame.this.getListaCatedras()
						.getSelectedValue();

				if ((alumno != null) && (plan != null) && (materia != null) && (catedra != null)) {
					Universidad.getInstance().inscribirAlumno(alumno, catedra, materia, plan);
					InscribirAlumnoFrame.this.actualizarListaPlanes();
				} else {
					String datos = "El alumno " + alumno + " esta inscripto en el plan de estudio "
							+ plan + " y se quiere inscribir a la materia " + materia
							+ " en la catedra " + catedra;
					String mensajeError = "Debe seleccionar a un Alumno y una Catedra para poder realizar la Inscripcion";

					System.err.println(datos + "\n");
					System.err.println("\nAlumno\t'" + alumno + "'\nPlan\t'" + plan
							+ "'\nMateria\t'" + materia + "'\nCatedra\t'" + catedra + "'\n");
					System.err.println(mensajeError + "\n");
				}

			}
		});

		return botonInscribir;
	}

	// protected void actualizar() {
	// this.resetearListaCatedras();
	// this.resetearListaMaterias();
	// this.actualizarListaPlanes();
	// }

	protected void resetearListaPlanes() {
		this.getListaPlanes().setListData(new Vector<PlanDeEstudioIMPL>());
	}

	protected void resetearListaMaterias() {
		this.getListaMaterias().setListData(new Vector<MateriaIMPL>());
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
		PlanDeEstudioIMPL plan = (PlanDeEstudioIMPL) this.getListaPlanes().getSelectedValue();

		// Si hay seleccionado un Plan tambien hay seleccionado un alumno
		if (plan == null) {
			this.resetearListaMaterias();
		} else {
			this.getListaMaterias().setListData(
					new Vector<MateriaIMPL>(universidad.materiasInscribibles(alumno, plan)));

			this.actualizarListaCatedras();
		}
	}

	private Component mkListaCatedras() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Catedras"));

		JList listaDeCatedra = new JList();
		// listaDeCatedra.setSize(new Dimension(100, 50));
		listaDeCatedra.setPreferredSize(new Dimension(100, 150));
		this.setListaCatedras(listaDeCatedra);

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

		JList listaDeMaterias = new JList();
		// listaDeMaterias.setSize(new Dimension(100, 50));
		listaDeMaterias.setPreferredSize(new Dimension(100, 150));
		//
		listaDeMaterias.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if (!(InscribirAlumnoFrame.this.getListaMaterias().getSelectedValue() == null)) {
					InscribirAlumnoFrame.this.actualizarListaCatedras();
				}
			}
		});

		this.setListaMaterias(listaDeMaterias);

		panel.add(new JScrollPane(listaDeMaterias));
		return panel;
	}

	protected void actualizarListaCatedras() {
		MateriaIMPL materia = (MateriaIMPL) this.getListaMaterias().getSelectedValue();
		if (materia == null) {
			this.resetearListaCatedras();
		} else {
			this.getListaCatedras().setListData(new Vector<CatedraIMPL>(materia.getCatedras()));
		}
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
		JList listaDeAlumnos = new JList(alumnos);
		// listaDeAlumnos.setSize(new Dimension(100, 50));
		listaDeAlumnos.setPreferredSize(new Dimension(100, 150));

		listaDeAlumnos.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				InscribirAlumnoFrame.this.actualizarListaPlanes();
			}
		});

		this.setListaAlumnos(listaDeAlumnos);

		panel.add(new JScrollPane(listaDeAlumnos));
		return panel;
	}

	/**
	 * Crea la lista de Planes de Estudio del Alumno
	 */
	private JComponent mkListaPlanes() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Planes de Estudio"));

		JList listaDePlanes = new JList();
		// listaDePlanes.setSize(new Dimension(100, 50));
		listaDePlanes.setPreferredSize(new Dimension(100, 150));

		listaDePlanes.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				InscribirAlumnoFrame.this.actualizarListaMaterias();
			}
		});

		this.setListaPlanes(listaDePlanes);
		panel.add(new JScrollPane(listaDePlanes));
		return panel;
	}

	protected void actualizarListaPlanes() {
		AlumnoIMPL alumno = (AlumnoIMPL) InscribirAlumnoFrame.this.getListaAlumnos()
				.getSelectedValue();

		if (alumno == null) {
			this.resetearListaPlanes();
		} else {
			Vector<PlanDeEstudioIMPL> planes = new Vector<PlanDeEstudioIMPL>(Universidad
					.getInstance().getPlanesDeEstudio(alumno));
			this.getListaPlanes().setListData(new Vector<PlanDeEstudioIMPL>(planes));

			this.actualizarListaMaterias();
		}
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

	public void setListaPlanes(JList planes) {
		listaPlanes = planes;
	}

	public JList getListaPlanes() {
		return listaPlanes;
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
