package personal;

import java.util.List;

public class Alumno {

    private Persona datosPersonales;

    private Integer legajo;

    private List<?> entregas;

    private List<?> carrerasInscriptas;

    private List<?> materiasInscriptas;

    private List<?> materiasAprobadas;

    public Alumno(final Persona datosPersonales, final Integer legajo) {
        super();
        this.datosPersonales = datosPersonales;
        this.legajo = legajo;
    }

    public List<?> getEntregas() {
        return entregas;
    }

    public void setEntregas(final List<?> entregas) {
        this.entregas = entregas;
    }

    public List<?> getCarrerasInscriptas() {
        return carrerasInscriptas;
    }

    public void setCarrerasInscriptas(final List<?> carrerasInscriptas) {
        this.carrerasInscriptas = carrerasInscriptas;
    }

    public List<?> getMateriasInscriptas() {
        return materiasInscriptas;
    }

    public void setMateriasInscriptas(final List<?> materiasInscriptas) {
        this.materiasInscriptas = materiasInscriptas;
    }

    public List<?> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void setMateriasAprobadas(final List<?> materiasAprobadas) {
        this.materiasAprobadas = materiasAprobadas;
    }

    public Persona getDatosPersonales() {
        return datosPersonales;
    }

    public void setDatosPersonales(final Persona datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public void setLegajo(final Integer legajo) {
        this.legajo = legajo;
    }
}
