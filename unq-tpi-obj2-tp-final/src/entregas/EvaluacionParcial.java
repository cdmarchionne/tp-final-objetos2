package entregas;

import java.util.Date;

import personal.Alumno;

/**
 * Evaluacion Parcial
 */
public class EvaluacionParcial extends Evaluacion {

	public EvaluacionParcial(String titulo, Date fecha) {
		super(titulo, fecha);
	}

	public EvaluacionParcial(String titulo, Date fecha, Alumno alumno, Integer nota) {
		super(titulo, fecha, alumno, nota);
	}

}
