package Class;

import javax.swing.JOptionPane;

public class Habitaciones {
    
    String[][] habitaciones = new String[20][5];

    public Habitaciones(){
        for (int i = 0; i < habitaciones.length; i++) {
            habitaciones[i][0] = String.valueOf(19+i);
            habitaciones[i][1] = (i % 2 == 0) ? "Sencilla" : "Doble";
            habitaciones[i][2] = (i % 2 == 0) ? "25000" : "50000";
            habitaciones[i][3] = "Disponible";
            habitaciones[i][4] = "";
        }
    }

    public Integer ReservarHabitacion(Integer usuario){
        String[] OpcionesH = {"Sencilla","Doble"};
        String TipoH;
        Integer HabiR = 0;
        Integer opcion = JOptionPane.showOptionDialog(
            null,
            "Selecciona una opcion",
            "Opciones Hotel",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            OpcionesH,
            OpcionesH[0]
        );
        if(opcion==0){
            TipoH = "Sencilla";
        }else{
            TipoH = "Doble";
        }

        for (int i = 0; i < habitaciones.length; i++) {
            if (habitaciones[i][1] == TipoH) {
                if(habitaciones[i][3] == "Disponible"){
                    HabiR = Integer.parseInt(habitaciones[i][0]);
                    habitaciones[i][3] = "Reservada"; 
                    habitaciones[i][4] = usuario.toString(); 
                    return HabiR;
                }
            }
        }
        return HabiR;
    }

    public void InformacionH(Integer numeroH){
        String numeroHStr = Integer.toString(numeroH);
        for (int i = 0; i < habitaciones.length; i++) {
            if (habitaciones[i][0].equals(numeroHStr)) {
                JOptionPane.showMessageDialog(null, "Tipo habitacion: "+ habitaciones[i][1] + "\nEstado habitacion: " + habitaciones[i][3] + "\nCliente: "+ habitaciones[i][4] + "\nNumero Habitacion: "+ habitaciones[i][0]);
            }
        }
    }

    public Integer ActualizarHabitacion(Integer habitacion){
        String[] OpcionesH = {"Disponible","Reservada"};
        String TipoH;
        Integer HabiR = 0;
        Integer opcion = JOptionPane.showOptionDialog(
            null,
            "Selecciona una opcion",
            "Opciones Hotel",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            OpcionesH,
            OpcionesH[0]
        );
        if(opcion==0){
            TipoH = "Disponible";
        }else{
            TipoH = "Reservada";
        }

        String numeroHStr = Integer.toString(habitacion);
        for (int i = 0; i < habitaciones.length; i++) {
            if(habitaciones[i][0].equals(numeroHStr)){
                habitaciones[i][3] = TipoH; 
                habitaciones[i][4] = ""; 
                HabiR = habitacion;
                return HabiR;
            }
        }
        return HabiR;
    }

}
