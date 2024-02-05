

import javax.swing.JOptionPane;

public class Cajero {
    public static void main(String[] args){
        Cuenta cuenta = new Cuenta();
        int opcion;
        do{
        
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Elige una opción: "+ 
            "\n1- Saldo "+ 
            "\n2- Imposición "+ 
            "\n3- Reintegro"+
            "\n0- Salir"));
       
        
            switch (opcion) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Saldo actual: "+ cuenta.getSaldo());
                    break;
                    
                case 2:
                    double cantidadAIngresar = solicitarCantidad();
                    cuenta.setSaldo(cuenta.getSaldo() + cantidadAIngresar );
                    JOptionPane.showMessageDialog(null, "Operación realizada. Se han ingresado  "+cantidadAIngresar + " € ");
                break;
                case 3:
                double cantidadAExtraer = solicitarCantidad();
                if(cuenta.getSaldo() >= cantidadAExtraer){
                    cuenta.setSaldo(cuenta.getSaldo() -  cantidadAExtraer);

                    JOptionPane.showMessageDialog(null, "Operación realizada:  Se han retirado " + cantidadAExtraer + " €");
                } else {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                }
                break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                break;
              
            }


       }while(opcion != 0);
    }

    private static double solicitarCantidad(){
        try {
            return Double.parseDouble(JOptionPane.showInputDialog("Ingrese una cantidad en euros "));
        } catch (NumberFormatException e) {
            JOptionPane.showInputDialog(null, "ERROR." );
            return solicitarCantidad();
        }
        
    }


}
