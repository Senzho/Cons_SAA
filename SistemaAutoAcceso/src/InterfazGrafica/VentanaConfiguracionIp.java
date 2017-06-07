package InterfazGrafica;

import LogicaNegocio.Logica.ArchivoIp;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaConfiguracionIp extends JFrame implements FocusListener, CursorListener, KeyListener{
    private Container contenedor;
    private JTextField texto1;
    private JTextField texto2;
    private JTextField texto3;
    private JTextField texto4;
    private Button botonOk;
    private Button botonCancelar;
    private final Colores colores = new Colores();
    
    public VentanaConfiguracionIp(){
        inicializarComponenetes();
        establecerPropiedades();
        setSize(280,180);
        //setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Configurar IP");
        setVisible(true);
    }
    
    public void inicializarComponenetes(){
        this.contenedor = getContentPane();
        this.contenedor.setLayout(new BorderLayout());
        this.contenedor.setBackground(this.colores.getColorBase());
        this.texto1 = new JTextField();
        this.texto1.setBorder(null);
        this.texto1.setHorizontalAlignment(JTextField.CENTER);
        this.texto2 = new JTextField();
        this.texto2.setBorder(null);
        this.texto2.setHorizontalAlignment(JTextField.CENTER);
        this.texto3 = new JTextField();
        this.texto3.setBorder(null);
        this.texto3.setHorizontalAlignment(JTextField.CENTER);
        this.texto4 = new JTextField();
        this.texto4.setBorder(null);
        this.texto4.setHorizontalAlignment(JTextField.CENTER);
        JPanel panelTextos = new JPanel(new GridBagLayout());
        panelTextos.setBackground(this.colores.getColorBase());
        GridBagConstraints constantes = new GridBagConstraints();
        constantes.gridx = 0;
        constantes.gridy = 0;
        constantes.anchor = GridBagConstraints.NORTHWEST;
        constantes.gridheight = 1;
        constantes.gridwidth = 1;
        constantes.insets = new Insets(10,10,10,10);
        constantes.fill = GridBagConstraints.BOTH;
        constantes.weightx = 1;
        panelTextos.add(this.texto1,constantes);
        constantes.gridx = 1;
        constantes.weightx = 0;
        constantes.fill = GridBagConstraints.NONE;
        panelTextos.add(new JLabel("."),constantes);
        constantes.gridx = 2;
        constantes.weightx = 1;
        constantes.fill = GridBagConstraints.BOTH;
        panelTextos.add(this.texto2,constantes);
        constantes.gridx = 3;
        constantes.weightx = 0;
        constantes.fill = GridBagConstraints.NONE;
        panelTextos.add(new JLabel("."),constantes);
        constantes.gridx = 4;
        constantes.weightx = 1;
        constantes.fill = GridBagConstraints.BOTH;
        panelTextos.add(this.texto3,constantes);
        constantes.gridx = 5;
        constantes.weightx = 0;
        constantes.fill = GridBagConstraints.NONE;
        panelTextos.add(new JLabel("."),constantes);
        constantes.gridx = 6;
        constantes.weightx = 1;
        constantes.fill = GridBagConstraints.BOTH;
        panelTextos.add(this.texto4,constantes);
        JPanel panelIp = new JPanel(new BorderLayout());
        panelIp.setBackground(this.colores.getColorBase());
        panelIp.add(new JLabel("Dirección IP:"), BorderLayout.PAGE_START);
        panelIp.add(panelTextos, BorderLayout.CENTER);
        this.contenedor.add(panelIp, BorderLayout.PAGE_START);
        /**
         * Panel botones.
         */
        FlowLayout flowBotones = new FlowLayout();
        flowBotones.setVgap(0);
        flowBotones.setHgap(0);
        JPanel panelBotones = new JPanel(flowBotones);
        panelBotones.setBackground(this.colores.getColorBase());
        this.botonOk = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoMasOscuro.png")), "Ok");
        this.botonCancelar = new Button(new Colores(), new ImageIcon(getClass().getResource("/RecursosGraficos/iconoEliminarOscuro.png")), "Cancelar");
        panelBotones.add(this.botonOk.getButton());
        panelBotones.add(this.botonCancelar.getButton());
        this.contenedor.add(panelBotones, BorderLayout.PAGE_END);
    }
    public void establecerPropiedades(){
        this.texto1.addFocusListener(this);
        this.texto1.addKeyListener(this);
        this.texto2.addFocusListener(this);
        this.texto2.addKeyListener(this);
        this.texto3.addFocusListener(this);
        this.texto3.addKeyListener(this);
        this.texto4.addFocusListener(this);
        this.texto4.addKeyListener(this);
        this.botonCancelar.addCursorListener(this);
        this.botonOk.addCursorListener(this);
    }
    public boolean direccionValida(int a, int b, int c, int d){
        boolean valida = false;
        int maximo = 226;
        if (a < maximo && b < maximo && c < maximo && d < maximo){
            valida = true;
        }
        return valida;
    }

    /**
     * Eventos: 
     */
    
    @Override
    public void focusGained(FocusEvent evento) {
        Object objetoFuente = evento.getSource();
        if (objetoFuente.equals(this.texto1)){
            this.texto1.setBorder(BorderFactory.createLineBorder(Color.blue));
        }else if(objetoFuente.equals(this.texto2)){
            this.texto2.setBorder(BorderFactory.createLineBorder(Color.blue));
        }else if(objetoFuente.equals(this.texto3)){
            this.texto3.setBorder(BorderFactory.createLineBorder(Color.blue));
        }else if (objetoFuente.equals(this.texto4)){
            this.texto4.setBorder(BorderFactory.createLineBorder(Color.blue));
        }
    }
    @Override
    public void focusLost(FocusEvent evento) {
        Object objetoFuente = evento.getSource();
        if(objetoFuente.equals(this.texto1)){
            this.texto1.setBorder(null);
        }else if(objetoFuente.equals(this.texto2)){
            this.texto2.setBorder(null);
        }else if (objetoFuente.equals(this.texto3)){
            this.texto3.setBorder(null);
        }else if (objetoFuente.equals(this.texto4)){
            this.texto4.setBorder(null);
        }
    }

    @Override
    public void cursorClicked(Button boton) {
        if (boton.equals(this.botonCancelar)){
            dispose();
        }else if (boton.equals(this.botonOk)){
            String texto1 = this.texto1.getText();
            String texto2 = this.texto2.getText();
            String texto3 = this.texto3.getText();
            String texto4 = this.texto4.getText();
            String mensaje = "La dirección no es válida";
            if (!texto1.equals("") && !texto2.equals("") && !texto3.equals("") && !texto4.equals("")){
                int a = Integer.valueOf(texto1);
                int b = Integer.valueOf(texto2);
                int c = Integer.valueOf(texto3);
                int d = Integer.valueOf(texto4);
                if (direccionValida(a,b,c,d)){
                    String direccionIp = texto1+"."+this.texto2.getText()+"."+texto3+"."+texto4;
                    ArchivoIp archivoIp = new ArchivoIp();
                    archivoIp.guardarIp(direccionIp);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, mensaje);
                }
            }else{
                JOptionPane.showMessageDialog(null, mensaje);
            }  
        }
    }

    @Override
    public void keyTyped(KeyEvent evento) {
        Object objetoFuente = evento.getSource();
        if (objetoFuente instanceof JTextField){
            JTextField texto = (JTextField) objetoFuente;
            if (!Character.isDigit(evento.getKeyChar()) || texto.getText().length()==3){
                evento.consume();
            }
        }
    }
    @Override
    public void keyPressed(KeyEvent evento) {
        
    }
    @Override
    public void keyReleased(KeyEvent evento) {
        
    }
}
