package src.entregas;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import src.personal.Alumno;

public class TrabajoPracticoGrupal extends TrabajoPractico {
	
	Map<Alumno,?>	notasAlumnos;
	
	
	
	/*Para crear un tp hay que crear antes un map de alumnos, asique deberiamos ver como acomodar esto con la interfaz, que agarre 
	 * los alumnos del tp y genere automaticamente el map. y fue.
	 * */
	public TrabajoPracticoGrupal(String nombre,Map<Alumno,?> alumnos){
		this.setNombre(nombre);
		this.setAlumnos(alumnos);
		
	}
	
	
	
	public void setAlumnos(Map<Alumno,?> alumnos){
		this.notasAlumnos = alumnos;
	}

	
	public Map<Alumno,?> getMapAlumnos() {
		return this.notasAlumnos;
		
	}
	
	public Set<Alumno> getAlumnos(){
		return this.notasAlumnos.keySet();
		
	}

	public boolean tieneAlumno(Alumno alumno){
		return this.getMapAlumnos().containsKey(alumno);
	}

	
	
}
