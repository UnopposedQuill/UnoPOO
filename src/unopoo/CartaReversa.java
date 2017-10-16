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
public class CartaReversa extends CartaColor{

    public CartaReversa(ColorCarta color) {
        super(color);
    }
    
    @Override
    public boolean isLanzable(Carta cartaDePila) {
        if(cartaDePila instanceof CartaSinColor){
            return this.getColor().equals(((CartaSinColor)cartaDePila).getColorDeseado());
        }
        return this.getColor().equals(((CartaColor)cartaDePila).getColor()) || this.equals(cartaDePila);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass();
    }

    @Override
    public int hashCode() {
        int hash = 10;
        return hash;
    }

    @Override
    public String toString() {
        return "Reversa " + this.getColor();
    }
}
