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
        while(this.activo){
            //en este espacio se atenderán las peticiones entrantes
            try{
            this.socketAtendedor = new ServerSocket(15000);
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
                       ArrayList<String>datos = (ArrayList<String>)mensajeRecibido.getDatoSolicitud();
                       if(this.partida.getJugadores().contains(new Jugador(Integer.parseInt(datos.get(1))))){
                           mensajeRecibido.setDatoRespuesta(false);
                       }
                       else{
                           
                       }
                    }
                    salidaObjetos.writeObject(mensajeRecibido);
                }
                case LANZARCARTA:{//un usuario intentó lanzar una carta, debo validar que pueda hacerlo
                    
                }
                case CARTALANZADA:{//un usuario lanzó una carta válida, notificar a todos
                    
                }
                case PARTIDAFINALIZADA:{//la partida fue finalizada abruptamente, notificar a todos
                    
                }
                case PARTIDAGANADA:{//la partida fue ganada por alguien, notificar a todos
                    
                }
                case REGISTRARSE:{//no se sabe si se seguirá usando
                    
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
