import javax.swing.JOptionPane;

import Class.Cliente;
import Class.Habitaciones;

public class App {
    String[][] clientes = new String[20][3];
    int ClienteIndex = 0;

    public static void main(String[] args) throws Exception {
        App app = new App();
        Habitaciones habitacion = new Habitaciones();
        String[] OptionsH = {"Informacion Usuario","Registrar Usuario","Reservar Habitacion","Actualizar Habitacion","Salir"};
        Integer opcion = 0;
        JOptionPane.showMessageDialog(null, "Bienvenido al hotel el descanso del emperador");
        while (opcion != -1) {
            opcion = JOptionPane.showOptionDialog(
                null,
                "Selecciona una opcion",
                "Opciones Hotel",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                OptionsH,
                OptionsH[0]
            );
            if (opcion == 0) {
                app.InformationCliente(Integer.parseInt(JOptionPane.showInputDialog("Documento Cliente")));
            }else if (opcion == 1) {
                if(app.ClienteIndex < 10){
                    Cliente cliente = new Cliente(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el numero de documento")), JOptionPane.showInputDialog("Ingresa el nombre"), JOptionPane.showInputDialog("Ingresa el apellido"));
                    app.AddCliente(app.ClienteIndex, cliente);
                }else{
                    JOptionPane.showMessageDialog(null, "No se pueden ingresar mas clientes");
                }
            }else if(opcion == 2){
                Integer documento = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero de documento"));
                Boolean existencia = app.ValidarExistencia(documento);
                if (existencia) {
                    Integer numeroh = habitacion.ReservarHabitacion(documento);
                    if (numeroh == 0){
                        JOptionPane.showMessageDialog(null,"No hay habitaciones disponibles");
                    }else{
                        habitacion.InformacionH(numeroh);
                    } 
                }
             
            }else if(opcion ==3){
                Integer habitacio = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el numero de la habitacion"));
                Integer numeroh = habitacion.ActualizarHabitacion(habitacio);
                if (numeroh == 0){
                    JOptionPane.showMessageDialog(null,"No no encontro la habitacion");
                }else{
                    habitacion.InformacionH(numeroh);
                } 
               
            }else if(opcion == 4){
                opcion = -1;
            }
        }
    }

    public void AddCliente(int index,Cliente cliente){
        if(index>=0 && index< clientes.length){
            clientes[index][0] = cliente.GetDocumnetU().toString();
            clientes[index][1] = cliente.GetNameU();
            clientes[index][2] = cliente.GetLastNameU();
        }else{
            System.out.println("EL indice esta fuera del rango permitido");
        }
    }

    public boolean InformationCliente(int documento){
        for(int x = 0; x < clientes.length; x++){
            if (clientes[x][0] != null && Integer.parseInt(clientes[x][0]) == documento) {
                JOptionPane.showMessageDialog(null,"Documento: "+ documento + "\nNombre:" + clientes[x][1] + "\nApellido:" + clientes[x][2],"Informacion Usuario",JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado");
        return false;
    }

    public boolean ValidarExistencia(int documento){
        for(int x = 0; x < clientes.length; x++){
            if (clientes[x][0] != null && Integer.parseInt(clientes[x][0]) == documento) {
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado");
        return false;
    }
}
