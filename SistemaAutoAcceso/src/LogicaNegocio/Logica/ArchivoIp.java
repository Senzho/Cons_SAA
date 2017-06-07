package LogicaNegocio.Logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchivoIp {
    private final String NOMBRE_ARCHIVO = "/ipconf.sa";
    private final String DIRECCION_DEFAULT = "localhost";
    
    public boolean archivoExiste(){
        boolean existe = false;
        File archivo = new File(this.NOMBRE_ARCHIVO);
        if (archivo.exists()){
            existe = true;
        }
        return existe;
    }
    
    public String getDireccionIp(){
        String direccion = "";
        if (!archivoExiste()){
            direccion = this.DIRECCION_DEFAULT;
        }else{
            direccion = obtenerIp();
        }
        return direccion;
    }
    
    public void guardarIp(String ip){
        FileOutputStream archivo = null;
        ObjectOutputStream salida = null;
        if (archivoExiste()){
            File archivoExistente = new File(this.NOMBRE_ARCHIVO);
            archivoExistente.delete();
        }
        try{
            archivo = new FileOutputStream(this.NOMBRE_ARCHIVO);
            salida = new ObjectOutputStream(archivo);
            DireccionIp direccion = new DireccionIp(ip);
            salida.writeObject(direccion);
        }catch(IOException excepcion){
            excepcion.printStackTrace();
        }finally{
            try{
                archivo.close();
                salida.close();
            }catch(IOException excepcion){
                
            }
        }
    }
    
    public String obtenerIp(){
        String ip = "";
        FileInputStream archivo = null;
        ObjectInputStream entrada = null;
        try{
            archivo = new FileInputStream(this.NOMBRE_ARCHIVO);
            entrada = new ObjectInputStream(archivo);
            DireccionIp direccion = (DireccionIp) entrada.readObject();
            ip = direccion.getDireccion();
        }catch(IOException | ClassNotFoundException excepcion){
            
        }finally{
            try{
                archivo.close();
                entrada.close();
            }catch(IOException excepcion){
                
            }
        }
        return ip;
    }
}
