/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class InterfazCliente extends javax.swing.JFrame {

    private Cliente cliente;
    private Jugador jugador;
    private boolean turnoPropio = false;
    int indiceCartaActual = 0;    
    /**
     * Creates new form poo
     */
    public InterfazCliente() {
        initComponents();
        this.enTurno.setVisible(false);
        String nombreJugador = JOptionPane.showInputDialog("Ingrese su nombre");
        this.setTitle(nombreJugador);
        this.jugador = new Jugador(nombreJugador);
        this.cliente = new Cliente();
        while(!this.cliente.verificarServidor()){
            String servidor = JOptionPane.showInputDialog("No se encontró un servidor válido, por favor ingrese la dirección de uno");
            if(servidor.equals(""))System.exit(1);
            this.cliente = new Cliente(servidor);
        }
        if(this.cliente.unirseALista(nombreJugador)){
            JOptionPane.showMessageDialog(null, "Agregado a la lista", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "No quedó enlistado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarInterfaz(){
        ArrayList<Object> datos = this.cliente.actualizarDatos();
        ArrayList<Jugador> jugadores = (ArrayList)datos.get(0);
        this.Colocadas.setText(((Carta)datos.get(1)).toString());//colocar el ícono en el botón de colocadas
        this.turnoPropio = this.jugador.equals((Jugador)datos.get(2));
        this.enTurno.setVisible(this.turnoPropio);        
        
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador getJugador = jugadores.get(i);
            if(getJugador.equals(this.jugador)){
                this.jugador = getJugador;
                String [] nombres = {"", "", "", "", ""};
                ImageIcon [] imagenes = new ImageIcon[5];
                for (int j = 0; j < Integer.min(this.jugador.getCartas().size(), 5); j++) {
                        nombres[j] = this.jugador.getCartas().get(j+indiceCartaActual).toString();
                        /*
                        if(!nombres[j].equals("")){
                            imagenes[j] = new ImageIcon("/resources/".concat(nombres[j]).concat(".png"));
                            System.out.println(imagenes[j].getIconWidth()+ "X" + imagenes[j].getIconHeight());
                        }
                        */
                }
                /*
                this.carta1.setIcon(imagenes[0]);
                this.carta2.setIcon(imagenes[1]);
                this.carta3.setIcon(imagenes[2]);
                this.carta4.setIcon(imagenes[3]);
                this.carta5.setIcon(imagenes[4]);
                */
                this.carta1.setText(nombres[0]);
                this.carta2.setText(nombres[1]);
                this.carta3.setText(nombres[2]);
                this.carta4.setText(nombres[3]);
                this.carta5.setText(nombres[4]);
            }
            else{//hacer un conteo de las cartas de los demás jugadores, eso le toca a usted
                
            }
            for (int j = 0; j < jugadores.size(); j++) {
                Jugador get = jugadores.get(j);
                if(get.getCartas().isEmpty()){
                    JOptionPane.showMessageDialog(null, "El jugador "+get.getNombreJugador()+" ha ganado la partida");
                    System.exit(0);
                }
                if(get.getCartas().size() == 1 && !get.isaSalvo()){
                    JOptionPane.showMessageDialog(null, "UNO", "UNO", JOptionPane.INFORMATION_MESSAGE);
                    String [] nombres = {this.jugador.getNombreJugador(),get.getNombreJugador()};
                    if(this.cliente.uno(nombres)){
                        JOptionPane.showConfirmDialog(null, "UNO exitoso", "UNO", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showConfirmDialog(null, "UNO fallido", "UNO", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carta1 = new javax.swing.JButton();
        carta2 = new javax.swing.JButton();
        carta3 = new javax.swing.JButton();
        LanzarCarta = new javax.swing.JButton();
        Uno = new javax.swing.JButton();
        PedirCarta = new javax.swing.JButton();
        carta4 = new javax.swing.JButton();
        carta5 = new javax.swing.JButton();
        Izquierdo = new javax.swing.JButton();
        Derecho = new javax.swing.JButton();
        Colocadas = new javax.swing.JButton();
        enTurno = new javax.swing.JLabel();
        IniciarPartida = new javax.swing.JButton();
        PartidaIniciada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        carta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta1ActionPerformed(evt);
            }
        });

        carta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta2ActionPerformed(evt);
            }
        });

        carta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta3ActionPerformed(evt);
            }
        });

        LanzarCarta.setText("TirarCarta");
        LanzarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LanzarCartaActionPerformed(evt);
            }
        });

        Uno.setText("UNO");

        PedirCarta.setText("PedirCarta");
        PedirCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PedirCartaActionPerformed(evt);
            }
        });

        carta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta4ActionPerformed(evt);
            }
        });

        carta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carta5ActionPerformed(evt);
            }
        });

        Izquierdo.setText("Izquierdo");
        Izquierdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IzquierdoActionPerformed(evt);
            }
        });

        Derecho.setText("Derecho");
        Derecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DerechoActionPerformed(evt);
            }
        });

        Colocadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ColocadasActionPerformed(evt);
            }
        });

        enTurno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enTurno.setForeground(new java.awt.Color(204, 0, 0));
        enTurno.setText("EN TURNO");

        IniciarPartida.setText("Iniciar Partida");
        IniciarPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarPartidaActionPerformed(evt);
            }
        });

        PartidaIniciada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PartidaIniciada.setForeground(new java.awt.Color(204, 0, 0));
        PartidaIniciada.setText("PARTIDA NO INICIADA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PartidaIniciada, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(261, 261, 261)
                        .addComponent(Colocadas, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Izquierdo)
                                    .addComponent(enTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Derecho, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(IniciarPartida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(carta5, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PedirCarta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(LanzarCarta)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Uno)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(carta5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carta3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Izquierdo)
                    .addComponent(Derecho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(IniciarPartida)
                        .addGap(49, 49, 49))
                    .addComponent(enTurno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PartidaIniciada, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(Colocadas, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(Uno)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PedirCarta)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LanzarCarta)
                        .addGap(43, 43, 43))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LanzarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LanzarCartaActionPerformed
        // TODO add your handling code here: 
        
    }//GEN-LAST:event_LanzarCartaActionPerformed

    private void carta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta1ActionPerformed
        // TODO add your handling code here:
        if(this.jugador.getCartas().size() >= 1 + this.indiceCartaActual && this.turnoPropio){
            ColorCarta colorElegido = ColorCarta.ROJO;
            if(this.jugador.getCartas().get(this.indiceCartaActual) instanceof CartaSinColor){
                colorElegido = ColorCarta.values()[JOptionPane.showOptionDialog(null, "Elija el color de la carta", "Elija un color", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ColorCarta.values(), ColorCarta.AMARILLO)];
            }
            if(this.cliente.lanzarCarta(this.jugador.getCartas().get(this.indiceCartaActual), this.jugador, colorElegido)){
                JOptionPane.showMessageDialog(null, "Carta exitosamente lanzada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Carta no Válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, espere su turno.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_carta1ActionPerformed

    private void carta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta2ActionPerformed
        // TODO add your handling code here:
        if(this.jugador.getCartas().size() >= 2 + this.indiceCartaActual && this.turnoPropio){
            ColorCarta colorElegido = ColorCarta.ROJO;
            if(this.jugador.getCartas().get(this.indiceCartaActual+1) instanceof CartaSinColor){
                colorElegido = ColorCarta.values()[JOptionPane.showOptionDialog(null, "Elija el color de la carta", "Elija un color", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ColorCarta.values(), ColorCarta.AMARILLO)];
            }
            if(this.cliente.lanzarCarta(this.jugador.getCartas().get(this.indiceCartaActual+1), this.jugador, colorElegido)){
                JOptionPane.showMessageDialog(null, "Carta exitosamente lanzada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Carta no Válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, espere su turno.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_carta2ActionPerformed

    private void carta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta3ActionPerformed
        // TODO add your handling code here:
        if(this.jugador.getCartas().size() >= 3 + this.indiceCartaActual && this.turnoPropio){
            ColorCarta colorElegido = ColorCarta.ROJO;
            if(this.jugador.getCartas().get(this.indiceCartaActual+2) instanceof CartaSinColor){
                colorElegido = ColorCarta.values()[JOptionPane.showOptionDialog(null, "Elija el color de la carta", "Elija un color", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ColorCarta.values(), ColorCarta.AMARILLO)];
            }
            if(this.cliente.lanzarCarta(this.jugador.getCartas().get(this.indiceCartaActual+2), this.jugador, colorElegido)){
                JOptionPane.showMessageDialog(null, "Carta exitosamente lanzada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Carta no Válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, espere su turno.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_carta3ActionPerformed

    private void carta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta4ActionPerformed
        // TODO add your handling code here:
        if(this.jugador.getCartas().size() >= 4 + this.indiceCartaActual && this.turnoPropio){
            ColorCarta colorElegido = ColorCarta.ROJO;
            if(this.jugador.getCartas().get(this.indiceCartaActual+3) instanceof CartaSinColor){
                colorElegido = ColorCarta.values()[JOptionPane.showOptionDialog(null, "Elija el color de la carta", "Elija un color", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ColorCarta.values(), ColorCarta.AMARILLO)];
            }
            if(this.cliente.lanzarCarta(this.jugador.getCartas().get(this.indiceCartaActual+3), this.jugador, colorElegido)){
                JOptionPane.showMessageDialog(null, "Carta exitosamente lanzada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Carta no Válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, espere su turno.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_carta4ActionPerformed

    private void carta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carta5ActionPerformed
        // TODO add your handling code here:
        if(this.jugador.getCartas().size() >= 5 + this.indiceCartaActual && this.turnoPropio){
            ColorCarta colorElegido = ColorCarta.ROJO;
            if(this.jugador.getCartas().get(this.indiceCartaActual+4) instanceof CartaSinColor){
                colorElegido = ColorCarta.values()[JOptionPane.showOptionDialog(null, "Elija el color de la carta", "Elija un color", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, ColorCarta.values(), ColorCarta.AMARILLO)];
            }
            if(this.cliente.lanzarCarta(this.jugador.getCartas().get(this.indiceCartaActual+4), this.jugador, colorElegido)){
                JOptionPane.showMessageDialog(null, "Carta exitosamente lanzada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Carta no Válida.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Por favor, espere su turno.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_carta5ActionPerformed

    private void ColocadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ColocadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ColocadasActionPerformed

    private void PedirCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PedirCartaActionPerformed
        // TODO add your handling code here:
        if(this.turnoPropio){
            Carta cartaPedida = this.cliente.pedirCarta(this.jugador.getNombreJugador());
            if(cartaPedida != null){
                this.jugador.getCartas().add(cartaPedida);
            }
        }
    }//GEN-LAST:event_PedirCartaActionPerformed

    private void IniciarPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarPartidaActionPerformed
        // TODO add your handling code here:
        this.cliente.iniciarPartida();
        this.PartidaIniciada.setVisible(false);
        HiloInterfaz actualizador = new HiloInterfaz(this);
        actualizador.start();
    }//GEN-LAST:event_IniciarPartidaActionPerformed

    private void DerechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DerechoActionPerformed
        // TODO add your handling code here:
        if(this.indiceCartaActual < this.jugador.getCartas().size()-1){
            this.indiceCartaActual += 1;
            String [] nombres = {"", "", "", "", ""};
            //ImageIcon [] imagenes = new ImageIcon[5];
            for (int j = 0; j < Integer.min(this.jugador.getCartas().size(), 5) && j+indiceCartaActual < this.jugador.getCartas().size(); j++) {
                
                nombres[j] = this.jugador.getCartas().get(j+indiceCartaActual).toString();
                /*
                if(!nombres[j].equals("")){
                    imagenes[j] = new ImageIcon("/resources/".concat(nombres[j]).concat(".png"));
                    System.out.println(imagenes[j].getIconWidth()+ "X" + imagenes[j].getIconHeight());
                }
                */
            }
            /*
            this.carta1.setIcon(imagenes[0]);
            this.carta2.setIcon(imagenes[1]);
            this.carta3.setIcon(imagenes[2]);
            this.carta4.setIcon(imagenes[3]);
            this.carta5.setIcon(imagenes[4]);
            */
            this.carta1.setText(nombres[0]);
            this.carta2.setText(nombres[1]);
            this.carta3.setText(nombres[2]);
            this.carta4.setText(nombres[3]);
            this.carta5.setText(nombres[4]);
        }
    }//GEN-LAST:event_DerechoActionPerformed

    private void IzquierdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IzquierdoActionPerformed
        // TODO add your handling code here:
        if(this.indiceCartaActual > 0){
            this.indiceCartaActual -= 1;
            String [] nombres = {"", "", "", "", ""};
            //ImageIcon [] imagenes = new ImageIcon[5];
            for (int j = 0; j < Integer.min(this.jugador.getCartas().size(), 5); j++) {
                    nombres[j] = this.jugador.getCartas().get(j+indiceCartaActual).toString();
                    /*
                    if(!nombres[j].equals("")){
                        imagenes[j] = new ImageIcon("/resources/".concat(nombres[j]).concat(".png"));
                        System.out.println(imagenes[j].getIconWidth()+ "X" + imagenes[j].getIconHeight());
                    }
                    */
            }
            /*
            this.carta1.setIcon(imagenes[0]);
            this.carta2.setIcon(imagenes[1]);
            this.carta3.setIcon(imagenes[2]);
            this.carta4.setIcon(imagenes[3]);
            this.carta5.setIcon(imagenes[4]);
            */
            this.carta1.setText(nombres[0]);
            this.carta2.setText(nombres[1]);
            this.carta3.setText(nombres[2]);
            this.carta4.setText(nombres[3]);
            this.carta5.setText(nombres[4]);
        }
    }//GEN-LAST:event_IzquierdoActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Colocadas;
    private javax.swing.JButton Derecho;
    private javax.swing.JButton IniciarPartida;
    private javax.swing.JButton Izquierdo;
    private javax.swing.JButton LanzarCarta;
    private javax.swing.JLabel PartidaIniciada;
    private javax.swing.JButton PedirCarta;
    private javax.swing.JButton Uno;
    private javax.swing.JButton carta1;
    private javax.swing.JButton carta2;
    private javax.swing.JButton carta3;
    private javax.swing.JButton carta4;
    private javax.swing.JButton carta5;
    private javax.swing.JLabel enTurno;
    // End of variables declaration//GEN-END:variables
}
