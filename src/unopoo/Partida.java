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
    private ArrayList<Carta> cartas;
    private ArrayList<Jugador> jugadores;

    public Partida() {
        this.partidaIniciada = false;
        this.sentido = true;//true es hacia la "derecha"
        this.turno = 0;
        this.jugadores = new ArrayList<>();
        this.cartas = new ArrayList<>();
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

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setPartidaIniciada(boolean partidaIniciada) {
        this.partidaIniciada = partidaIniciada;
    }

    public void setSentido(boolean sentido) {
        this.sentido = sentido;
    }
    
    public Jugador getJugador(int i){
        return this.jugadores.get(i);
    }
}
