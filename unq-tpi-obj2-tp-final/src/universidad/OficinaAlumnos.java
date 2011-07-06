package universidad;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import materias.Catedra;
import materias.InscripcionMateria;
import materias.Materia;
import model.interfaces.AlumnoIMPL;
import model.interfaces.OficinaAlumnosIMPL;
import personal.Alumno;
import personal.Docente;
import personal.Persona;

/**
 * TODO: description
 */
public class OficinaAlumnos implements OficinaAlumnosIMPL {

	private Universidad universidad;

	private Persona jefeOficina;
	private Set<Persona> secretarios;

	private Set<Alumno> alumnos;
	private Set<Docente> docentes;
	private Integer legajoDocente;

	public OficinaAlumnos() {
		super();
	}

	public OficinaAlumnos(Universidad universidad, Persona jefeOficina) {
		this();
		this.universidad = universidad;
		this.jefeOficina = jefeOficina;
		secretarios = new HashSet<Persona>();
		alumnos = new HashSet<Alumno>();
		docentes = new HashSet<Docente>();
		legajoDocente = 0;
	}

	/** Inscribo a un alumno en un Plan de Estudio especifico de una Carrera */
	public void inscribirAlumnoEnCarrera(Alumno alumno, PlanDeEstudio planDeEstudio) {
		if (alumno.getCursoDeIngreso()) {
			Carrera carrera = getCarrera(planDeEstudio);
			if (carrera.getPlanesVigentes().contains(planDeEstudio)) {
				alumno.addCarreraIncripta(new InscripcionCarrera(planDeEstudio, carrera
						.obtenerLegajo()));
			}
		}
	}

	public void inscribirAlumnoEnCarrera(Alumno alumno, Carrera carrera) {
		if (!carrera.getPlanesVigentes().isEmpty()) {
			Object[] planDeEstudio = carrera.getPlanesVigentes().toArray();
			inscribirAlumnoEnCarrera(alumno, (PlanDeEstudio) planDeEstudio[0]);
		}
	}

	/**
	 * Inscribo a un alumno en un Catedra especifico de una Materia
	 * 
	 * @param materia2
	 */
	public void inscribirAlumnoEnCatedra(Alumno alumno, Catedra catedra, Materia materia) {
		if (materia.getCatedras().contains(catedra)) {
			new InscripcionMateria(materia, catedra, alumno);
		}

		// for (Materia materia : (Materia[])
		// alumno.getMateriasInscribibles().toArray()) {
		// if (materia.getCatedras().contains(catedra)) {
		// new InscripcionMateria(materia, catedra, alumno);
		// break;
		// }
		// }

	}

	/** Creo un docente nuevo y lo agrego a la lista de docentes */
	public void nuevoDocente(Persona datosPersonales) {
		Docente docente = new Docente(datosPersonales, this.incrementarLegajoDocente());
		docentes.add(docente);
	}

	private int incrementarLegajoDocente() {
		legajoDocente = legajoDocente + 1;
		return legajoDocente;
	}

	public void nuevoAlumno(Persona datosPersonales) {
		Alumno alumno = new Alumno(datosPersonales);
		alumnos.add(alumno);
	}

	/** Cambia un alumno de una catedra a otra */
	public void cambiarAlumnoDeCatedra(Catedra nuevaCatedra, Catedra catedraActual, Alumno alumno) {
		catedraActual.removeAlumno(alumno);
		nuevaCatedra.agregarAlumnoInscripto(alumno);
	}

	public String entregarAnalitico(Alumno alumno) {
		return alumno.getMateriasAprobadas().toString();
	}

	public Persona getJefeOficina() {
		return jefeOficina;
	}

	public Set<Persona> getSecretarios() {
		return secretarios;
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public Set<Docente> getDocentes() {
		return docentes;
	}

	public Integer getLegajoDocente() {
		return legajoDocente;
	}

	public float getCoeficiente(Alumno alumno) {
		return alumno.calcularPromedio();
	}

	private Set<Carrera> getCarreras() {
		return universidad.getCarreras();
	}

	/**
	 * Obtengo todos los Planes de Estudio Vigentes en todas las Carreras
	 * Universitarias
	 */
	public Set<PlanDeEstudio> getPlanesDeEstudio() {
		Set<PlanDeEstudio> planes = new HashSet<PlanDeEstudio>();

		for (Carrera carrera : getCarreras()) {
			planes.addAll(carrera.getPlanesVigentes());
		}

		return planes;
	}

	@Override
	public String analiticoDe(AlumnoIMPL alumno) {
		return this.entregarAnalitico((Alumno) alumno);
	}

	@Override
	public float coeficienteDe(AlumnoIMPL alumno) {
		return this.getCoeficiente((Alumno) alumno);
	}

	/** Busco a que Carrera pertenece un Plan de Estudio */
	public Carrera getCarrera(PlanDeEstudio planDeEstudio) {
		Carrera carreraBuscada = null;

		Iterator<Carrera> iteradorCarrera = getCarreras().iterator();
		Carrera carrera = null;
		while (iteradorCarrera.hasNext()) {
			carrera = iteradorCarrera.next();
			if (carrera.getPlanesDeEstudio().contains(planDeEstudio)) {
				carreraBuscada = carrera;
				break;
			}
		}

		return carreraBuscada;
	}

	@SuppressWarnings("deprecation")
	public void otorgarLicenciasAlumno(Alumno alumno) {
		Date fechaActual = new Date();
		if (alumno.getCantLicencias() < 6
				&& !(alumno.getAñosLicencia().contains(fechaActual.getYear()))) {
			alumno.addAñosLicencia(fechaActual.getYear());
			alumno.sumCantLicencias();

		}
	}

}