/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

import java.io.*;
import java.util.*;
import java.net.*;
import java.util.logging.*;

/**
 *
 * @author Usuario
 */
public class Servidor extends Thread{
    private boolean activo, pausado, atendiendo;
    private ServerSocket socketAtendedor;
    //Inserte base de datos, aquí debajo
    private Partida partida;

    public Servidor() {
        super();
        this.activo = false;
        this.pausado = false;
        this.atendiendo = false;
        this.partida = new Partida();
    }
    
    public void arrancarServidor(){
        this.activo = true;
        this.pausado = false;
        this.start();
    }

    public boolean isActivo() {
        return activo;
    }

    public boolean isPausado() {
        return pausado;
    }

    public boolean isAtendiendo() {
        return atendiendo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }

    @Override
    public void run() {
        try {
            this.socketAtendedor = new ServerSocket(15000);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            this.activo = false;
        }
        while(this.activo){
            //en este espacio se atenderán las peticiones entrantes
            try{
            
            Socket socketAtendido = this.socketAtendedor.accept();
            
            this.atendiendo = false;
            OutputStream salida = socketAtendido.getOutputStream();
            ObjectOutputStream salidaObjetos = new ObjectOutputStream(salida);
            InputStream entrada = socketAtendido.getInputStream();
            ObjectInputStream entradaObjetos = new ObjectInputStream(entrada);
            
            Mensaje mensajeRecibido = (Mensaje)entradaObjetos.readObject();
            switch(mensajeRecibido.getTipoDelMensaje()){
                case SERVIDORACTIVO:{
                    mensajeRecibido.setDatoRespuesta(true);
                    salidaObjetos.writeObject(mensajeRecibido);
                    break;
                }
                case UNIRSEAPARTIDA:{
                    if(this.partida.isPartidaIniciada()){
                       mensajeRecibido.setDatoRespuesta(false);
                    }else{
                       if(this.partida.getJugadores().contains(new Jugador((String)mensajeRecibido.getDatoSolicitud()))){
                           mensajeRecibido.setDatoRespuesta(false);
                       }
                       else{
                           this.partida.getJugadores().add(new Jugador((String)mensajeRecibido.getDatoSolicitud()));
                           System.out.println(socketAtendido.getInetAddress().toString().substring(1));
                           mensajeRecibido.setDatoRespuesta(true);
                       }
                    }
                    salidaObjetos.writeObject(mensajeRecibido);
                    break;
                }
                case LANZARCARTA:{//un usuario intentó lanzar una carta, debo validar que pueda hacerlo
                    ArrayList<Object> datos = (ArrayList<Object>)mensajeRecibido.getDatoSolicitud();
                    Carta cartaLanzada = (Carta)datos.get(0);
                    if(cartaLanzada.isLanzable(this.partida.getCartas().get(this.partida.getCartas().size()-1))){
                        Jugador jugador = new Jugador((String)datos.get(1));
                        if(this.partida.getJugador(this.partida.getTurno()).equals(jugador)){
                            mensajeRecibido.setDatoRespuesta(true);
                            for (int i = 0; i < this.partida.getJugadores().size(); i++) {
                                Jugador get = this.partida.getJugadores().get(i);
                                if(get.equals(jugador)){
                                    get.getCartas().remove(cartaLanzada);
                                    break;
                                }
                            }
                            if(this.partida.isSentido()){
                                this.partida.setTurno(this.partida.getTurno()+ 1);
                            }
                            else{
                                this.partida.setTurno(this.partida.getTurno()- 1);
                            }
                            if(this.partida.getTurno() >= this.partida.getJugadores().size()){
                                this.partida.setTurno(0);
                            }
                            if(this.partida.getTurno() < 0){
                                this.partida.setTurno(this.partida.getJugadores().size()-1);
                            }
                            if(cartaLanzada instanceof CartaReversa){
                                this.partida.setSentido(!this.partida.isSentido());
                            }
                            else if(cartaLanzada instanceof CartaSalto){
                                if(this.partida.isSentido()){
                                    this.partida.setTurno(this.partida.getTurno()+ 1);
                                }
                                else{
                                    this.partida.setTurno(this.partida.getTurno()- 1);
                                }
                                if(this.partida.getTurno() >= this.partida.getJugadores().size()){
                                    this.partida.setTurno(0);
                                }
                                if(this.partida.getTurno() < 0){
                                    this.partida.setTurno(this.partida.getJugadores().size()-1);
                                }
                            }
                            else if(cartaLanzada instanceof CartaTomeDos){
                                Jugador j = this.partida.getJugador(this.partida.getTurno());
                                for (int i = 0; i < 2; i++) {
                                    j.getCartas().add(GeneradorDeCartas.generarCarta());
                                }
                                j.setaSalvo(false);
                            }
                            else if(cartaLanzada instanceof CartaSinColor){
                                if(!((CartaSinColor) cartaLanzada).isTipoDeCarta()){
                                    Jugador j = this.partida.getJugador(this.partida.getTurno());
                                    for (int i = 0; i < 4; i++) {
                                        j.getCartas().add(GeneradorDeCartas.generarCarta());
                                    }
                                    j.setaSalvo(false);
                                }
                                ColorCarta colorDeseado = (ColorCarta)datos.get(2);
                                ((CartaSinColor) cartaLanzada).setColorDeseado(colorDeseado);
                            }
                            this.partida.getCartas().add(cartaLanzada);
                        }
                    }else{
                        mensajeRecibido.setDatoRespuesta(false);
                    }
                    salidaObjetos.writeObject(mensajeRecibido);
                    break;
                }
                case INICIARPARTIDA:{
                    if(!this.partida.isPartidaIniciada()){
                        this.partida.getCartas().add(GeneradorDeCartas.generarCarta());
                        for (int i = 0; i < this.partida.getJugadores().size(); i++) {
                            Jugador get = this.partida.getJugadores().get(i);
                            for (int j = 0; j < 7; j++) {
                                get.getCartas().add(GeneradorDeCartas.generarCarta());
                            }
                        }
                        this.partida.setPartidaIniciada(true);
                    }
                    mensajeRecibido.setDatoRespuesta(true);
                    salidaObjetos.writeObject(mensajeRecibido);
                    break;
                }
                case PEDIRCARTA:{
                    String nombreJugador = (String)mensajeRecibido.getDatoSolicitud();
                    this.partida.getJugadores().get(this.partida.getJugadores().indexOf(new Jugador(nombreJugador))).getCartas().add(GeneradorDeCartas.generarCarta());
                    this.partida.getJugadores().get(this.partida.getJugadores().indexOf(new Jugador(nombreJugador))).setaSalvo(false);
                    mensajeRecibido.setDatoRespuesta(true);
                    salidaObjetos.writeObject(mensajeRecibido);
                    break;
                }
                case ACTUALIZARDATOS:{
                    ArrayList<Object> datosAEnviar = new ArrayList<>();
                    datosAEnviar.add(this.partida.getJugadores());
                    datosAEnviar.add(this.partida.getCartas().get(this.partida.getCartas().size()-1));
                    datosAEnviar.add(this.partida.getJugador(this.partida.getTurno()));
                    mensajeRecibido.setDatoRespuesta(datosAEnviar);
                    salidaObjetos.writeObject(mensajeRecibido);
                    break;
                }
                case UNO:{
                    String []nombres = (String[])mensajeRecibido.getDatoSolicitud();
                    Jugador jugadorSeñalador = this.partida.getJugadores().get(this.partida.getJugadores().indexOf(new Jugador(nombres[0])));
                    Jugador jugadorSeñalado = this.partida.getJugadores().get(this.partida.getJugadores().indexOf(new Jugador(nombres[1])));
                    if(!jugadorSeñalado.isaSalvo() && jugadorSeñalado.getCartas().size() == 1 && jugadorSeñalado.equals(jugadorSeñalador)){
                        jugadorSeñalado.setaSalvo(true);
                        mensajeRecibido.setDatoRespuesta(true);
                        salidaObjetos.writeObject(mensajeRecibido);
                    }
                    else if(jugadorSeñalado.getCartas().size() != 1){
                        jugadorSeñalador.getCartas().add(GeneradorDeCartas.generarCarta());
                        jugadorSeñalador.getCartas().add(GeneradorDeCartas.generarCarta());
                        mensajeRecibido.setDatoRespuesta(false);
                        salidaObjetos.writeObject(mensajeRecibido);
                    }
                    else if(jugadorSeñalado.isaSalvo()){
                        mensajeRecibido.setDatoRespuesta(false);
                        salidaObjetos.writeObject(mensajeRecibido);
                    }
                }
                default:{
                    break;
                }
            }
            this.atendiendo = false;
            entradaObjetos.close();
            salidaObjetos.close();
            socketAtendido.close();
        }catch(IOException|ClassNotFoundException exc){
            Logger.getLogger("Cliente.java").log(Level.SEVERE, null, exc);
        }            
            while(this.pausado){
                try{
                    Thread.sleep(1);
                }catch(InterruptedException exc){
                    Logger.getLogger("Servidor.java").log(Level.SEVERE, null, exc);
                }
            }
        }
        try{
            this.socketAtendedor.close();
        }catch(IOException exc){
            Logger.getLogger("Servidor.java").log(Level.SEVERE, null, exc);
        }
    }
}
