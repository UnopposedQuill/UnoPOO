/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        /*Cliente cliente = new Cliente();
        if(cliente.verificarServidor()){
            System.out.println("Servidor arrancado y contactado correctamente");
        }
        else{
            System.out.println("Servidor erróneamente arrancado y contactado");
        }
        */
        int entrada = 0;
        ArrayList <Carta> cartas = new ArrayList<>();
        cartas.add(GeneradorDeCartas.generarCarta());
        while(entrada != -1){
            try {
                entrada = System.in.read()-48;
                if(entrada == 3){
                    break;
                }
                if(entrada == 1){
                    Carta carta = GeneradorDeCartas.generarCarta();
                    System.out.println(carta);
                    if(carta instanceof CartaSinColor){
                        CartaSinColor c = (CartaSinColor)carta;
                        c.setColorDeseado(ColorCarta.ROJO);
                        cartas.add(c);
                    }
                    else{
                        if(carta.isLanzable(cartas.get(cartas.size()-1))){
                            cartas.add(carta);
                        }
                    }
                }
                if(entrada == 2){
                    for(Carta c : cartas){
                        System.out.println(c);
                    }
                }
                Thread.sleep(2);
            } catch (InterruptedException|IOException ex) {
                Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
}
