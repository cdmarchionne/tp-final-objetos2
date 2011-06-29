package materias;

import java.util.Set;

/**
 * Adapter de Materias que varian por Plan de Estudio
 */
public class MateriaAsignadaAPlanDeEstudio {

	private Materia materia;

	private TipoDeMateria tipoDeMateria;

	private Duracion duracion;

	private Set<Materia> correlatividades;

	
	

	public MateriaAsignadaAPlanDeEstudio(Materia materia,TipoDeMateria tipo, Duracion duracion){
		this.materia = materia;
		this.tipoDeMateria = tipo;
		this.duracion = duracion;
		
	}




	public Materia getMateria() {
		return materia;
	}


	public void setMateria(Materia materia) {
		this.materia = materia;
	
	}

	public TipoDeMateria getTipoDeMateria() {
		return tipoDeMateria;
	}


	public void setTipoDeMateria(TipoDeMateria tipoDeMateria) {
		this.tipoDeMateria = tipoDeMateria;
	}


	public Duracion getDuracion() {
		return duracion;
	}


	public void setDuracion(Duracion duracion) {
		this.duracion = duracion;
	}

	
	public Set<Materia> getCorrelatividades() {
		return correlatividades;
	}


	public void setCorrelatividades(Set<Materia> correlatividades) {/*Este metodo se puede dejar por si se quiere agregar un SET de correlatividades.*/
		this.correlatividades = correlatividades;					/*Por ejemplo para algo en comun a todas las materias*/
	}


	public void agregarMateriaCorrelativa(Materia materia){
		this.getCorrelatividades().add(materia);
	}






}
