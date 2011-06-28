package src.materias;

import java.util.Date;
import java.util.List;

import src.personal.Alumno;

/**
 * TODO: description
 */
public class InscripcionMateria {
	
	private Date fechaInscripcion ;
	private Alumno alumno;
	private Materia materiaElegida;
	//private List<Materia> materiasInscriptas;
	public Catedra catedraElegida;
	
	
	
	public InscripcionMateria(Materia materia, Catedra catedra, Alumno alumno){
		this.fechaInscripcion = new Date(); //Fecha actual del sistema.
		this.materiaElegida = materia;
		this.catedraElegida = catedra;
		this.alumno = alumno;
	}
	public Catedra getCatedraElegida() {
		return catedraElegida;
	}
	
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Materia getMateriaElegida() {
		return materiaElegida;
	}
	
	
	
	public void setMateriaElegida(Materia materiaElegida) {
		this.materiaElegida = materiaElegida;
	}

}
