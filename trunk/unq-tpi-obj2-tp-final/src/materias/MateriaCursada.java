package materias;

import Utils.Nombrable;

/**
 * Recuerda la nota con la que le cerro una Materia al Alumno
 */
public class MateriaCursada implements Nombrable{

	private Materia materia;

	private float nota;

	public MateriaCursada(Materia materia, float nota) {
		super();
		this.materia = materia;
		this.nota = nota;
	}

	public Materia getMateria() {
		return materia;
	}

	public float getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return getNombre();
	}

	@Override
	public String getNombre() {
		return getMateria().getNombre()+" = "+getNota();
	}

	
	
}
