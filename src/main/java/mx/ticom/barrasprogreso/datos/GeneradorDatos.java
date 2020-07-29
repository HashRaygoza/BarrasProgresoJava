/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ticom.barrasprogreso.datos;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class GeneradorDatos {
    public ArrayList<Double> datos() {
        ArrayList<Double> datos = new ArrayList<>();
        
        for(int i=0; i < 2000; i++){
            datos.add(Math.random() * 100);
        }
        
        return datos;
    }
}
