package universidad;

import java.util.ArrayList;
import java.util.List;

import materias.Duracion;
import materias.Materia;

/**
 * Clase que sirve para manejar de forma conjunta las Materias que se pueden
 * cursar en un mismo nivel, con la duracion del lapso de las mismas.
 */
public class Nivel {

	/** Lista de materias que se cursan a la par */
	private List<Materia> materias;

	/** duracion del periodo que se cursan todas las materias a la par */
	private Duracion lapso;

	public Nivel() {
		super();
		materias = new ArrayList<Materia>();
	}

	public Nivel(final Duracion lapso) {
		this();
		this.lapso = lapso;
	}

	public void addMaterias(final Materia materia) {
		materias.add(materia);
	}

	public void removeMaterias(final Materia materia) {
		materias.remove(materia);
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(final List<Materia> materias) {
		this.materias = materias;
	}

	public Duracion getLapso() {
		return lapso;
	}

	public void setLapso(final Duracion lapso) {
		this.lapso = lapso;
	}

	public String getNombreMaterias() {
		String mensaje = null;

		for (Materia materia : materias) {
			mensaje = mensaje + materia.getNombre();
		}

		return mensaje;
	}

}
