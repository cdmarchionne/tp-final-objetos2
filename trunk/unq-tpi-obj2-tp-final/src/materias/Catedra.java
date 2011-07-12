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
import excepciones.NoSeEncuentraTPException;

/**
 * Catedra
 */
// Almeceno el Historial del Staff Completo
public class Catedra implements Nombrable, CatedraIMPL {

	/** Guardar el historial de Docentes */
	private final Historial<StaffCatedra> staff;
	private final String nombre;
	private final Set<TrabajoPractico> trabajosPracticos;// Lista de trabajos
															// practicos.
	private Set<Evaluacion> examenes;
	private final Set<Alumno> alumnosInscriptos;

	// Cuando un alumno entrega un TP, se guarda tmb en la catedra

	public Catedra(String nombre, Materia materia) {
		this(nombre);
		materia.addCatedra(this);
	}

	private Catedra(String nombre) {
		super();
		this.nombre = nombre;
		staff = new Historial<StaffCatedra>();
		trabajosPracticos = new HashSet<TrabajoPractico>();
		examenes = new HashSet<Evaluacion>();
		alumnosInscriptos = new HashSet<Alumno>();

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

	public Set<TrabajoPractico> getTPs() {
		return trabajosPracticos;
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
		trabajosPracticos.add(tp);
	}

	/** Devuelve el trabajo practico indicado por parametro */
	public TrabajoPractico getTP(TrabajoPractico tp) {

		for (TrabajoPractico trabajo : this.getTPs()) {
			if (trabajo.equals(tp))
				return trabajo;
		}

		// Si no lo encuentra lanza la exepcion.
		throw new NoSeEncuentraTPException();
	}

	/**
	 * Devuelve las entregas de TPS de un alumno en particular. Si no hay
	 * ninguna devuelve la lista vacia.
	 */
	public Set<EntregaTP> getTPSDe(Alumno alumno) {
		Set<EntregaTP> resultado = new HashSet<EntregaTP>();

		for (TrabajoPractico trabajo : trabajosPracticos) {
			if (trabajo.alumnoHizoEntrega(alumno)) {
				resultado.add(trabajo.getEntregaDe(alumno));
			}

		}

		return resultado;

	}

	/** Devuelve los alumnos que entregaron cierto TP */
	public Set<Alumno> getAlumnosEntregaronTP(TrabajoPractico tp) {
		return tp.alumnosQueEntregaron();
	}

	/** Devuelve las entregas de un cierto Trabajo Practico */
	private Set<EntregaTP> getEntregasTP(TrabajoPractico tp) {
		return tp.getEntregas();
	}

	/**
	 * Devuelve el mejor alumno del un determinado Trabajo
	 * Practico
	 */
	public Alumno getMejorAlumnoDeEntrega(TrabajoPractico tp) {

		EntregaTP entregaGanadora = this.getEntregasTP(tp).iterator().next();

		for (EntregaTP entrega : this.getEntregasTP(tp)) {
			if (!this.mayorNota(entregaGanadora, entrega)) {
				entregaGanadora = entrega;
			} else {
				Alumno alumnoEntrega = entrega.getAlumnoMenorNombre();
				if (this.compararNombre(entregaGanadora.getAlumnoMenorNombre(), alumnoEntrega)) {
					entregaGanadora = entrega;
				}
			}
		}

		// Devuelve el menor alumno por decicion nuestra.
		return entregaGanadora.getAlumnoMenorNombre();
	}

	/** Devuelve True la nota Mayor la tiene el ganador o lo entrego antes */
	private boolean mayorNota(EntregaTP ganador, EntregaTP entrega) {
		boolean rta = false;

		if (ganador.getNota() == entrega.getNota()) {
			rta = ganador.getFechaEntregado().before(entrega.getFechaEntregado());
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
