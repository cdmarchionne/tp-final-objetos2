package personal;

import java.util.HashSet;
import java.util.Set;

import materias.Materia;
import universidad.Carrera;
import Utils.Antecedente;
import Utils.Historial;
import Utils.Nombrable;

/**
 * Docente
 */
public class Docente implements Nombrable {

	private Persona datosPersonales;

	private Integer legajo;

	private Set<String> titulos;

	private Set<Carrera> carreras;

	private Historial<Materia> materiasDictadas;

	/** Si el docente es alumno conoce sus propios datos */
	private Alumno alumno;

	// *****************
	// * Constructores *
	// *****************
	public Docente(Persona datosPersonales, Integer legajo) {
		super();
		this.datosPersonales = datosPersonales;
		this.legajo = legajo;
		titulos = new HashSet<String>();
		carreras = new HashSet<Carrera>();
		materiasDictadas = new Historial<Materia>();
		alumno = null;
	}

	// ********************
	// * Getter & Setters *
	// ********************
	public Persona getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(Persona datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	@Override
	public String getNombre() {
		return this.getDatosPersonales().getNombre();
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public Set<String> getTitulos() {
		return titulos;
	}

	public void setTitulos(Set<String> titulos) {
		this.titulos = titulos;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public void removeAlumno() {
		alumno = null;
	}

	public Set<Carrera> getCarreras() {
		return carreras;
	}

	public void addCarreras(Carrera carrera) {
		carreras.add(carrera);
	}

	public Historial<Materia> getMateriasDictadas() {
		return materiasDictadas;
	}

	public void addMateriasDictadas(Antecedente<Materia> materiaDictada) {
		materiasDictadas.addAntecedente(materiaDictada);
	}

	@Override
	public int hashCode() {
		return legajo.hashCode() + datosPersonales.hashCode();
	}

	// ********************
	// * Funciones Utiles *
	// ********************
	public boolean isAlumno() {
		return alumno != null;
	}

	public boolean isSameAlumno(Alumno otroAlumno) {
		return this.isAlumno() && this.alumno.equals(otroAlumno);
	}

	public boolean isSamePerson(Alumno otroAlumno) {
		return this.getDatosPersonales().equals(otroAlumno.getDatosPersonales());
	}

	public boolean isSamePerson(Persona datosPersona) {
		return this.getDatosPersonales().equals(datosPersona);
	}
}
