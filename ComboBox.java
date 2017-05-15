package LogicaNegocio.Logica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

public class ComboBox implements MouseListener{
    private JPanel comboBox;
    private JLabel botonCombo;
    private JLabel texto;
    private JPopupMenu menu;
    private JScrollPane scrollElementos;
    private JPanel lista;
    private Colores colores;
    private boolean visible;
    private boolean primerElemento;
    private String elementoSeleccionado;
    
    public ComboBox(Colores colores, ImageIcon icono){
        this.colores=colores;
        FlowLayout flowCombo = new FlowLayout();
        flowCombo.setVgap(0);
        flowCombo.setHgap(0);
        comboBox = new JPanel(flowCombo);
        comboBox.setBorder(BorderFactory.createLineBorder(colores.getColorBase()));
        comboBox.setBackground(colores.getColorBase());
        comboBox.add(texto = new JLabel());
        comboBox.addMouseListener(this);
        texto.setOpaque(true);
        texto.setBackground(colores.getColorBase());
        texto.setForeground(colores.getColorLetra());
        texto.setFont(new Font("Arial", Font.PLAIN, 20));
        texto.setName("seleccion");
        texto.addMouseListener(this);
        comboBox.add(botonCombo = new JLabel());
        botonCombo.setIcon(icono);
        botonCombo.setOpaque(true);
        botonCombo.setBackground(colores.getColorBase());
        botonCombo.addMouseListener(this);
        menu = new JPopupMenu();
        menu.setBackground(colores.getColorBase());
        menu.add(scrollElementos = new JScrollPane(lista = new JPanel()));
        scrollElementos.setBorder(null);
        BoxLayout boxLista = new BoxLayout(lista, BoxLayout.Y_AXIS);
        lista.setLayout(boxLista);
        lista.setBackground(colores.getColorBase());
        menu.setBorder(BorderFactory.createLineBorder(colores.getColorResalte()));
        menu.setBackground(colores.getColorBase());
        menu.setPopupSize(100, 150);
        visible=false;
        primerElemento=false;
    }
    
    public JPanel getComboBox(){
        return this.comboBox;
    }
    public void addString(String cadena){
        JLabel elemento = new JLabel(cadena);
        elemento.setName(cadena);
        elemento.setOpaque(true);
        elemento.setBackground(colores.getColorBase());
        elemento.setForeground(colores.getColorLetra());
        elemento.setFont(new Font("Arial", Font.PLAIN, 20));
        elemento.addMouseListener(this);
        JPanel panelElemento = new JPanel(new BorderLayout());
        panelElemento.add(elemento, BorderLayout.CENTER);
        lista.add(panelElemento);
        if (!primerElemento){
            texto.setText(" "+cadena+" ");
            elementoSeleccionado=cadena;
            primerElemento=true;
        }
    }
    public void showList(int x, int y){
        menu.show(this.comboBox, x, y);
        visible=true;
    }
    public void hideList(){
        menu.setVisible(false);
        visible=false;
    }
    public boolean isShowed(){
        return visible;
    }
    public String getSelectedItem(){
        return elementoSeleccionado;
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        
    }
    @Override
    public void mousePressed(MouseEvent evento) {
        if (evento.getSource().equals(this.botonCombo)){
            botonCombo.setBackground(colores.getColorPresion());
        }else if(evento.getSource() instanceof JLabel){
            JLabel elemento = (JLabel) evento.getSource();
            if (!elemento.getName().equals("seleccion")){
                elemento.setBackground(colores.getColorPresion());
            }
        }
    }
    @Override
    public void mouseReleased(MouseEvent evento) {
        if (evento.getSource().equals(this.botonCombo)){
            botonCombo.setBackground(colores.getColorResalte());
            if (isShowed()){
                hideList();
            }else{
                int x = this.comboBox.getX();
                int y = this.comboBox.getY()+ this.comboBox.getHeight();
                showList(x, y);
            }
        }else if(evento.getSource() instanceof JLabel){
            JLabel elemento = (JLabel) evento.getSource();
            if (!elemento.getName().equals("seleccion")){
                elemento.setBackground(colores.getColorResalte());
                elementoSeleccionado=elemento.getName();
                texto.setText(" "+elementoSeleccionado+" ");
                hideList();
                elemento.setBackground(colores.getColorBase());
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent evento) {
        if (evento.getSource().equals(this.botonCombo)){
            botonCombo.setBackground(colores.getColorResalte());
        }else if(evento.getSource() instanceof JLabel){
            JLabel elemento = (JLabel) evento.getSource();
            if (!elemento.getName().equals("seleccion")){
                elemento.setBackground(colores.getColorResalte());
            }
        }
        if(evento.getSource().equals(texto) || evento.getSource().equals(botonCombo) || evento.getSource().equals(comboBox)){
            comboBox.setBorder(BorderFactory.createLineBorder(colores.getColorPresion()));
        }
    }
    @Override
    public void mouseExited(MouseEvent evento) {
        if (evento.getSource().equals(this.botonCombo)){
            botonCombo.setBackground(colores.getColorBase());
        }else if(evento.getSource() instanceof JLabel){
            JLabel elemento = (JLabel) evento.getSource();
            if (!elemento.getName().equals("seleccion")){
                elemento.setBackground(colores.getColorBase());
            }
        }
        if(evento.getSource().equals(texto) || evento.getSource().equals(botonCombo) || evento.getSource().equals(comboBox)){
            comboBox.setBorder(BorderFactory.createLineBorder(colores.getColorResalte()));
        }
    }
}
