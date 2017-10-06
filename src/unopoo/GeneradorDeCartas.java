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

    public static Carta generarCarta(){
        Random randomizador = new Random();
        //76 de las cartas del mazo son las de números
        //24 son de las de tome 2, salto, y reversa
        //quedan 8 cartas, para comodín de color y tome 4
        int numeroCartaGenerada = (int)(randomizador.nextDouble() * 108);
        Carta cartaGenerada = null;
        if(numeroCartaGenerada <= 75){
            if(numeroCartaGenerada <= 19){
                if(numeroCartaGenerada < 10){
                    cartaGenerada = new CartaNumero(numeroCartaGenerada, ColorCarta.ROJO);
                }
                else{
                    cartaGenerada = new CartaNumero(numeroCartaGenerada-9, ColorCarta.ROJO);
                }
            }
            else if(numeroCartaGenerada <= 38){
                numeroCartaGenerada -= 19;
                if(numeroCartaGenerada < 10){
                    cartaGenerada = new CartaNumero(numeroCartaGenerada, ColorCarta.VERDE);
                }
                else{
                    cartaGenerada = new CartaNumero(numeroCartaGenerada-9, ColorCarta.VERDE);
                }
            }
            else if(numeroCartaGenerada <= 57 ){
                numeroCartaGenerada -= 38;
                if(numeroCartaGenerada < 10){
                    cartaGenerada = new CartaNumero(numeroCartaGenerada, ColorCarta.VERDE);
                }
                else{
                    cartaGenerada = new CartaNumero(numeroCartaGenerada-9, ColorCarta.VERDE);
                }
            }
            else{
                numeroCartaGenerada -= 57;
                if(numeroCartaGenerada < 10){
                    cartaGenerada = new CartaNumero(numeroCartaGenerada, ColorCarta.VERDE);
                }
                else{
                    cartaGenerada = new CartaNumero(numeroCartaGenerada-9, ColorCarta.VERDE);
                }
            }
        }else if(numeroCartaGenerada <= 99){
            //numero entre 76 y 99
            if(numeroCartaGenerada < 84){//tome 2
                if(numeroCartaGenerada < 78){//tome 2 rojo
                    cartaGenerada = new CartaTomeDos(ColorCarta.ROJO);
                }
                else if(numeroCartaGenerada < 80){//tome 2 verde
                    cartaGenerada = new CartaTomeDos(ColorCarta.VERDE);
                }
                else if(numeroCartaGenerada < 82){//tome 2 azul
                    cartaGenerada = new CartaTomeDos(ColorCarta.AZUL);
                }
                else{
                    cartaGenerada = new CartaTomeDos(ColorCarta.AMARILLO);//tome 2 amarillo
                }
            }
            else if(numeroCartaGenerada < 92){//reversa
                if(numeroCartaGenerada < 86){//reversa rojo
                    cartaGenerada = new CartaReversa(ColorCarta.ROJO);
                }
                else if(numeroCartaGenerada < 88){//reversa verde
                    cartaGenerada = new CartaReversa(ColorCarta.VERDE);
                }
                else if(numeroCartaGenerada < 90){//reversa azul
                    cartaGenerada = new CartaReversa(ColorCarta.AZUL);
                }
                else{
                    cartaGenerada = new CartaReversa(ColorCarta.AMARILLO);//reversa amarillo
                }
            }
            else if(numeroCartaGenerada < 100){//salto
                if(numeroCartaGenerada < 94){//salto rojo
                    cartaGenerada = new CartaSalto(ColorCarta.ROJO);
                }
                else if(numeroCartaGenerada < 96){//salto verde
                    cartaGenerada = new CartaSalto(ColorCarta.VERDE);
                }
                else if(numeroCartaGenerada < 98){//salto azul
                    cartaGenerada = new CartaSalto(ColorCarta.AZUL);
                }
                else{
                    cartaGenerada = new CartaSalto(ColorCarta.AMARILLO);//salto amarillo
                }
            }
        }else if(numeroCartaGenerada <= 103){//comodín
            cartaGenerada = new CartaSinColor(true);
        }else{
            cartaGenerada = new CartaSinColor(false);//tome 4
        }
        return cartaGenerada;
    }
    
}
