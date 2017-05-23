package InterfazGrafica;

import java.util.EventListener;

public interface SelectionListener extends EventListener{
    public void bloqueSeleccionado(BloqueActividad bloque);
    public void bloqueDeseleccionado(BloqueActividad bloque);
}
