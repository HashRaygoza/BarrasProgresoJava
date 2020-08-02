/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ticom.barrasprogreso.eventos;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JProgressBar;

/**
 *
 * @author david
 */
public class EventoProgreso implements PropertyChangeListener {
    private final JProgressBar barraProgreso;
    
    public EventoProgreso(JProgressBar barra) {
        barraProgreso = barra;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().compareTo("progress") == 0) {
            int progress = (Integer) evt.getNewValue();
            
            System.out.println("********* Progreso: " + progress);
            
            barraProgreso.setValue(progress);
        }
    }    
}
