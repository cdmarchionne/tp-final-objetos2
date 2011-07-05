package materias;

import java.util.List;

import personal.Alumno;
import personal.Docente;

/**
 * Guardar el Historial del Staff de las Catedras
 */
public class StaffCatedra {

	private Docente responsable;
	private Docente jefeTP;
	private List<Docente> instructores;
	private List<Alumno> colaboradores;

	public StaffCatedra(Docente responsable, Docente jefeTP, List<Docente> instructores,
			List<Alumno> colaboradores) {
		super();
		this.responsable = responsable;
		this.jefeTP = jefeTP;
		this.instructores = instructores;
		this.colaboradores = colaboradores;
	}

	public Docente getResponsable() {
		return responsable;
	}

	public void setResponsable(Docente responsable) {
		this.responsable = responsable;
	}

	public Docente getJefeTP() {
		return jefeTP;
	}

	public void setJefeTP(Docente jefeTP) {
		this.jefeTP = jefeTP;
	}

	public List<Docente> getInstructores() {
		return instructores;
	}

	public void setInstructores(List<Docente> instructores) {
		this.instructores = instructores;
	}

	public List<Alumno> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Alumno> colaboradores) {
		this.colaboradores = colaboradores;
	}

}
