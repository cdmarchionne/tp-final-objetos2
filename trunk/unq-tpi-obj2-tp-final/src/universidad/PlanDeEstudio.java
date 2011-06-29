package universidad;

import java.util.Date;
import java.util.List;
import java.util.Set;

import materias.MateriaAsignadaAPlanDeEstudio;
import personal.Docente;

public class PlanDeEstudio {

	private String nombre;

	private Date fechaDeCreacion;

	private Docente director;

	private List<MateriaAsignadaAPlanDeEstudio> materias;

	private Set<RecorridoSugerido> ordenesSugeridos;

}
