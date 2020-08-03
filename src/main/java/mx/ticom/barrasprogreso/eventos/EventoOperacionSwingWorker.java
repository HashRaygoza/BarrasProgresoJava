/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ticom.barrasprogreso.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JProgressBar;

/**
 *
 * @author david
 */
public class EventoOperacionSwingWorker implements ActionListener {
    private final JProgressBar barra;
    
    public EventoOperacionSwingWorker(JProgressBar b){
        barra = b;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        ProcesoReporte procesoReporte = new ProcesoReporte();
        EventoPropertyListener eventoPropertyListener = new EventoPropertyListener(barra);
        
        procesoReporte.addPropertyChangeListener(eventoPropertyListener);
        procesoReporte.execute();
    }
    
}
