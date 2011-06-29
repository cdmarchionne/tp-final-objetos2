package materias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import personal.Alumno;
import personal.Docente;
import Utils.Nombrable;

/**
 * Materia. La duracion de una materia depende del Plan de estudio
 */
public class Materia implements Nombrable {

	private String nombre;

	private Docente titular;

	private Set<String> programa; // Lista de Temas, es un SET para poder
									// eliminar los repetidos sin hacer ningun
									// calculo.

	private List<String> requisitos;

	private Integer dificultad;

	private Integer horasSemanales;

	private Set<Catedra> catedras;

	private boolean promocionable;

	private List<InscripcionMateria> inscripciones;

	public Materia(final String nombre, final int dificultad) {/*
																 * La materia se
																 * crea solo con
																 * el nombre y
																 * la
																 * dificultad,
																 * el resto de
																 * las
																 * caracteristicas
																 * se van
																 * agregando
																 * luego
																 */
		this.nombre = nombre;
		this.dificultad = dificultad;
	}

	public List<InscripcionMateria> getInscripciones() {
		return inscripciones;
	}

	public void agregarInscripcion(final InscripcionMateria inscripcion) {
		this.getInscripciones().add(inscripcion);
		for (Catedra c : this.getCatedras()) { // Aca a la catedra que se
												// inscribio el alumno tambien
												// le agrego el alumno.
			if (c.equals(inscripcion.getCatedraElegida())) {
				c.agrgarAlumnoInscripto(inscripcion.getAlumno());
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

	public Set<Catedra> getCatedras() {
		return catedras;
	}

	public void agregarCatedra(final Catedra catedra) {
		this.getCatedras().add(catedra);
	}

	public void setTitular(final Docente titular) {
		this.titular = titular;
	}

	public Docente getTitular() {
		return titular;
	}

	public String getNombre() {
		return nombre;
	}

	public Set<String> getPrograma() {
		return programa;
	}

	public void agregarTema(final String tema) { /* Agrega un tema al programa */
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

	public void setNoPromocionable() {
		promocionable = false;
	}

	public void setPromocionable() {
		promocionable = true;
	}

}
