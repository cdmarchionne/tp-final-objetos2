package universidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import materias.MateriaAsignadaAPlanDeEstudio;
import personal.Docente;
import Utils.Nombrable;

public class PlanDeEstudio implements Nombrable {

	private String nombre;

	private Date fechaDeCreacion;

	private Docente director;

	private List<MateriaAsignadaAPlanDeEstudio> materias;

	private Set<RecorridoSugerido> ordenesSugeridos;

	// *****************
	// * Constructores *
	// *****************

	public PlanDeEstudio(String nombre, Date fechaDeCreacion, Docente director) {
		super();
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
		this.director = director;
		this.materias = new ArrayList<MateriaAsignadaAPlanDeEstudio>();
		this.ordenesSugeridos = new HashSet<RecorridoSugerido>();
	}

	// ********************
	// * Getter & Setters *
	// ********************

	public List<MateriaAsignadaAPlanDeEstudio> getMaterias() {
		return materias;
	}

	public void addMaterias(MateriaAsignadaAPlanDeEstudio materias) {
		this.materias.add(materias);
	}

	public Set<RecorridoSugerido> getOrdenesSugeridos() {
		return ordenesSugeridos;
	}

	public void addOrdenesSugeridos(RecorridoSugerido ordenesSugeridos) {
		this.ordenesSugeridos.add(ordenesSugeridos);
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public Docente getDirector() {
		return director;
	}

}
