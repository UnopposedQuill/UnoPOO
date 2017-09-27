/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

import java.io.*;
import java.net.*;
import java.util.logging.*;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private String IPServidor = "localhost";

    public Cliente() {
    }
    
    public Cliente(String IPServidor){
        this.IPServidor = IPServidor;
    }

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
}
