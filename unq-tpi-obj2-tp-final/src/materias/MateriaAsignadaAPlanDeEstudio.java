package materias;

import java.util.HashSet;
import java.util.Set;

/**
 * Materias que varian por Plan de Estudio
 */
public class MateriaAsignadaAPlanDeEstudio {

	private Materia materia;

	private TipoDeMateria tipoDeMateria;

	private Duracion duracion;

	private Set<Materia> correlatividades;

	public MateriaAsignadaAPlanDeEstudio(Materia materia, TipoDeMateria tipo, Duracion duracion) {
		this.materia = materia;
		tipoDeMateria = tipo;
		this.duracion = duracion;
		correlatividades = new HashSet<Materia>();
	}

	public MateriaAsignadaAPlanDeEstudio(Materia materia, TipoDeMateria tipo, Duracion duracion,
			Set<Materia> correlatividades) {
		this(materia, tipo, duracion);
		this.correlatividades = correlatividades;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;

	}

	public TipoDeMateria getTipoDeMateria() {
		return tipoDeMateria;
	}

	public void setTipoDeMateria(TipoDeMateria tipoDeMateria) {
		this.tipoDeMateria = tipoDeMateria;
	}

	public Duracion getDuracion() {
		return duracion;
	}

	public void setDuracion(Duracion duracion) {
		this.duracion = duracion;
	}

	/**
	 * Este metodo se puede dejar por si se quiere agregar un SET de
	 * correlatividades.
	 * Por ejemplo para algo en comun a todas las materias
	 */
	public void setCorrelatividades(Set<Materia> correlatividades) {
		this.correlatividades = correlatividades;
	}

	public Set<Materia> getCorrelatividades() {
		return correlatividades;
	}

	public void addMateriaCorrelativa(Materia materiaCorrelativa) {
		correlatividades.add(materiaCorrelativa);
	}

	public void removeMateriaCorrelativa(Materia materiaCorrelativa) {
		correlatividades.remove(materiaCorrelativa);
	}

}
