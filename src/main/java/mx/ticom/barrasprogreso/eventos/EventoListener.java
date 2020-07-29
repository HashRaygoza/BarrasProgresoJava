/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ticom.barrasprogreso.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author david
 */
public class EventoListener implements ActionListener {
    ProcesoReporte procesoReporte;
    
    public EventoListener(ProcesoReporte proceso) {
        procesoReporte = proceso;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        procesoReporte.execute();
    }
    
}
