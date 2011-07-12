package universidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import materias.Catedra;
import materias.Materia;
import model.interfaces.AlumnoIMPL;
import model.interfaces.CatedraIMPL;
import model.interfaces.MateriaIMPL;
import model.interfaces.PlanDeEstudioIMPL;
import model.interfaces.UniversidadIMPL;
import personal.Alumno;
import personal.Persona;
import Utils.Nombrable;
import excepciones.NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion;

public class Universidad implements Nombrable, UniversidadIMPL {

	private static Universidad universidad = null;

	private String nombre;

	private final Set<Carrera> carreras;

	private final Set<Area> areas;

	private final OficinaAlumnos oficinaDeAlumnos;

	public static Universidad getInstance() {
		return getInstance("", null);
	}

	public static Universidad getInstance(String nombre, Persona jefeOficinaAlumnos) {
		if (getUniversidad() == null) {
			setUniversidad(new Universidad(nombre, jefeOficinaAlumnos));
		}
		return getUniversidad();
	}

	private static void setUniversidad(Universidad instance) {
		universidad = instance;
	}

	private static Universidad getUniversidad() {
		return universidad;
	}

	private Universidad(String nombre, Persona jefeOficinaAlumnos) {
		super();
		this.nombre = nombre;
		carreras = new HashSet<Carrera>();
		areas = new HashSet<Area>();
		oficinaDeAlumnos = new OficinaAlumnos(this, jefeOficinaAlumnos);
	}

	public Set<Carrera> getCarreras() {
		return carreras;
	}

	public void addCarrera(Carrera carrera) {
		carreras.add(carrera);
	}

	public void removeCarrera(Carrera carrera) {
		carreras.remove(carrera);
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void addArea(Area area) {
		areas.add(area);
	}

	public void removeArea(Area area) {
		areas.remove(area);
	}

	public OficinaAlumnos getOficinaDeAlumnos() {
		return oficinaDeAlumnos;
	}

	/** Busco la carrera a la que pertenece un plan de estudio */
	public Carrera getCarrera(PlanDeEstudio planDeEstudio) {
		Carrera carreraBuscada = null;

		for (Carrera carrera : carreras) {
			if (carrera.getPlanesDeEstudio().equals(planDeEstudio)) {
				carreraBuscada = carrera;
				break;
			}
		}

		return carreraBuscada;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public List<PlanDeEstudioIMPL> getPlanesDeEstudio(AlumnoIMPL alumno) {
		List<PlanDeEstudioIMPL> planesBuscados = new ArrayList<PlanDeEstudioIMPL>();

		for (AlumnoIMPL alumnoIMPL : this.getAlumnos()) {
			if (alumnoIMPL.equals(alumno)) {
				planesBuscados.addAll(((Alumno) alumnoIMPL).getPlanesDeEstudio());
				break;
			}
		}

		return planesBuscados;
	}

	@Override
	public List<AlumnoIMPL> getAlumnos() {
		return new ArrayList<AlumnoIMPL>(this.getOficinaDeAlumnos().getAlumnos());
	}

	@Override
	public List<MateriaIMPL> getMaterias() {
		List<MateriaIMPL> materias = new ArrayList<MateriaIMPL>();

		for (Area area : areas) {
			materias.addAll(new ArrayList<MateriaIMPL>(area.getMaterias(new Date())));
		}

		return materias;
	}

	@Override
	public List<MateriaIMPL> materiasInscribibles(AlumnoIMPL alumno, PlanDeEstudioIMPL plan) {
		try {
			return ((Alumno) alumno).getMateriasInscribibles((PlanDeEstudio) plan);
		} catch (NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion e) {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public void inscribirAlumno(AlumnoIMPL alumno, CatedraIMPL catedra, MateriaIMPL materia,
			PlanDeEstudioIMPL plan)
	{
		this.getOficinaDeAlumnos().inscribirAlumnoEnCatedra((Alumno) alumno, (Catedra) catedra,
				(Materia) materia, (PlanDeEstudio) plan);
	}

}
