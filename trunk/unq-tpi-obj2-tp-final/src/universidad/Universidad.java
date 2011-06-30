package universidad;

import java.util.HashSet;
import java.util.Set;

import Utils.Nombrable;

public class Universidad implements Nombrable {

	private String nombre;

	private Set<Carrera> carreras;

	private Set<Area> areas;
	
	private OficinaDeAlumnos oficinaDeAlumnos;
	
	public Universidad(String nombre) {
		this.nombre=nombre;
		carreras = new HashSet<Carrera>();
		areas= new HashSet<Area>();
		oficinaDeAlumnos = new OficinaDeAlumnos();
	}

	public Set<Carrera> getCarreras() {
		return carreras;
	}

	public void addCarreras(final Carrera carrera) {
		this.carreras.add(carrera);
	}
	
	public void removeCarreras(final Carrera carrera) {
		this.carreras.remove(carrera);
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(final Set<Area> areas) {
		this.areas = areas;
	}
	
	public OficinaDeAlumnos getOficinaDeAlumnos() {
		return oficinaDeAlumnos;
	}

	public void setOficinaDeAlumnos(OficinaDeAlumnos oficinaDeAlumnos) {
		this.oficinaDeAlumnos = oficinaDeAlumnos;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	
}
