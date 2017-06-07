package LogicaNegocio.Logica;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    private final String ALGORITMO = "MD5";
    
    public String hash(String cadena){
        String hash = "";
        try{
            MessageDigest messageDigest = MessageDigest.getInstance(this.ALGORITMO);
            byte[] bytes = messageDigest.digest(cadena.getBytes());
            int tamano = bytes.length;
            StringBuffer stringBuffer = new StringBuffer(tamano);
            for (int i = 0; i < tamano; i++){
                int valor = bytes[i] & 255;
                String valorHexadecimal = Integer.toHexString(valor);
                if (valor < 16){
                    stringBuffer.append("0"+valorHexadecimal);
                }else{
                    stringBuffer.append(valorHexadecimal);
                }
            }
            hash = stringBuffer.toString();
        }catch(NoSuchAlgorithmException excepcion){
            
        }
        return hash;
    }
}
