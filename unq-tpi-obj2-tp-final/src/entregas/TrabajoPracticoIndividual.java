package src.entregas;

import src.personal.Alumno;

public class TrabajoPracticoIndividual extends TrabajoPractico {

	
	private Alumno alumno;
	private int nota;
	
	/*Constructor*/
	public TrabajoPracticoIndividual(String nombre,Alumno alumno){
		this.setNombre(nombre);
		this.setAlumno(alumno);
		
		
	}
	
	public Alumno getAlumnos() {
		return this.alumno;
		
	}
	
	public void setAlumno(Alumno alumno){
		this.alumno = alumno;
	}
	public void setNota(int nota){
		this.nota = nota;
	}
	public int getNota(){
		return this.nota;}

	
	public boolean tieneAlumno(Alumno alumno) {
		
		return this.getAlumnos().equals(alumno);
	}

	

}
