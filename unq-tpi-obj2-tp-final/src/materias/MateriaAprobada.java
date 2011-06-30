package materias;

/**
 * Recuerda la nota con la que le cerro una Materia al Alumno
 */
public class MateriaAprobada {

	private Materia materia;

	private float nota;

	public MateriaAprobada(Materia materia, float nota) {
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

}
