package personal;

public class Docente {

    private Persona datosPersonales;

    private Integer legajo;

    public Docente(final Persona datosPersonales, final Integer legajo) {
        super();
        this.datosPersonales = datosPersonales;
        this.legajo = legajo;
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
