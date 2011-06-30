package universidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.interfaces.AlumnoIMPL;
import model.interfaces.CatedraIMPL;
import model.interfaces.MateriaIMPL;
import model.interfaces.UniversidadIMPL;
import personal.Persona;
import Utils.Nombrable;

public class Universidad implements Nombrable, UniversidadIMPL {

	private static Universidad universidad = null;

	private String nombre;

	private Set<Carrera> carreras;

	private Set<Area> areas;

	private OficinaAlumnos oficinaDeAlumnos;

	public static Universidad getInstance() {
		if (getUniversidad() == null) {
			setUniversidad(new Universidad());
		}
		return getUniversidad();
	}

	private static void setUniversidad(Universidad instance) {
		universidad = instance;
	}

	private static Universidad getUniversidad() {
		return universidad;
	}

	public Universidad() {
		super();
	}

	public Universidad(String nombre, Persona jefeOficinaAlumnos) {
		this();
		this.nombre = nombre;
		carreras = new HashSet<Carrera>();
		areas = new HashSet<Area>();
		oficinaDeAlumnos = new OficinaAlumnos(jefeOficinaAlumnos);
	}

	public Set<Carrera> getCarreras() {
		return carreras;
	}

	public void addCarreras(final Carrera carrera) {
		carreras.add(carrera);
	}

	public void removeCarreras(final Carrera carrera) {
		carreras.remove(carrera);
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(final Set<Area> areas) {
		this.areas = areas;
	}

	public OficinaAlumnos getOficinaDeAlumnos() {
		return oficinaDeAlumnos;
	}

	public void setOficinaDeAlumnos(OficinaAlumnos oficinaDeAlumnos) {
		this.oficinaDeAlumnos = oficinaDeAlumnos;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	@Override
	public List<AlumnoIMPL> getAlumnos() {
		return new ArrayList<AlumnoIMPL>(this.getOficinaDeAlumnos().getAlumnos());
	}

	@Override
	public List<MateriaIMPL> getMaterias() {
		List<MateriaIMPL> materias = new ArrayList<MateriaIMPL>();

		for (Area area : areas) {
			materias.addAll(new ArrayList<MateriaIMPL>(area.getMateriasDictadas().getElementos(
					new Date())));
		}

		return materias;
	}

	@Override
	public List<MateriaIMPL> materiasInscribibles(AlumnoIMPL alumno) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void inscribirAlumno(AlumnoIMPL alumno, CatedraIMPL catedra) {
		// this.getOficinaDeAlumnos().inscribirAlumnoEnCarrera(alumno, catedra);
	}

}
