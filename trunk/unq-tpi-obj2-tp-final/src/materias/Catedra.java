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
	private List<EntregaTP> entregasDeAlumnos; //Cuando un alumno entrega un TP, se guarda tmb en la catedra
	
	
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
	
	public void addEntrega(EntregaTP entrega){
		this.getEntregasTPs().add(entrega);
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

	public ArrayList<Alumno> getAlumnosEntregaronTP(TrabajoPractico tp){/*Devuelve los alumnos que entregaron cierto TP*/
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		for (EntregaTP  entrega :  this.getEntregasTPs()){
			if(entrega.getTp().equals(tp)){
				listaAlumnos.add(entrega.getAlumno());
			}
		}
		return listaAlumnos;
		
	}
	
	public ArrayList<EntregaTP> getEntregasTP(TrabajoPractico tp){/*Devuelve las entregas de cierto TP*/
		ArrayList<EntregaTP> listaEntregas = new ArrayList<EntregaTP>();
		for (EntregaTP  entrega :  this.getEntregasTPs()){
			if(entrega.getTp().equals(tp)){
				listaEntregas.add(entrega);
			}
		}
		return listaEntregas;
		
	}
	
	
	public Alumno getMejorAlumnoDeEntrega(TrabajoPracticoIndividual tp){
		TrabajoPracticoIndividual ganador = tp;
		for(EntregaTP entrega : this.getEntregasTP(tp)){
			if(ganador.getNota()< entrega.getNota()){
				ganador = (TrabajoPracticoIndividual) entrega.getTp();
			}else{ if(ganador.getNota()> entrega.getNota()){
					 //No hacer nada.
					}else{/*Si no es menor ni es mayor, entonces es igual*/
							if(ganador.getFechaReal().before(entrega.getTp().getFechaReal())){
								//No hacer nada
							}else{ if(ganador.getFechaReal().after(entrega.getTp().getFechaReal())){
									ganador = (TrabajoPracticoIndividual) entrega.getTp();
									}else{ //Si la fecha no esta ni antes ni despues, coinciden.
											ganador.getAlumnos().getApellido();
										 }
							 	  }
						  }
				
				 }
			
		}
		
				
		
		return ganador.getAlumnos();
		
	}
}
