package entregas;

import java.util.Date;

import personal.Alumno;

/**
 * TODO: description
 */
public class EvaluacionParcial extends Evaluacion {

	public EvaluacionParcial(String titulo, Date fecha) {
		super(titulo, fecha);
	}

	public EvaluacionParcial(String titulo, Date fecha, Alumno alumno, Integer nota) {
		super(titulo, fecha, alumno, nota);
	}

}
