package personal;

import java.util.ArrayList;
import java.util.List;

import materias.InscripcionMateria;
import materias.Materia;
import materias.MateriaAprobada;
import personal.Persona;
import universidad.Carrera;
import universidad.InscripcionCarrera;
import entregas.EntregaTP;

public class Alumno {
	
	private Persona datosPersonales;
	private int legajo;
	private List<EntregaTP> entregas;
	private List<Carrera> carrerasInscriptas;
	private List<InscripcionMateria> materiasInscriptas;
	private List<MateriaAprobada> materiasAprobadas;
	private Boolean cursoDeIngresoAprobado = false;

	// *****************
	// * Constructores *
	// *****************
	public Alumno(final Persona datosPersonales, final int legajo) {
		
		super();
		this.datosPersonales = datosPersonales;
		this.legajo = legajo;
		this.entregas = new ArrayList<EntregaTP>();
		this.carrerasInscriptas = new ArrayList();
		this.materiasInscriptas = new ArrayList<InscripcionMateria>();
		this.materiasAprobadas = new ArrayList<MateriaAprobada>();
	}

	// ********************
	// * Getter & Setters *
	// ********************
	public List<EntregaTP> getEntregas() {
		return entregas;
	}

	public void setEntregas(final List<EntregaTP> entregas) {
		this.entregas = entregas;
	}

	public List<Carrera> getCarrerasInscriptas() {
		return carrerasInscriptas;
	}

	public void setCarrerasInscriptas(final List<Carrera> carrerasInscriptas) {
		this.carrerasInscriptas = carrerasInscriptas;
	}

	public List<?> getMateriasInscriptas() {
		return materiasInscriptas;
	}

	public void setMateriasInscriptas(final List<InscripcionMateria> materiasInscriptas) {
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

	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(final int legajo) {
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
	public void setCursoDeIngresoAprobado(Boolean boolie){
		this.cursoDeIngresoAprobado = boolie;
	}
	
	public void inscribirEnMateria(InscripcionMateria materia){
		//El alumno no se inscribe en la catedra eso lo sabe la materia.
		
		this.materiasInscriptas.add(materia);
				
	}
	public void agregarMateriaAprobada(Materia materia){
		
	}
	public void inscribirEnCarrera(Carrera carrera){
		if (this.cursoDeIngresoAprobado){
			this.carrerasInscriptas.add(carrera);
			this.legajo = carrera.obtenerLegajo();
										}
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
