package materias;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.interfaces.AlumnoIMPL;
import model.interfaces.CatedraIMPL;
import personal.Alumno;
import Utils.Historial;
import Utils.Nombrable;
import entregas.EntregaTP;
import entregas.Evaluacion;
import entregas.TrabajoPractico;
import entregas.TrabajoPracticoIndividual;

/**
 * Catedra
 */
// Almeceno el Historial del Staff Completo
public class Catedra implements Nombrable, CatedraIMPL {

	/** Guardar el historial de Docentes */
	private Historial<StaffCatedra> staff;
	private String nombre;
	private Set<TrabajoPractico> tp;
	private Set<Evaluacion> examenes;
	private Set<Alumno> alumnosInscriptos;
	// Cuando un alumno entrega un TP, se guarda tmb en la catedra
	private List<EntregaTP> entregasDeAlumnos; 

	public Catedra(String nombre, Materia materia) {
		this(nombre);
		materia.addCatedra(this);
	}
	
	private Catedra(String nombre) {
		super();
		this.nombre=nombre;
		staff = new Historial<StaffCatedra>();
		tp = new HashSet<TrabajoPractico>();
		examenes = new HashSet<Evaluacion>();
		alumnosInscriptos = new HashSet<Alumno>();
		entregasDeAlumnos = new ArrayList<EntregaTP>();
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	public StaffCatedra getStaff() {
		return staff.getElemento(new Date());
	}

	public void setStaff(StaffCatedra staffNuevo) {
		staff.addAntecedente(new Date(), null, staffNuevo);
	}

	public Set<TrabajoPractico> getTp() {
		return tp;
	}

	public Set<Evaluacion> getExamenes() {
		return examenes;
	}

	public void setExamenes(Set<Evaluacion> examenes) {
		this.examenes = examenes;
	}

	public Set<Alumno> getAlumnosInscriptos() {
		return alumnosInscriptos;
	}

	public void agregarAlumnoInscripto(Alumno alumno) {
		this.getAlumnosInscriptos().add(alumno);
	}

	public void removeAlumno(Alumno alumno) {
		alumnosInscriptos.remove(alumno);
	}

	public void agregarEvaluacion(Evaluacion evaluacion) {
		this.getExamenes().add(evaluacion);

	}

	public void agregarTrabajoPractico(TrabajoPractico tp) {
		this.getTp().add(tp);
	}

	public List<EntregaTP> getEntregasTPs() {
		return entregasDeAlumnos;
	}

	public void addEntrega(EntregaTP entrega) {
		this.getEntregasTPs().add(entrega);
	}

	public ArrayList<EntregaTP> getTPSDe(Alumno alumno) { /*
														 * Devuelve la
														 * lista de tps
														 * de un alumno
														 */
		ArrayList<EntregaTP> listaEntregas = new ArrayList<EntregaTP>();
		for (EntregaTP entrega : this.getEntregasTPs()) {
			if (entrega.getAlumno().equals(alumno)) {
				listaEntregas.add(entrega);
			}
		}

		return listaEntregas;
	}

	/** Devuelve los alumnos que entregaron cierto TP */
	public ArrayList<Alumno> getAlumnosEntregaronTP(TrabajoPractico tp) {
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		for (EntregaTP entrega : this.getEntregasTPs()) {
			if (entrega.getTp().equals(tp)) {
				listaAlumnos.add(entrega.getAlumno());
			}
		}
		return listaAlumnos;

	}

	/** Devuelve las entregas de cierto TP */
	public ArrayList<EntregaTP> getEntregasTP(TrabajoPractico tp) {
		ArrayList<EntregaTP> listaEntregas = new ArrayList<EntregaTP>();
		for (EntregaTP entrega : this.getEntregasTPs()) {
			if (entrega.getTp().equals(tp)) {
				listaEntregas.add(entrega);
			}
		}
		return listaEntregas;

	}

	public Alumno getMejorAlumnoDeEntrega(TrabajoPracticoIndividual tp) {
		TrabajoPracticoIndividual ganador = tp;

		for (EntregaTP entrega : this.getEntregasTP(tp)) {
			if (!this.mayorNota(ganador, entrega)) {
				ganador = (TrabajoPracticoIndividual) entrega.getTp();
			} else {
				if (this.compararNombre(ganador.getAlumnos(), tp.getAlumnos())) {
					ganador = (TrabajoPracticoIndividual) entrega.getTp();
				}
			}
		}

		return ganador.getAlumnos();

	}

	/** Devuelve True la nota Mayor la tiene el ganador o lo entrego antes */
	private boolean mayorNota(TrabajoPracticoIndividual ganador, EntregaTP entrega) {
		boolean rta = false;

		if (ganador.getNota() == entrega.getNota()) {
			rta = ganador.getFechaReal().before(entrega.getTp().getFechaReal());
		} else {
			rta = ganador.getNota() > entrega.getNota();
		}

		return rta;
	}

	/**
	 * Devuelve True si el nombre del alumno Tp esta antes que el del ganador
	 * ordenado alfabeticamente
	 */
	private boolean compararNombre(Alumno alumnoGanador, Alumno alumnoTp) {
		boolean ordenNombre = false;
		// Si la fecha no esta ni antes ni despues,
		// coinciden.

		int compApellido = alumnoGanador.getApellido().compareTo(alumnoTp.getApellido());
		ordenNombre = compApellido > 0; // Si el apellido esta antes
		if (compApellido == 0) {// Si tienen mismo apellido. Comparo por nombre
			int compName = alumnoGanador.getNombre().compareTo(alumnoTp.getNombre());
			ordenNombre = compName > 0; // Si el nombre esta antes
		}
		return ordenNombre;
	}

	@Override
	public List<AlumnoIMPL> getInscriptos() {
		return new ArrayList<AlumnoIMPL>(this.getAlumnosInscriptos());
	}

}
