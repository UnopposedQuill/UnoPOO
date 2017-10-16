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
public class CartaSinColor extends Carta{
    private final boolean tipoDeCarta;//true para comodín, false para tome 4
    private ColorCarta colorDeseado;

    public CartaSinColor(boolean tipoDeCarta) {
        this.tipoDeCarta = tipoDeCarta;
        this.colorDeseado = null;
    }

    public boolean isTipoDeCarta() {
        return tipoDeCarta;
    }

    public ColorCarta getColorDeseado() {
        return colorDeseado;
    }

    public void setColorDeseado(ColorCarta colorDeseado) {
        if(this.colorDeseado == null){
            this.colorDeseado = colorDeseado;
        }
    }

    @Override
    public boolean isLanzable(Carta cartaDePila) {
        return true;//estas siempre se pueden lanzar
    }

    @Override
    public String toString() {
        if(this.tipoDeCarta){
            return "Comodín " + colorDeseado;
        }
        return "Tome 4 " + colorDeseado;
    }
    
    
}
