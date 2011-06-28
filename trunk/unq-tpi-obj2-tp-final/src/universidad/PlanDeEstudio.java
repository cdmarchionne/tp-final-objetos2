package src.universidad;

import java.util.Date;
import java.util.List;
import java.util.Set;

import src.materias.MateriaAsignadaAPlanDeEstudio;
import src.personal.Docente;

public class PlanDeEstudio {

	private String nombre;

	private Date fechaDeCreacion;

	private Docente director;

	private List<MateriaAsignadaAPlanDeEstudio> materias;

	private Set<RecorridoSugerido> ordenesSugeridos;

}
