package materias;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import personal.Alumno;
import Utils.Historial;
import entregas.EntregaTP;
import entregas.Evaluacion;
import entregas.TrabajoPractico;
import entregas.TrabajoPracticoIndividual;

/**
 * Catedra
 */
// Almeceno el Historial del Staff Completo
public class Catedra {

	/** Guardar el historial de Docentes */
	private Historial<StaffCatedra> staff;
	private String nombre;
	private Set<TrabajoPractico> tp;
	private Set<Evaluacion> examenes;
	private Set<Alumno> alumnosInscriptos;
	private List<EntregaTP> entregasDeAlumnos; // Cuando un alumno entrega un
												// TP, se guarda tmb en la
												// catedra

	public Catedra(final String nombre) {
		this.setNombre(nombre);
		staff = new Historial<StaffCatedra>();
		tp = new HashSet<TrabajoPractico>();
		examenes = new HashSet<Evaluacion>();
		alumnosInscriptos = new HashSet<Alumno>();
		entregasDeAlumnos = new ArrayList<EntregaTP>();
	}

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

	public void setStaff(final StaffCatedra staffNuevo) {
		staff.addAntecedente(new Date(), null, staffNuevo);
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public Set<TrabajoPractico> getTp() {
		return tp;
	}

	public Set<Evaluacion> getExamenes() {
		return examenes;
	}

	public void setExamenes(final Set<Evaluacion> examenes) {
		this.examenes = examenes;
	}

	public Set<Alumno> getInscriptos() {
		return alumnosInscriptos;
	}

	public void setAlumnosInscriptos(final Set<Alumno> alumnosInscriptos) {
		this.alumnosInscriptos = alumnosInscriptos;
	}

	public void agrgarAlumnoInscripto(final Alumno alumno) {
		this.getInscriptos().add(alumno);

	}

	public void agregarEvaluacion(final Evaluacion evaluacion) {
		this.getExamenes().add(evaluacion);

	}

	public void agregarTrabajoPractico(final TrabajoPractico tp) {
		this.getTp().add(tp);
	}

	public List<EntregaTP> getEntregasTPs() {
		return entregasDeAlumnos;
	}

	public void addEntrega(final EntregaTP entrega) {
		this.getEntregasTPs().add(entrega);
	}

	public ArrayList<EntregaTP> getTPSDe(final Alumno alumno) { /*
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

	public ArrayList<Alumno> getAlumnosEntregaronTP(final TrabajoPractico tp) {/*
																				 * Devuelve
																				 * los
																				 * alumnos
																				 * que
																				 * entregaron
																				 * cierto
																				 * TP
																				 */
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		for (EntregaTP entrega : this.getEntregasTPs()) {
			if (entrega.getTp().equals(tp)) {
				listaAlumnos.add(entrega.getAlumno());
			}
		}
		return listaAlumnos;

	}

	public ArrayList<EntregaTP> getEntregasTP(final TrabajoPractico tp) {/*
																		 * Devuelve
																		 * las
																		 * entregas
																		 * de
																		 * cierto
																		 * TP
																		 */
		ArrayList<EntregaTP> listaEntregas = new ArrayList<EntregaTP>();
		for (EntregaTP entrega : this.getEntregasTPs()) {
			if (entrega.getTp().equals(tp)) {
				listaEntregas.add(entrega);
			}
		}
		return listaEntregas;

	}

	public Alumno getMejorAlumnoDeEntrega(final TrabajoPracticoIndividual tp) {
		TrabajoPracticoIndividual ganador = tp;
		for (EntregaTP entrega : this.getEntregasTP(tp)) {
			if (ganador.getNota() < entrega.getNota()) {
				ganador = (TrabajoPracticoIndividual) entrega.getTp();
			} else {
				if (ganador.getNota() > entrega.getNota()) {
					// No hacer nada.
				} else {/* Si no es menor ni es mayor, entonces es igual */
					if (ganador.getFechaReal().before(entrega.getTp().getFechaReal())) {
						// No hacer nada
					} else {
						if (ganador.getFechaReal().after(entrega.getTp().getFechaReal())) {
							ganador = (TrabajoPracticoIndividual) entrega.getTp();
						} else { // Si la fecha no esta ni antes ni despues,
									// coinciden.
							int comp = ganador.getAlumnos().getApellido()
									.compareTo(tp.getAlumnos().getApellido());
							if (comp < 0) {// No se hace nada.}
								if (comp > 0) {
									ganador = (TrabajoPracticoIndividual) entrega.getTp();
								}
								if (comp == 0) {// Si da 0 es porque tienen
												// mismo apellido. Comparo por
												// nombre
									int name = ganador.getAlumnos().getNombre()
											.compareTo(tp.getAlumnos().getNombre());
									if (name < 0) {// No se hace nada}
										if (name > 0) {
											ganador = (TrabajoPracticoIndividual) entrega.getTp();
										}
									}
								}
							}
						}
					}

				}

			}

		}
		return ganador.getAlumnos();
	}

}
