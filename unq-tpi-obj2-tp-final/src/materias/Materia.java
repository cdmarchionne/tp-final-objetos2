package src.materias;

import java.util.List;
import java.util.Set;

import src.Utils.Nombrable;
import src.personal.Docente;



/**
 * Materia. La duracion de una materia depende del Plan de estudio
 */
public class Materia implements Nombrable {

	private String nombre;

	private Docente titular;

	private List<String> programa; // Lista de Temas

	private List<String> requisitos;

	private Integer dificultad;

	private Integer horasSemanales;

	private Set< Catedra > catedras;

	/** Calculo los creditos de la materia */
	public Integer getCreditos() {
		return horasSemanales * dificultad;
	}

	public String getNombre() {
		return nombre;
	}

}
