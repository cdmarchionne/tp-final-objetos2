package personal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import materias.InscripcionMateria;
import materias.Materia;
import materias.MateriaAprobada;
import universidad.Carrera;
import entregas.EntregaTP;

public class Alumno {

	private Persona datosPersonales;
	private Map<Carrera, Integer> legajo;
	private List<EntregaTP> entregas;
	private List<Carrera> carrerasInscriptas;
	private List<InscripcionMateria> materiasInscriptas;
	private List<MateriaAprobada> materiasAprobadas;
	private Boolean cursoDeIngreso;

	// *****************
	// * Constructores *
	// *****************
	public Alumno(final Persona datosPersonales) {

		super();
		this.datosPersonales = datosPersonales;
		legajo = new HashMap<Carrera, Integer>();
		entregas = new ArrayList<EntregaTP>();
		carrerasInscriptas = new ArrayList();
		materiasInscriptas = new ArrayList<InscripcionMateria>();
		materiasAprobadas = new ArrayList<MateriaAprobada>();
		cursoDeIngreso = false;
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

	public void addCarrerasInscriptas(final Carrera carreraInscripta) {
		carrerasInscriptas.add(carreraInscripta);
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

	public Integer getLegajo(final Carrera carrera) {
		return legajo.get(carrera);
	}

	public void addLegajo(final Carrera carrera, final Integer legajo) {
		this.legajo.put(carrera, legajo);
	}

	public void calcularRegularidad() {

	}

	public String getNombre() {
		return this.getDatosPersonales().getNombre();
	}

	public String getApellido() {
		return this.getDatosPersonales().getApellido();
	}

	public void setCursoDeIngreso(final Boolean boolie) {
		cursoDeIngreso = boolie;
	}

	public Boolean cursoDeIngresoAprobado() {
		return cursoDeIngreso;
	}

	public void inscribirEnMateria(final InscripcionMateria materia) {
		// El alumno no se inscribe en la catedra eso lo sabe la materia.

		materiasInscriptas.add(materia);

	}

	public void agregarMateriaAprobada(final Materia materia) {

	}

	public int calcularCoeficiente() {

		return 5;
	}

}
