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
public abstract class CartaColor extends Carta{
    
    private final ColorCarta color;

    protected CartaColor(ColorCarta color) {
        this.color = color;
    }

    public ColorCarta getColor() {
        return color;
    }
}
