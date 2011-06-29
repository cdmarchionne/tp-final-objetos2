package entregas;

import java.util.ArrayList;
import java.util.Date;

import personal.Alumno;

/**
 * TODO: description
 */
public abstract class TrabajoPractico {
	
	private String nombre;
	private Date fechaLimite; //Fecha MAXIMA para entregar
	private Date fechaReal; //Fecha CUANDO SE ENTREGO
	private ArrayList<String> correcciones;
	private boolean estado ;
	

	
	public abstract Object getAlumnos();
	
	public abstract boolean tieneAlumno(Alumno alumno);
	
	public void setAprobado(){
		this.estado = true;
	}
	
	public Date getFechaReal(){
		return this.fechaReal;
	}
	public void setDesaprobado(){
		this.estado = false;
	}
	
	public boolean estaAprobado(){
		return this.estado;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public String getNombre(){
		return this.nombre;
	}
	
	
	
	
}
