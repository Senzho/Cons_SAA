package LogicaNegocio.Logica;

import java.io.Serializable;

public class DireccionIp implements Serializable{
    private String direccion;
    
    public DireccionIp(String direccion){
        this.direccion = direccion;
    }
    
    public String getDireccion(){
        return this.direccion;
    }
}
