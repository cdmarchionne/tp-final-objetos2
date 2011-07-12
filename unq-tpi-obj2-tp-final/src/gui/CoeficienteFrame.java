package gui;

import gui.abstractGui.AbstractGUIFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.interfaces.AlumnoIMPL;
import model.interfaces.OficinaAlumnosIMPL;
import model.interfaces.PlanDeEstudioIMPL;
import universidad.OficinaAlumnos;

// TODO: Agregar la seleccion del Plan de estudio para el calculo del coeficiente

public class CoeficienteFrame extends AbstractGUIFrame {
	private static final long serialVersionUID = 1L;

	private AlumnoIMPL alumno;

	private JList listaPlanes;

	private JTextArea texto;

	public CoeficienteFrame(JFrame frame, AlumnoIMPL alumno) {
		super(frame);
		this.alumno = alumno;
		// this.actualizarListaPlanes();

		// OficinaAlumnosIMPL oficinaAlumnos = new OficinaAlumnos();
		// String mensaje = "el coeficiente de " + alumno.toString() + "\n" +
		// " es de: "
		// + oficinaAlumnos.coeficienteDe(alumno);
		//
		// this.getTexto().setText(mensaje);
	}

	@Override
	protected void init() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel.add(this.mkListaPlanes());
		panel.add(this.mkTextCoeficiente());

	}

	private JComponent mkTextCoeficiente() {
		JTextArea area = new JTextArea();
		area.setEditable(false);
		this.setTexto(area);

		this.getPanel().add(area);

		return area;
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
				CoeficienteFrame.this.actualizarCoeficiente();
			}
		});

		this.setListaPlanes(listaDePlanes);
		panel.add(new JScrollPane(listaDePlanes));
		return panel;
	}

	protected void actualizarListaPlanes() {
		PlanDeEstudioIMPL plan = (PlanDeEstudioIMPL) CoeficienteFrame.this.getListaPlanes()
				.getSelectedValue();

		if (plan == null) {
			this.resetearTextCoeficiente();
		} else {

			this.actualizarCoeficiente();
		}
	}

	protected void resetearTextCoeficiente() {
		this.getTexto().setText("");
	}

	protected void resetearListaPlanes() {
		this.getListaPlanes().setListData(new Vector<PlanDeEstudioIMPL>());
	}

	/**
	 * actualiza la lista de materias segun la seleccion de la lista de alumnos
	 */
	protected void actualizarCoeficiente() {
		PlanDeEstudioIMPL plan = (PlanDeEstudioIMPL) CoeficienteFrame.this.getListaPlanes()
				.getSelectedValue();

		// if (plan == null) {
		// this.resetearTextCoeficiente();
		// } else {

		OficinaAlumnosIMPL oficinaAlumnos = new OficinaAlumnos();
		String mensaje = "el coeficiente de " + alumno.toString() + "\n" + " es de: "
				+ oficinaAlumnos.coeficienteDe(alumno, plan);

		this.getTexto().setText(mensaje);

		// }
	}

	// setters&getters
	public void setTexto(JTextArea texto) {
		this.texto = texto;
	}

	public JTextArea getTexto() {
		return texto;
	}

	public void setListaPlanes(JList planes) {
		listaPlanes = planes;
	}

	public JList getListaPlanes() {
		return listaPlanes;
	}

}
