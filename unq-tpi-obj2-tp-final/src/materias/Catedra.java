package materias;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import Utils.Historial;
import entregas.*;
import personal.Alumno;


/**
 * Catedra
 */
// Almeceno el Historial del Staff Completo
public class Catedra {

	/** Guardar el historial de Docentes */
	private Historial<StaffCatedra> staff;
	// private StaffCatedra staff;
	private String nombre;
	private Set<TrabajoPractico> tp;
	private Set<Evaluacion> examenes;
	private Set<Alumno> alumnosInscriptos ;
	private List<EntregaTP> entregasDeAlumnos; //Cuando un alumno entrega un TP, se guarda tmb en la catedra
	
	
	
	
	public Catedra(String nombre){
		this.setNombre(nombre);
	}
	public String getNombre(){
		return this.nombre;
	}
	public String toString(){
		return this.getNombre();
	}
	
	public Historial<StaffCatedra> getStaff() {
		return staff;
	}
	
	public void setStaff(Historial<StaffCatedra> staff) {
		this.staff = staff;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
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
	public Set<Alumno> getInscriptos() {
		return alumnosInscriptos;
	}
	public void setAlumnosInscriptos(Set<Alumno> alumnosInscriptos) {
		this.alumnosInscriptos = alumnosInscriptos;
	}
	public void agrgarAlumnoInscripto(Alumno alumno) {
		this.getInscriptos().add(alumno);
		
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
											int comp = ganador.getAlumnos().getApellido().compareTo(tp.getAlumnos().getApellido());
											if(comp<0){//No se hace nada.}
											if(comp>0){ganador = (TrabajoPracticoIndividual)entrega.getTp();}
											if(comp == 0){//Si da 0 es porque tienen mismo apellido. Comparo por nombre
												int name = ganador.getAlumnos().getNombre().compareTo(tp.getAlumnos().getNombre());
												if(name<0){//No se hace nada}
												if(name > 0 ){ganador = (TrabajoPracticoIndividual)entrega.getTp();}
											}
											}
										 }
							 	  }
						  }
				
				 }
			
		}
		
				
		

			
		}
							return ganador.getAlumnos();		
		}
	

}
