package src.materias;

import java.util.ArrayList;
import java.util.List;
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
	private List<EntregaTP> entregasDeAlumnos;
	
	
	public Historial<StaffCatedra> getStaff() {
		return staff;
	}
	public void setStaff(Historial<StaffCatedra> staff) {
		this.staff = staff;
	}
	public Set<TrabajoPractico> getTp() {
		return tp;
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
	
	public void agregarEvaluacion(Evaluacion evaluacion){
		this.getExamenes().add(evaluacion);
		
	}
	
	public void agregarTrabajoPractico(TrabajoPractico tp){
		this.getTp().add(tp);
	}
	
	public List<EntregaTP> getEntregasTPs(){
		return this.entregasDeAlumnos;
	}
	
	
	public ArrayList<EntregaTP> getTPSDe(Alumno alumno){ /*Devuelve la lista de tps de un alumno*/
		ArrayList<EntregaTP> listaEntregas = new ArrayList<EntregaTP>();
		for (EntregaTP  entrega :  this.getEntregasTPs()) {
			if(entrega.getAlumno().equals(alumno)){
				listaEntregas.add(entrega);
			}
		}
		
		return listaEntregas;
	}

	
	public Alumno getMejorAlumnoDeEntrega(TrabajoPractico tp){
		
		
		
		return null;
		
	}
}
