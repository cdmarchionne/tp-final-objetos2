package materias;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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

	private final String nombre;
	private Docente titular;

	// Lista de Temas, es un SET para poder eliminar los repetidos sin hacer
	// ningun calculo.
	private final Set<String> programa;
	private final List<String> requisitos;
	private final Integer dificultad;
	private Integer horasSemanales;
	private final Set<Catedra> catedras;
	private boolean promocionable;

	/**
	 * La materia se crea solo con el nombre y la dificultad, el resto de las
	 * caracteristicas se van agregando luego
	 */
	public Materia(String nombre, int dificultad) {
		this.nombre = nombre;
		this.dificultad = dificultad;
		programa = new HashSet<String>();
		requisitos = new ArrayList<String>();
		horasSemanales = 0;
		catedras = new HashSet<Catedra>();
		promocionable = false;
	}

	/** Calculo los creditos de la materia */
	public Integer getCreditos() {
		return horasSemanales * dificultad;
	}

	public void setHorasSemanales(int horas) {
		horasSemanales = horas;
	}

	public List<String> getRequisitos() {
		return requisitos;
	}

	public void agregarRequisito(String requisito) {
		this.getRequisitos().add(requisito);
	}

	public Set<Catedra> getTodasLasCatedras() {
		return catedras;
	}

	public void addCatedra(Catedra catedra) {
		catedras.add(catedra);
	}

	public void removeCatedra(Catedra catedra) {
		catedras.remove(catedra);
	}

	public void setTitular(Docente titular) {
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
	public void agregarTema(String tema) {
		this.getPrograma().add(tema);
	}

	public List<Alumno> getAlumnosInscriptosEn() {
		ArrayList<Alumno> listaFinal = new ArrayList<Alumno>();

		for (Catedra catedra : (Catedra[]) this.getCatedras().toArray()) {
			listaFinal.addAll(catedra.getAlumnosInscriptos());
		}

		return listaFinal;
	}

	public List<Alumno> getAlumnosInscriptosEn(Date fecha) {
		ArrayList<Alumno> listaFinal = new ArrayList<Alumno>();

		for (Catedra catedra : (Catedra[]) this.getCatedras().toArray()) {
			for (Alumno alumno : catedra.getAlumnosInscriptos()) {
				// TODO: Ver quien lleva el historial de materias inscriptas
				// alguna fecha determinada

				// if(alumno.getCursoDeIngreso()){
				listaFinal.add(alumno);
				// }
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

	@Override
	public List<CatedraIMPL> getCatedras() {
		return new ArrayList<CatedraIMPL>(this.getTodasLasCatedras());
	}

	@Override
	public String toString() {
		return this.getNombre();
	}
}
