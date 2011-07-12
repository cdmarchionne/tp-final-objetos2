package universidad;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import materias.Materia;
import materias.MateriaAsignadaAPlanDeEstudio;
import model.interfaces.PlanDeEstudioIMPL;
import personal.Docente;
import Utils.Nombrable;
import excepciones.NoSeEncuentraMateriaEnPlanException;

public class PlanDeEstudio implements Nombrable, PlanDeEstudioIMPL {

	private final String nombre;

	private final Date fechaDeCreacion;

	private final Docente director;

	private final List<MateriaAsignadaAPlanDeEstudio> materias;

	private final Set<RecorridoSugerido> ordenesSugeridos;

	// *****************
	// * Constructores *
	// *****************

	public PlanDeEstudio(String nombre, Date fechaDeCreacion, Docente director) {
		super();
		this.nombre = nombre;
		this.fechaDeCreacion = fechaDeCreacion;
		this.director = director;
		materias = new ArrayList<MateriaAsignadaAPlanDeEstudio>();
		ordenesSugeridos = new HashSet<RecorridoSugerido>();
	}

	// ********************
	// * Getter & Setters *
	// ********************

	public Set<Materia> getCorrelatividades(Materia materia) {

		for (MateriaAsignadaAPlanDeEstudio materiaPlan : this.getMaterias()) {
			if (materiaPlan.getMateria().equals(materia))
				return materiaPlan.getCorrelatividades();
		}

		throw new NoSeEncuentraMateriaEnPlanException(materia, this);
	}

	public List<MateriaAsignadaAPlanDeEstudio> getMaterias() {
		return materias;
	}

	public void addMaterias(MateriaAsignadaAPlanDeEstudio materiaPlan) {
		materias.add(materiaPlan);
	}

	public Set<RecorridoSugerido> getOrdenesSugeridos() {
		return ordenesSugeridos;
	}

	public void addOrdenesSugeridos(RecorridoSugerido ordenSugerido) {
		ordenesSugeridos.add(ordenSugerido);
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public Docente getDirector() {
		return director;
	}

	/** Calculo los creditos del plan de estudios */
	public Integer getCreditos() {
		Integer creditos = 0;

		for (MateriaAsignadaAPlanDeEstudio materiaPlanDeEstudio : this.getMaterias()) {
			creditos = creditos + materiaPlanDeEstudio.getMateria().getCreditos();
		}

		return creditos;
	}

	@Override
	public boolean equals(Object obj) {
		boolean rta = false;

		if (!(obj == null || this.getClass() != obj.getClass())) {
			if (this == obj) {
				rta = true;
			} else {
				rta = this.isSame((PlanDeEstudio) obj);
			}
		}
		return rta;
	}

	private boolean isSame(PlanDeEstudio plan) {
		return this.getNombre().equals(plan.getNombre());
	}

}
