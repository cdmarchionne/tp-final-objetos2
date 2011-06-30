package gui;

import gui.abstractGui.AbstractGUIFrame;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.interfaces.AlumnoIMPL;
import model.interfaces.OficinaAlumnosIMPL;
import universidad.OficinaAlumnos;

public class CoeficienteFrame extends AbstractGUIFrame {
	private static final long serialVersionUID = 1L;

	private JTextArea texto;

	public CoeficienteFrame(JFrame frame, AlumnoIMPL alumno) {
		super(frame);

		OficinaAlumnosIMPL oficinaAlumnos = new OficinaAlumnos();
		String texto = "el coeficiente de " + alumno.toString() + "\n" + " es de: "
				+ oficinaAlumnos.coeficienteDe(alumno);

		this.getTexto().setText(texto);
	}

	@Override
	protected void init() {
		JTextArea area = new JTextArea();
		area.setEditable(false);
		this.setTexto(area);

		this.getPanel().add(area);
	}

	// setters&getters
	public void setTexto(JTextArea texto) {
		this.texto = texto;
	}

	public JTextArea getTexto() {
		return texto;
	}
}
