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
public class Partida {
    private int turno;
    private boolean partidaIniciada, sentido;
    private ArrayList<Jugador> jugadores;

    public Partida() {
        this.partidaIniciada = false;
        this.sentido = true;//true es hacia la "derecha"
        this.turno = -1;
        this.jugadores = new ArrayList<Jugador>();
    }

    public int getTurno() {
        return turno;
    }

    public boolean isPartidaIniciada() {
        return partidaIniciada;
    }

    public boolean isSentido() {
        return sentido;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    public Jugador getJugador(int i){
        if(i >= 0){
            return this.jugadores.get(i);
        }
        else{
            return this.jugadores.get(this.jugadores.size()+i);
        }
    }
}
