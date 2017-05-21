package InterfazGrafica;

public class Fecha {
    private final String[] MESES = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    
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
}
