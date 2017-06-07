package InterfazGrafica;

import java.awt.Color;

public class Colores {
    private Color colorBase;
    private Color colorResalte;
    private Color colorPresion;
    private Color colorLetra;
    
    public Colores(){
        this.colorBase = new Color(223, 223, 223);
        this.colorResalte = new Color(202, 202, 202);
        this.colorPresion = new Color(183, 183, 183);
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
