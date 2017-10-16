/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class HiloInterfaz extends Thread{
    
    private final InterfazCliente interfazAActualizar;

    public HiloInterfaz(InterfazCliente interfazAActualizar) {
        this.interfazAActualizar = interfazAActualizar;
    }

    @Override
    public void run() {
        while(true){
            this.interfazAActualizar.actualizarInterfaz();
            try {
                sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
