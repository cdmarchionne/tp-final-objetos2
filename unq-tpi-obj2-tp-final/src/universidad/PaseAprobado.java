package universidad;

import java.util.Date;

import personal.Docente;

/**
 * Aprobado
 */
public class PaseAprobado extends EstadoPase {

	public PaseAprobado(PaseDocente memorandum) {
		super(memorandum);
	}

	@Override
	public String getNombre() {
		return "Aprobado";
	}

	@Override
	public void run() {
		Docente docenteSolicitante = getMemorandum().getSolicitante();
		
		getMemorandum().getAreaOrigen().removeDocente(docenteSolicitante, new Date());
		getMemorandum().getAreaDestino().addDocente(docenteSolicitante, new Date());
	}

}
