package LogicaNegocio.Logica;

import java.awt.Color;

public class Colores {
    private Color colorBase;
    private Color colorResalte;
    private Color colorPresion;
    private Color colorLetra;
    
    public Colores(){
        this.colorBase = new Color(182, 180, 180);
        this.colorResalte = new Color(155, 155, 155);
        this.colorPresion = new Color(130, 130, 130);
        this.colorLetra = Color.black;
    }

    public Color getColorBase() {
        return colorBase;
    }
    public Color getColorResalte() {
        return colorResalte;
    }
    public Color getColorPresion() {
        return colorPresion;
    }
    public Color getColorLetra(){
        return this.colorLetra;
    }
}
