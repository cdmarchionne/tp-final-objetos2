package materias;

import java.util.Date;

import personal.Alumno;

/**
 * Adapter que agrupa los datos necesarios para Inscribir un Alumno en una Materia
 */
public class InscripcionMateria {
	
	private Date fechaInscripcion ;
	private Alumno alumno;
	private Materia materiaElegida;
	public Catedra catedraElegida;
	
	public InscripcionMateria(Materia materia, Catedra catedra, Alumno alumno){
		this.fechaInscripcion = new Date(); //Fecha actual del sistema.
		this.materiaElegida = materia;
		this.setAlumno(alumno);
		this.setCatedraElegida(catedra);
	}
	
	private void setCatedraElegida(Catedra catedra) {
		this.catedraElegida = catedra;
		catedra.agregarAlumnoInscripto(getAlumno());
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
	
	private void setAlumno(Alumno alumno) {
		this.alumno = alumno;
		alumno.inscribirEnMateria(this);
	}
	
	public Materia getMateriaElegida() {
		return materiaElegida;
	}
	
	public void setMateriaElegida(Materia materiaElegida) {
		this.materiaElegida = materiaElegida;
	}

}
