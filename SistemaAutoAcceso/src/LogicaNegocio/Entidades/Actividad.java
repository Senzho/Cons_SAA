package LogicaNegocio.Entidades;

public class Actividad {
    private DatosActividad datosActividad;
    private DatosExperiencia datosExperiencia;

    public Actividad(DatosActividad datosActividad, DatosExperiencia datosExperiencia) {
        this.datosActividad = datosActividad;
        this.datosExperiencia = datosExperiencia;
    }

    public DatosActividad getDatosActividad() {
        return datosActividad;
    }
    public DatosExperiencia getDatosExperiencia() {
        return datosExperiencia;
    }
}
