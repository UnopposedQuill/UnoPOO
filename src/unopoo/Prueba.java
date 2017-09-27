/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

/**
 *
 * @author Usuario
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente cliente = new Cliente();
        if(cliente.verificarServidor()){
            System.out.println("Servidor arrancado y contactado correctamente");
        }
        else{
            System.out.println("Servidor erróneamente arrancado y contactado");
        }
    }    
}
