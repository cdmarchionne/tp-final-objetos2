package Utils;

import java.util.Date;

/**
 * Clase que le agrega colaboradores a un objeto para poder lograr trasabilidad
 * Gracias a los atributos de fecha podesmos ubicar un objeto en el tiempo.
 */
public class Antecedente<T> {

	private T elemento;

	private Date fechaInicio;

	private Date fechaFin;

	// *****************
	// * Constructores *
	// *****************
	public Antecedente() {
		super();
	}

	public Antecedente(T elemento) {
		this();
		this.elemento = elemento;
	}

	public Antecedente(T elemento, Date fechaInicio) {
		this(elemento);
		this.fechaInicio = fechaInicio;
	}

	public Antecedente(T elemento, Date fechaInicio, Date fechaFin) {
		this(elemento, fechaInicio);
		this.fechaFin = fechaFin;
	}

	// ********************
	// * Getter & Setters *
	// ********************
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public T getElemento() {
		return elemento;
	}

	public void setElemento(T elemento) {
		this.elemento = elemento;
	}

	public boolean sameElement(T otroElemento) {
		return this.elemento.equals(otroElemento);
	}

	// ********************
	// * Funciones Utiles *
	// ********************
	/** Verifico si un elemento esta en una fecha */
	public boolean transcurrioEn(Date fecha) {
		boolean rta = fecha == null;

		// La fecha es valida, entonces hay que compararla
		if (!rta) {
			if (fechaInicio != null) {
				rta = fecha.after(fechaInicio);
				if (fechaFin != null) {
					rta = rta && fecha.before(fechaFin);
				}
			}
		}

		return rta;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		boolean rta = false;

		if (!(obj == null || this.getClass() != obj.getClass())) {
			if (this == obj) {
				rta = true;
			} else {
				rta = this.isSame((Antecedente<T>) obj);
			}
		}
		return rta;
	}

	public boolean isSame(Antecedente<T> antecedente) {
		boolean rta;

		if (this.sameElement(antecedente) && this.sameFechaInicio(antecedente)
				&& this.sameFechaFin(antecedente)) {
			rta = true;
		} else {
			rta = false;
		}

		return rta;
	}

	/** Comparo que el Antecedente este hablando del mismo elemento */
	public boolean sameElement(Antecedente<T> antecedente) {
		return this.getElemento() == null ? antecedente.getElemento() == null : this.getElemento()
				.equals(antecedente.getElemento());
	}

	private boolean sameFechaInicio(Antecedente<T> antecedente) {
		return this.getFechaInicio() == null ? antecedente.getFechaInicio() == null : this
				.getFechaInicio().equals(antecedente.getFechaInicio());
	}

	private boolean sameFechaFin(Antecedente<T> antecedente) {
		return this.getFechaFin() == null ? antecedente.getFechaFin() == null : this.getFechaFin()
				.equals(antecedente.getFechaFin());
	}
}
