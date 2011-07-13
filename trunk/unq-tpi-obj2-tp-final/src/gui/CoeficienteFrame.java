package gui;

import gui.abstractGui.AbstractGUIFrame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import personal.Alumno;

import model.interfaces.AlumnoIMPL;
import model.interfaces.OficinaAlumnosIMPL;
import model.interfaces.PlanDeEstudioIMPL;
import universidad.OficinaAlumnos;
import universidad.Universidad;

// TODO: Agregar la seleccion del Plan de estudio para el calculo del coeficiente

public class CoeficienteFrame extends AbstractGUIFrame {
	private static final long serialVersionUID = 1L;

	private AlumnoIMPL alumno;

	private JList listaPlanes;

	private JTextArea texto;

	public CoeficienteFrame(JFrame frame, AlumnoIMPL alumno) {
		super(frame);
		this.alumno = alumno;
		

//		 OficinaAlumnosIMPL oficinaAlumnos = Universidad.getInstance().getOficinaDeAlumnos();
//		 String mensaje = "el coeficiente de " + alumno.toString() + "\n" +
//		 " es de: "
//		 + oficinaAlumnos.coeficienteDe(alumno,(PlanDeEstudioIMPL) CoeficienteFrame.this
//			.getListaPlanes().getSelectedValue());
////		 this.actualizarListaPlanes(); //COMENTADA ANTES
//		 this.getTexto().setText(mensaje);
	}

	@Override
	protected void init() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		panel.add(this.mkListaPlanes());
		this.getPanel().add(this.mkTextCoeficiente());

		this.getPanel().add(panel);

	}

	private JComponent mkTextCoeficiente() {
		JTextArea area = new JTextArea();
		area.setEditable(false);
		this.setTexto(area);

		// this.getPanel().add(area);

		return area;
	}

	/**
	 * Crea la lista de Planes de Estudio del Alumno
	 */
	private JComponent mkListaPlanes() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new JLabel("Planes de Estudio"));
		    
//		Object[] plan = (this.alumno).getPlanesDeEstudio().toArray(); 

		Vector<PlanDeEstudioIMPL> plan = new Vector<PlanDeEstudioIMPL>(Universidad
				.getInstance().getPlanesDeEstudio(this.getAlumno()));
		
		JList listaDePlanes = new JList(plan);
		
		//listaDePlanes.setSize(new Dimension(100, 50));
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

		 if (plan == null) {
		 this.resetearTextCoeficiente();
		 } else {

		OficinaAlumnosIMPL oficinaAlumnos = Universidad.getInstance().getOficinaDeAlumnos();
		String mensaje = "el coeficiente de " + alumno.toString() + "\n" + " es de: "
				+ oficinaAlumnos.coeficienteDe(alumno, plan);

		this.getTexto().setText(mensaje);

		 }
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

	public AlumnoIMPL getAlumno() {
		return alumno;
	}

	private void setAlumno(AlumnoIMPL alumno) {
		this.alumno = alumno;
	}
	
	

}
