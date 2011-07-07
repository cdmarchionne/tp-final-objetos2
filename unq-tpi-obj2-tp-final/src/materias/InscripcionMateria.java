package materias;

import java.util.Date;

/**
 * Adapter que agrupa los datos necesarios para Inscribir un Alumno en una
 * Materia
 */
public class InscripcionMateria {

	private Date fechaInscripcion;
	private Materia materiaElegida;
	public Catedra catedraElegida;

	public InscripcionMateria(Materia materia, Catedra catedra) {
		this.fechaInscripcion = new Date(); // Fecha actual del sistema.
		this.materiaElegida = materia;
		this.setCatedraElegida(catedra);
	}

	private void setCatedraElegida(Catedra catedra) {
		this.catedraElegida = catedra;
	}

	public Catedra getCatedraElegida() {
		return catedraElegida;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Materia getMateriaElegida() {
		return materiaElegida;
	}

	public void setMateriaElegida(Materia materiaElegida) {
		this.materiaElegida = materiaElegida;
	}

}
