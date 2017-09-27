/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unopoo;

/**
 *
 * @author Usuario
 */
public class Mensaje implements java.io.Serializable{
    private final Object datoSolicitud;
    private final TipoMensaje tipoDelMensaje;
    private Object datoRespuesta;

    public Mensaje(Object datoSolicitud, TipoMensaje tipoDelMensaje) {
        this.datoSolicitud = datoSolicitud;
        this.tipoDelMensaje = tipoDelMensaje;
        this.datoRespuesta = null;
    }

    public Object getDatoSolicitud() {
        return datoSolicitud;
    }

    public Object getDatoRespuesta() {
        return datoRespuesta;
    }

    public TipoMensaje getTipoDelMensaje() {
        return tipoDelMensaje;
    }

    public void setDatoRespuesta(Object datoRespuesta) {
        this.datoRespuesta = datoRespuesta;
    }
}
