package InterfazGrafica;

import LogicaNegocio.Logica.ComboBox;

public class CombosModuloSeccion {
    public void cargarComboMoulo(ComboBox comboModulo){
        for(int i = 1; i<4; i++){
            comboModulo.addString(""+i);
        }
    }
    public void cargarComboSeccion(ComboBox comboSeccion){
        for(int i = 1; i<5; i++){
            comboSeccion.addString(""+i);
        }
    }
}
