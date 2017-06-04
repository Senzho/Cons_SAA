package InterfazGrafica;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
    private final String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
    public boolean validarFechas(Date fechaFinActividad, Date fechaEntrega){
        boolean valido = true;
        String fechaActividadFin = toString(fechaFinActividad);
        String fechaActividadEntrega = toString(fechaEntrega);
        int diaActividad = this.getDiaFecha(fechaActividadFin);
        int diaEntrega = this.getDiaFecha(fechaActividadEntrega);
        int anoFechaFinActividad = Integer.parseInt(this.getAnoFecha(fechaActividadFin));
        int anoFechaEntrega = Integer.parseInt(this.getAnoFecha(fechaActividadEntrega));
        String nombreMesFin = this.getMesFecha(fechaActividadFin);
        String nombreMesEntrega = this.getMesFecha(fechaActividadEntrega);
        int numeroMesFin = this.getNumeroMes(nombreMesFin);
        int numeroMesEntrega = this.getNumeroMes(nombreMesEntrega);
        if((numeroMesFin<numeroMesEntrega || diaEntrega>diaActividad)|| anoFechaEntrega>anoFechaFinActividad){
            valido = false;
        }
        return valido;
    }
            
    public int getNumeroMes(String mes){
        int numeroMes = 0;
        for (int i = 0; i < 12; i++){
            if (this.MESES[i].equals(mes)){
                numeroMes = i+1;
                i = 12;
            }
        }
        return numeroMes;
    }
    public String getNombreMes(int numeroMes){
        String nombre = "";
        for (int i = 0; i < 12; i++){
            if (numeroMes == i+1){
                nombre = this.MESES[i];
            }
        }
        return nombre;
    }
    public int getDiaFecha(String fecha){
        int dia = Integer.valueOf(fecha.substring(8, 10));
        return dia;
    }
    public String getMesFecha(String fecha){
        int mes = Integer.valueOf(fecha.substring(5, 7));
        return getNombreMes(mes);
    }
    public String getAnoFecha(String fecha){
        return fecha.substring(0, 4);
    }
    public String toString(Date fecha){
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFin = formatoFecha.format(fecha);
        return fechaFin;
    }
}
