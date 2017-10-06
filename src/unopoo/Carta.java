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
public abstract class Carta implements java.io.Serializable{

    //el mazo es de 108 cartas, así que tenemos números entre 0 y 107
    public Carta() {
    }
    
    /**
     * Este método evalúa si una carta es lanzable al evaluar la carta en el tope actual de la pila
     * @param cartaDePila La carta que estaba en el tope de la pila
     * @return True si es posible lanzar la carta "this" viendo la carta que es estánen el tope de la pila 
     */
    public abstract boolean isLanzable(Carta cartaDePila);
}
