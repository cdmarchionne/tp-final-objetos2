package gui;

import gui.abstractGui.AbstractGUIFrame;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.interfaces.AlumnoIMPL;
import model.interfaces.OficinaAlumnosIMPL;
import universidad.OficinaAlumnos;

public class AnaliticoFrame extends AbstractGUIFrame {
	private static final long serialVersionUID = 1L;

	private AlumnoIMPL alumno;

	private JTextArea analiticoField;

	public AnaliticoFrame(AlumnosFrame alumnosFrame, AlumnoIMPL alumno) {
		super(alumnosFrame);
		this.alumno = alumno;
		OficinaAlumnosIMPL oficinaAlumnos = new OficinaAlumnos();
		this.getAnaliticoField().setText(oficinaAlumnos.analiticoDe(this.getAlumno()));
	}

	@Override
	protected void init() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());

		JTextArea analitico = new JTextArea();
		analitico.setEditable(false);
		this.setAnaliticoField(analitico);
		panel.add(analitico);

		this.getPanel().add(panel);
	}

	// setters&getters
	protected void setAlumno(AlumnoIMPL alumno) {
		this.alumno = alumno;
	}

	protected AlumnoIMPL getAlumno() {
		return alumno;
	}

	public void setAnaliticoField(JTextArea text) {
		analiticoField = text;
	}

	public JTextArea getAnaliticoField() {
		return analiticoField;
	}

}
