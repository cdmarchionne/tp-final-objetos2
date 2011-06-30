package materias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import model.interfaces.CatedraIMPL;
import model.interfaces.MateriaIMPL;
import personal.Alumno;
import personal.Docente;
import Utils.Nombrable;

/**
 * Materia. La duracion de una materia depende del Plan de estudio
 */
public class Materia implements Nombrable, MateriaIMPL {

	private String nombre;

	private Docente titular;

	// Lista de Temas, es un SET para poder eliminar los repetidos sin hacer
	// ningun calculo.
	private Set<String> programa;

	private List<String> requisitos;

	private Integer dificultad;

	private Integer horasSemanales;

	private Set<Catedra> catedras;

	private boolean promocionable;

	private List<InscripcionMateria> inscripciones;

	/**
	 * La materia se crea solo con el nombre y la dificultad, el resto de las
	 * caracteristicas se van agregando luego
	 */
	public Materia(final String nombre, final int dificultad) {
		this.nombre = nombre;
		this.dificultad = dificultad;
	}

	public List<InscripcionMateria> getInscripciones() {
		return inscripciones;
	}

	public void agregarInscripcion(final InscripcionMateria inscripcion) {
		this.getInscripciones().add(inscripcion);
		// Aca a la catedra que se inscribio el alumno tambien le agrego el
		// alumno.
		for (Catedra c : this.getTodasLasCatedras()) {
			if (c.equals(inscripcion.getCatedraElegida())) {
				c.agregarAlumnoInscripto(inscripcion.getAlumno());
			}

		}
	}

	/** Calculo los creditos de la materia */
	public Integer getCreditos() {
		return horasSemanales * dificultad;
	}

	public void setHorasSemanales(final int horas) {
		horasSemanales = horas;
	}

	public List<String> getRequisitos() {
		return requisitos;
	}

	public void agregarRequisito(final String requisito) {
		this.getRequisitos().add(requisito);
	}

	public Set<Catedra> getTodasLasCatedras() {
		return catedras;
	}

	public void addCatedra(final Catedra catedra) {
		catedras.add(catedra);
	}

	public void removeCatedra(final Catedra catedra) {
		catedras.remove(catedra);
	}

	public void setTitular(final Docente titular) {
		this.titular = titular;
	}

	public Docente getTitular() {
		return titular;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public Set<String> getPrograma() {
		return programa;
	}

	/** Agrega un tema al programa */
	public void agregarTema(final String tema) {
		this.getPrograma().add(tema);
	}

	public List<Alumno> getAlumnosInscriptosEn(final Date fecha) {
		ArrayList<Alumno> listaFinal = new ArrayList<Alumno>();

		for (InscripcionMateria inscripcion : this.getInscripciones()) {
			if (inscripcion.getFechaInscripcion().equals(fecha)) {
				listaFinal.add(inscripcion.getAlumno());
			}

		}
		return listaFinal;
	}

	public Integer getDificultad() {
		return dificultad;
	}

	public Integer getHorasSemanales() {
		return horasSemanales;
	}

	public boolean esPromocionable() {
		return promocionable;
	}

	public void setPromocionable(Boolean promocionable) {
		this.promocionable = promocionable;
	}

	public void setNoPromocionable() {
		this.setPromocionable(false);
	}

	public void setPromocionable() {
		this.setPromocionable(true);
	}

	public List<CatedraIMPL> getCatedras() {
		return new ArrayList<CatedraIMPL>(this.getTodasLasCatedras());
	}

	@Override
	public String toString() {
		return this.getNombre();
	}
}
