package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Index extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public Index (){
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(new Dimension(850, 300));
		
		this.setLayout(new FlowLayout());
		this.add(mkBotonAlumnos());
		this.add(mkBotonMaterias());
		this.add(mkBotonInscribirAlumno());
	}

	private Component mkBotonInscribirAlumno() {
		JButton button = new JButton("Inscribir Alumno");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Index.this.setVisible(false);
				new InscribirAlumnoFrame(Index.this);
			}
			
		});
		return button;
	}

	private JButton mkBotonMaterias() {
		JButton button = new JButton("Materias");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Index.this.setVisible(false);
				new MateriasFrame(Index.this);
			}
			
		});
		return button;
	}

	private JButton mkBotonAlumnos() {
		JButton button = new JButton("Alumnos");
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Index.this.setVisible(false);
				new AlumnosFrame(Index.this);
			}
			
		});
		return button;
	}

	
	
	//setters&getters
	
}
