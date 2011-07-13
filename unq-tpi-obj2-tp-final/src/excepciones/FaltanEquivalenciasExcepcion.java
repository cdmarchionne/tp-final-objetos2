package excepciones;

import java.util.Set;

import materias.Materia;
import personal.Alumno;

public class FaltanEquivalenciasExcepcion extends Exception {
	private static final long serialVersionUID = 1L;

	public FaltanEquivalenciasExcepcion(Alumno alumno, Materia materia, Set<Materia> correlativas) {
		new Exception("El alumno " + alumno.getNombre() + " no se puede inscribir a la materia "
				+ materia.getNombre() + " hasta haber aprobado las materias correlativas: "
				+ correlativas);
	}

}
