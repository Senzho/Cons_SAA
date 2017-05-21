package InterfazGrafica;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Button implements MouseListener{
    private JPanel boton;
    private JLabel imagen;
    private JLabel texto;
    private Colores colores;
    private CursorListener cursorListener;
    
    public Button(Colores colores, ImageIcon icono, String texto){
        this.colores=colores;
        FlowLayout flowNuevoCurso = new FlowLayout();
        flowNuevoCurso.setVgap(5);
        flowNuevoCurso.setHgap(5);
        this.boton = new JPanel();
        this.boton.setLayout(flowNuevoCurso);
        this.boton.setBackground(colores.getColorBase());
        this.boton.add(this.imagen=new JLabel());
        this.boton.add(this.texto=new JLabel(texto));
        this.boton.setName("Agregar Curso");
        this.boton.addMouseListener(this);
        this.texto.setFont(new Font("Arial", Font.PLAIN, 20));
        this.texto.setForeground(colores.getColorLetra());
        this.imagen.setIcon(icono);
        this.imagen.setOpaque(true);
        this.imagen.setBackground(colores.getColorBase());
        this.imagen.addMouseListener(this);
        this.texto.setOpaque(true);
        this.texto.setBackground(colores.getColorBase());
        this.texto.addMouseListener(this);
    }
    
    public JPanel getButton(){
        return this.boton;
    }
    public void addCursorListener(CursorListener listener){
        this.cursorListener=listener;
    }
    public void setVisible(boolean visible){
        this.boton.setVisible(visible);
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        
    }
    @Override
    public void mousePressed(MouseEvent evento) {
        if (evento.getSource().equals(this.imagen) || evento.getSource().equals(this.texto) || evento.getSource().equals(this.boton)){
            this.boton.setBackground(colores.getColorPresion());
            this.imagen.setBackground(colores.getColorPresion());
            this.texto.setBackground(colores.getColorPresion());
        }
    }
    @Override
    public void mouseReleased(MouseEvent evento) {
        if (evento.getSource().equals(this.imagen) || evento.getSource().equals(this.texto) || evento.getSource().equals(this.boton)){
            this.boton.setBackground(colores.getColorResalte());
            this.imagen.setBackground(colores.getColorResalte());
            this.texto.setBackground(colores.getColorResalte());
            if (this.cursorListener!=null){
                this.cursorListener.cursorClicked(this);
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent evento) {
        if (evento.getSource().equals(this.imagen) || evento.getSource().equals(this.texto) || evento.getSource().equals(this.boton)){
            this.boton.setBackground(colores.getColorResalte());
            this.imagen.setBackground(colores.getColorResalte());
            this.texto.setBackground(colores.getColorResalte());
        }
    }
    @Override
    public void mouseExited(MouseEvent evento) {
        if (evento.getSource().equals(this.imagen) || evento.getSource().equals(this.texto) || evento.getSource().equals(this.boton)){
            this.boton.setBackground(colores.getColorBase());
            this.imagen.setBackground(colores.getColorBase());
            this.texto.setBackground(colores.getColorBase());
        }
    }
}
