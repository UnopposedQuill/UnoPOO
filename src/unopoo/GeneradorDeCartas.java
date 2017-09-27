/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class GeneradorDeCartas {

    public static int generarCarta(){
        Random randomizador = new Random();
        int cartaGenerada = (int)randomizador.nextDouble() * 108;
        return cartaGenerada;
    }
    
}
