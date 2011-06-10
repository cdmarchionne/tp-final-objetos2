package materias;

import java.util.List;

import Utils.Nombrable;

/**
 * Materia. La duracion de una materia depende del Plan de estudio
 */
public class Materia implements Nombrable {

	private String nombre;

	private List<String> programa; // Lista de Temas

	private List<String> requisitos;

	private Integer dificultad;

	private Integer horasSemanales;

	private List<Catedra> catedras;

	/** Calculo los creditos de la materia */
	public Integer getCreditos() {
		return horasSemanales * dificultad;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

}
