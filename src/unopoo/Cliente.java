/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.*;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cliente{
    private String IPServidor = "localhost";

    public Cliente() {
    }
    
    public Cliente(String IPServidor){
        this.IPServidor = IPServidor;
    }
    
    public boolean unirseALista(String nombreJugador){
        Mensaje mensajeAEnviar = new Mensaje(nombreJugador, TipoMensaje.UNIRSEAPARTIDA);
        try{
            Socket socket = new Socket(IPServidor, 15000);//2048->??MIL
            
            InputStream entrada = socket.getInputStream();
            ObjectInputStream entradaObjetos = new ObjectInputStream(entrada);
            OutputStream salida = socket.getOutputStream();
            ObjectOutputStream salidaObjetos = new ObjectOutputStream(salida);
            
            salidaObjetos.writeObject(mensajeAEnviar);            
            Mensaje mensajeRecibido = (Mensaje)entradaObjetos.readObject();
            entradaObjetos.close();
            salidaObjetos.close();
            socket.close();
            return (boolean)mensajeRecibido.getDatoRespuesta();
        }catch(IOException|ClassNotFoundException exc){
            Logger.getLogger("Cliente.java").log(Level.SEVERE, null, exc);
            return false;
        }
    }
    
    /**
     * Esta función averigua si el servidor apuntado por la dirección dada del servidor que posee el cliente es válida
     * @return True si la dirección es válida, False si ocurrió algún error
     */
    public boolean verificarServidor(){
        Mensaje mensajeAEnviar = new Mensaje(null, TipoMensaje.SERVIDORACTIVO);
        try{
            Socket socket = new Socket(IPServidor, 15000);//2048->??MIL
            
            InputStream entrada = socket.getInputStream();
            ObjectInputStream entradaObjetos = new ObjectInputStream(entrada);
            OutputStream salida = socket.getOutputStream();
            ObjectOutputStream salidaObjetos = new ObjectOutputStream(salida);
            
            salidaObjetos.writeObject(mensajeAEnviar);            
            Mensaje mensajeRecibido = (Mensaje)entradaObjetos.readObject();
            entradaObjetos.close();
            salidaObjetos.close();
            socket.close();
            return (boolean)mensajeRecibido.getDatoRespuesta();
        }catch(IOException|ClassNotFoundException exc){
            Logger.getLogger("Cliente.java").log(Level.SEVERE, null, exc);
            return false;
        }
    }
    
    public ArrayList<Object> actualizarDatos(){
        Mensaje mensajeAEnviar = new Mensaje(null, TipoMensaje.ACTUALIZARDATOS);
        try{
            Socket socket = new Socket(IPServidor, 15000);//2048->??MIL
            
            InputStream entrada = socket.getInputStream();
            ObjectInputStream entradaObjetos = new ObjectInputStream(entrada);
            OutputStream salida = socket.getOutputStream();
            ObjectOutputStream salidaObjetos = new ObjectOutputStream(salida);
            
            salidaObjetos.writeObject(mensajeAEnviar);            
            Mensaje mensajeRecibido = (Mensaje)entradaObjetos.readObject();
            entradaObjetos.close();
            salidaObjetos.close();
            socket.close();
            return (ArrayList)mensajeRecibido.getDatoRespuesta();
        }catch(IOException|ClassNotFoundException exc){
            Logger.getLogger("Cliente.java").log(Level.SEVERE, null, exc);
            return null;
        }
    }
    
    public Carta pedirCarta(String nombreJugador){
        Mensaje mensajeAEnviar = new Mensaje(nombreJugador, TipoMensaje.PEDIRCARTA);
        try{
            Socket socket = new Socket(IPServidor, 15000);//2048->??MIL
            
            InputStream entrada = socket.getInputStream();
            ObjectInputStream entradaObjetos = new ObjectInputStream(entrada);
            OutputStream salida = socket.getOutputStream();
            ObjectOutputStream salidaObjetos = new ObjectOutputStream(salida);
            
            salidaObjetos.writeObject(mensajeAEnviar);            
            Mensaje mensajeRecibido = (Mensaje)entradaObjetos.readObject();
            entradaObjetos.close();
            salidaObjetos.close();
            socket.close();
            return (Carta)mensajeRecibido.getDatoRespuesta();
        }catch(IOException|ClassNotFoundException exc){
            Logger.getLogger("Cliente.java").log(Level.SEVERE, null, exc);
            return null;
        }
    }
    
    public boolean lanzarCarta(Carta cartaALanzar, Jugador jugadorLanzador, ColorCarta c){
        ArrayList<Object> datos = new ArrayList<>();
        datos.add(cartaALanzar);
        datos.add(jugadorLanzador.getNombreJugador());
        datos.add(c);
        Mensaje mensajeAEnviar = new Mensaje(datos, TipoMensaje.LANZARCARTA);
        try{
            Socket socket = new Socket(IPServidor, 15000);//2048->??MIL
            
            InputStream entrada = socket.getInputStream();
            ObjectInputStream entradaObjetos = new ObjectInputStream(entrada);
            OutputStream salida = socket.getOutputStream();
            ObjectOutputStream salidaObjetos = new ObjectOutputStream(salida);
            
            salidaObjetos.writeObject(mensajeAEnviar);            
            Mensaje mensajeRecibido = (Mensaje)entradaObjetos.readObject();
            entradaObjetos.close();
            salidaObjetos.close();
            socket.close();
            return (boolean)mensajeRecibido.getDatoRespuesta();
        }catch(IOException|ClassNotFoundException exc){
            Logger.getLogger("Cliente.java").log(Level.SEVERE, null, exc);
            return false;
        }
    }
    
    public boolean iniciarPartida(){
        Mensaje mensajeAEnviar = new Mensaje(null, TipoMensaje.INICIARPARTIDA);
        try{
            Socket socket = new Socket(IPServidor, 15000);//2048->??MIL
            
            InputStream entrada = socket.getInputStream();
            ObjectInputStream entradaObjetos = new ObjectInputStream(entrada);
            OutputStream salida = socket.getOutputStream();
            ObjectOutputStream salidaObjetos = new ObjectOutputStream(salida);
            
            salidaObjetos.writeObject(mensajeAEnviar);            
            Mensaje mensajeRecibido = (Mensaje)entradaObjetos.readObject();
            entradaObjetos.close();
            salidaObjetos.close();
            socket.close();
            return (boolean)mensajeRecibido.getDatoRespuesta();
        }catch(IOException|ClassNotFoundException exc){
            Logger.getLogger("Cliente.java").log(Level.SEVERE, null, exc);
            return false;
        }
    }
    
    public boolean uno(String [] nombres){
        Mensaje mensajeAEnviar = new Mensaje(nombres, TipoMensaje.INICIARPARTIDA);
        try{
            Socket socket = new Socket(IPServidor, 15000);//2048->??MIL
            
            InputStream entrada = socket.getInputStream();
            ObjectInputStream entradaObjetos = new ObjectInputStream(entrada);
            OutputStream salida = socket.getOutputStream();
            ObjectOutputStream salidaObjetos = new ObjectOutputStream(salida);
            
            salidaObjetos.writeObject(mensajeAEnviar);            
            Mensaje mensajeRecibido = (Mensaje)entradaObjetos.readObject();
            entradaObjetos.close();
            salidaObjetos.close();
            socket.close();
            return (boolean)mensajeRecibido.getDatoRespuesta();
        }catch(IOException|ClassNotFoundException exc){
            Logger.getLogger("Cliente.java").log(Level.SEVERE, null, exc);
            return false;
        }
    }
}
