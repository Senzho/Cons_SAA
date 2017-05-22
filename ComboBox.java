package InterfazGrafica;

import java.awt.BorderLayout;
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
    private ListListener listListener;
    
    public ComboBox(Colores colores, ImageIcon icono){
        this.colores=colores;
        BorderLayout borderCombo = new BorderLayout();
        comboBox = new JPanel(borderCombo);
        comboBox.setBorder(BorderFactory.createLineBorder(colores.getColorResalte()));
        comboBox.setBackground(colores.getColorBase());
        comboBox.add(texto = new JLabel(), BorderLayout.CENTER);
        comboBox.addMouseListener(this);
        texto.setOpaque(true);
        texto.setBackground(colores.getColorBase());
        texto.setForeground(colores.getColorLetra());
        texto.setFont(new Font("Arial", Font.PLAIN, 20));
        texto.setName("seleccion");
        texto.addMouseListener(this);
        comboBox.add(botonCombo = new JLabel(), BorderLayout.LINE_END);
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
        reload();
    }
    public void removeAll(){
        this.lista.removeAll();
        this.primerElemento = false;
        this.elementoSeleccionado = "";
        reload();
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
    public void addListListener(ListListener listener){
        this.listListener = listener;
    }
    public void reload(){
        this.lista.setVisible(false);
        this.lista.setVisible(true);
    }
    public void setSelectedItem(String item){
        this.elementoSeleccionado = item;
        this.texto.setText(this.elementoSeleccionado);
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
                int x = 0;
                int y = this.comboBox.getHeight();
                this.menu.setPopupSize(this.comboBox.getWidth(), 150);
                showList(x, y);
            }
        }else if(evento.getSource() instanceof JLabel){
            JLabel elemento = (JLabel) evento.getSource();
            if (!elemento.getName().equals("seleccion")){
                elemento.setBackground(colores.getColorResalte());
                elementoSeleccionado=elemento.getName();
                texto.setText(" "+elementoSeleccionado+" ");
                if (this.listListener!=null){
                    this.listListener.ItemSelected(this);
                }
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
