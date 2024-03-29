package Utils;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Manejo una lista de Antecedente (elementos con lapso de tiempo) Yo soy
 * responsable si el historial puede contener mas de un elementos en un mismo
 * lapso de tiempo o no.
 * 
 * Ejemplos:
 * En el caso de materias existentes en el area, pueden existir varias Materias
 * en el mismo lapso de tiempo.
 * Si manejo la lista de docentes de una catedra solo poseo un director en un
 * lapso de tiempo
 */
public class Historial<T> {

	private Set<Antecedente<T>> elementosRecordables;

	// *****************
	// * Constructores *
	// *****************
	public Historial() {
		super();
		elementosRecordables = new HashSet<Antecedente<T>>();
	}

	public Historial(Date fechaInicio, Date fechaFin, T elemento) {
		this();
		this.addAntecedente(fechaInicio, fechaFin, elemento);
	}

	// ********************
	// * Getter & Setters *
	// ********************
	public void addAntecedente(Antecedente<T> antecedente) {
		this.closeAntecedente(antecedente.getFechaInicio());
		elementosRecordables.add(antecedente);
	}

	public void addAntecedente(Date fechaInicio, Date fechaFin, T elemento) {
		this.addAntecedente(new Antecedente<T>(elemento, fechaInicio, fechaFin));
	}

	private Set<Antecedente<T>> getAntecedentes() {
		return elementosRecordables;
	}

	// ********************
	// * Funciones Utiles *
	// ********************
	/** Devuelvo las ocurrencias historicas de un elemento determinado */
	public Historial<T> getHistorialDelElemento(T elemento) {
		Historial<T> elementosHitoricos = new Historial<T>();

		for (Antecedente<T> antecedente : this.getAntecedentes()) {
			if (antecedente.sameElement(elemento)) {
				elementosHitoricos.addAntecedente(antecedente);
			}
		}

		return elementosHitoricos;
	}

	/** Devuelvo si existe el elemento que correspode a una fecha determinada */
	public T getElemento(Date fecha) {
		T elemento = null;

		for (Antecedente<T> antecedente : elementosRecordables) {
			if (antecedente.transcurrioEn(fecha)) {
				elemento = antecedente.getElemento();
			}
		}

		return elemento;
	}

	/** Devuelvo los elementos que correspode a una fecha determinada */
	public Set<T> getElementos(Date fecha) {
		Set<T> elementos = new HashSet<T>();

		for (Antecedente<T> antecedente : elementosRecordables) {
			if (antecedente.transcurrioEn(fecha)) {
				elementos.add(antecedente.getElemento());
			}
		}

		return elementos;
	}

	/** Devuelvo el elemento que correspode a una fecha determinada */
	public T getElementoEn(T elemento, Date fecha) {
		T elementoBuscado = null;

		for (Antecedente<T> antecedente : this.getHistorialDelElemento(elemento).getAntecedentes()) {
			if (antecedente.sameElement(elemento) && antecedente.transcurrioEn(fecha)) {
				elementoBuscado = antecedente.getElemento();
			}
		}

		return elementoBuscado;
	}

	/** Cierro un antecedente abierto en una fecha */
	public void closeAntecedente(Date fecha) {

		for (Antecedente<T> antecedente : elementosRecordables) {
			if (antecedente.transcurrioEn(fecha) && antecedente.getFechaFin() == null) {
				antecedente.setFechaFin(fecha);
			}
		}

	}

}
