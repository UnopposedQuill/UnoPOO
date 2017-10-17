
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

import java.util.*;

/**
 *
 * @author Usuario
 */
public class Jugador implements java.io.Serializable{
    
    private String nombreJugador;
    //private int IDJugador;
    private ArrayList<Carta> cartas;
    private boolean aSalvo = false;
    
    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        //this.IDJugador = IDJugador;
        this.cartas = new ArrayList<>();
    }

    public String getNombreJugador() {
        return nombreJugador;
    }
    
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public boolean isaSalvo() {
        return aSalvo;
    }

    public void setaSalvo(boolean aSalvo) {
        this.aSalvo = aSalvo;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nombreJugador);
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
        final Jugador other = (Jugador) obj;
        return Objects.equals(this.nombreJugador, other.nombreJugador);
    }
    
}
