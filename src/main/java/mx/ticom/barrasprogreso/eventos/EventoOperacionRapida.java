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
public class EventoOperacionRapida implements ActionListener {
    private JProgressBar barra;
    Integer valor = 0;
    Boolean direccion = true;
    
    public EventoOperacionRapida(JProgressBar b) {
        barra = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(valor == 100) {
            direccion = false;
        }
        
        if(valor == 0){
            direccion = true;
        }
        
        if(direccion == true) {
            valor++;
        } else {
            valor--;
        }

        System.out.println(valor + " de 100");

        barra.setValue(valor);
    }    
}
