package entregas;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import materias.Duracion;
import personal.Alumno;

/**
 * Evaluacion Final
 */
public class EvaluacionFinal extends Evaluacion {

	private Map<Duracion, Integer> limiteRendiciones;

	public EvaluacionFinal(String titulo, Date fecha) {
		super(titulo, fecha);
		limiteRendiciones = new HashMap<Duracion, Integer>();
	}

	public EvaluacionFinal(String titulo, Date fecha, Alumno alumno, Integer nota) {
		super(titulo, fecha, alumno, nota);
	}

	public void addLimiteRendiciones(Duracion duracion, Integer limite) {
		limiteRendiciones.put(duracion, limite);
	}

	public Integer getLimiteRendiciones(Duracion duracion) {
		return limiteRendiciones.get(duracion);
	}

}
