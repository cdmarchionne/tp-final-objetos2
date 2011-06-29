package src.personal;

import java.util.ArrayList;
import java.util.List;

import src.materias.*;
import src.universidad.*;
import src.entregas.*;

public class Alumno {

	private Persona datosPersonales;

	private int legajo;

	private List<EntregaTP> entregas;

	private List<InscripcionCarrera> carrerasInscriptas;

	private ArrayList<InscripcionMateria> materiasInscriptas;

	private List<MateriaAprobada> materiasAprobadas;

	// *****************
	// * Constructores *
	// *****************
	public Alumno(final Persona datosPersonales, final int legajo) {
		
		super();
		this.datosPersonales = datosPersonales;
		this.legajo = legajo;
		this.entregas = new ArrayList<EntregaTP>();
		this.carrerasInscriptas = new ArrayList<InscripcionCarrera>();
		this.materiasInscriptas = new ArrayList<InscripcionMateria>();
		this.materiasAprobadas = new ArrayList<MateriaAprobada>();
	}

	// ********************
	// * Getter & Setters *
	// ********************
	public List<EntregaTP> getEntregas() {
		return entregas;
	}

	public void setEntregas(final ArrayList<EntregaTP> entregas) {
		this.entregas = entregas;
	}

	public List<InscripcionCarrera> getCarrerasInscriptas() {
		return carrerasInscriptas;
	}

	public void setCarrerasInscriptas(final List<InscripcionCarrera> carrerasInscriptas) {
		this.carrerasInscriptas = carrerasInscriptas;
	}

	public List<?> getMateriasInscriptas() {
		return materiasInscriptas;
	}

	public void setMateriasInscriptas(final ArrayList<InscripcionMateria> materiasInscriptas) {
		this.materiasInscriptas = materiasInscriptas;
	}

	public List<MateriaAprobada> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(final List<MateriaAprobada> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public Persona getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(final Persona datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(final Integer legajo) {
		this.legajo = legajo;
	}

	public void calcularRegularidad(){		
		
	}
	
	public String getNombre(){
		return this.getDatosPersonales().getNombre();
	}
	
	public String getApellido(){
		return this.getDatosPersonales().getApellido();
	}
	
	public void inscribirEnMateria(InscripcionMateria materia){
		//El alumno no se inscribe en la catedra eso lo sabe la materia.
		
		this.materiasInscriptas.add(materia);
				
	}
	public void agregarMateriaAprobada(Materia materia){
		
	}
	public void inscribirEnCarrera(Carrera carrera){
	
	}
	public int calcularCoeficiente(){
		
		return 5;
	}
	// @Override
	// public boolean equals(final Object obj) {
	// return this.hashCode() == obj.hashCode();
	// }
	//
	//@Override
	//public int hashCode() {
	//	return legajo.hashCode() + datosPersonales.hashCode();
	//}
}
