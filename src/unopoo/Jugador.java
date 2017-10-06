
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
public class Jugador {
    
    private String nombreJugador;
    private int IDJugador;
    private String IP;
    private int numeroJugador;
    private ArrayList<Carta> cartas;
    
    public Jugador(String nombreJugador, int IDJugador, String IP, int numeroJugador) {
        this.nombreJugador = nombreJugador;
        this.IDJugador = IDJugador;
        this.IP = IP;
        this.numeroJugador = numeroJugador;
        this.cartas = new ArrayList<>();
    }

    public Jugador(int ID){
        this.IDJugador = ID;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.IDJugador;
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
        return this.IDJugador == other.IDJugador;
    }
    
}
