package src.materias;

import java.util.Set;

import src.Utils.Historial;
import src.entregas.*;
import src.personal.Alumno;


/**
 * Catedra
 */
// Almeceno el Historial del Staff Completo
public class Catedra {

	/** Guardar el historial de Docentes */
	private Historial<StaffCatedra> staff;
	// private StaffCatedra staff;

	private Set<TrabajoPractico> tp;
	private Set<Evaluacion> examenes;
	private Set<Alumno> alumnosInscriptos ;
	
	
	public Historial<StaffCatedra> getStaff() {
		return staff;
	}
	public void setStaff(Historial<StaffCatedra> staff) {
		this.staff = staff;
	}
	public Set<TrabajoPractico> getTp() {
		return tp;
	}
	public void setTp(Set<TrabajoPractico> tp) {
		this.tp = tp;
	}
	public Set<Evaluacion> getExamenes() {
		return examenes;
	}
	public void setExamenes(Set<Evaluacion> examenes) {
		this.examenes = examenes;
	}
	public Set<Alumno> getAlumnosInscriptos() {
		return alumnosInscriptos;
	}
	public void setAlumnosInscriptos(Set<Alumno> alumnosInscriptos) {
		this.alumnosInscriptos = alumnosInscriptos;
	}
	public void agrgarAlumnoInscripto(Alumno alumno) {
		this.getAlumnosInscriptos().add(alumno);
		
		
	} 

}
