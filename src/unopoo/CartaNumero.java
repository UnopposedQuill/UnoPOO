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
public class CartaNumero extends CartaColor{
    
    private final int numeroCarta;

    public CartaNumero(int numeroCarta, ColorCarta color) {
        super(color);
        this.numeroCarta = numeroCarta;
    }

    public int getNumeroCarta() {
        return numeroCarta;
    }

    @Override
    public boolean isLanzable(Carta cartaDePila) {
        if(cartaDePila instanceof CartaSinColor){
            return this.getColor().equals(((CartaSinColor)cartaDePila).getColorDeseado());
        }
        return this.getColor().equals(((CartaColor)cartaDePila).getColor()) || this.equals(cartaDePila);
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.numeroCarta;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CartaNumero other = (CartaNumero) obj;
        return this.numeroCarta == other.numeroCarta;
    }

    @Override
    public String toString() {
        return "Carta de Numero: " + numeroCarta + " color: " + this.getColor();
    }
    
    
}
