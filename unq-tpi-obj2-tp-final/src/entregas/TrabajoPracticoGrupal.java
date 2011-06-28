package src.entregas;

import java.util.Map;

import src.personal.Alumno;

public class TrabajoPracticoGrupal extends TrabajoPractico {
	
	Map<Alumno,?>	notasAlumnos;/*VER como hacer un map de doble entrada para tener alumno como clave y el valor la nota */
	
	
	public TrabajoPracticoGrupal(Map<Alumno,?> alumnos){
		this.setAlumnos(alumnos);
		
		
	}
	
	public void setAlumnos(Map<Alumno,?> alumnos){
		this.notasAlumnos = alumnos;
	}

}
