/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

import java.io.*;
import java.util.logging.*;

/**
 *
 * @author Usuario
 */
public class HiloManejaServidor extends Thread{
    private boolean activo;
    private Servidor servidorPropio;

    public HiloManejaServidor() {
        super();
        this.activo = true;
        this.servidorPropio = new Servidor();
    }

    @Override
    public void run(){
        while(this.activo){
            System.out.println("¿Qué deseas que haga?");
            try{
                int enteroRecibido = System.in.read()-48;
                switch(enteroRecibido){
                    case 1:{//Cómo está todo
                        System.out.println(this.servidorPropio.isActivo());
                        break;
                    }
                    case 2:{//Encendido/Apagado del servidor
                        this.servidorPropio.setActivo(this.servidorPropio.isActivo());
                        System.out.print("El servidor terminó:" );
                        if(this.servidorPropio.isActivo()){
                            System.out.println("Activo");
                            if(!this.servidorPropio.isAlive()){
                                this.servidorPropio.arrancarServidor();
                            }
                        }else{
                            this.servidorPropio.setPausado(false);
                            System.out.println("Inactivo");
                        }
                    }
                    case 3:{//Pausado/Despausado del servidor
                        this.servidorPropio.setPausado(this.servidorPropio.isPausado());
                        System.out.print("El servidor terminó:" );
                        if(this.servidorPropio.isPausado()){
                            System.out.println("Pausado");
                        }else{
                            System.out.println("Despausado");
                        }
                    }
                    case 8:{
                        this.servidorPropio.setActivo(false);
                        this.servidorPropio.setPausado(false);
                        this.activo = false;
                        break;
                    }
                    default:{
                        System.out.println("Entrada incorrecta");
                        break;
                    }
                }
            }catch(IOException exc){
                Logger.getLogger("HiloManejaServidor.java").log(Level.SEVERE, null, exc);
            }
        }
    }
}
