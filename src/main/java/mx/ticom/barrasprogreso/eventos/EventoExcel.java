/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ticom.barrasprogreso.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import mx.ticom.barrasprogreso.datos.GeneradorDatos;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author david
 */
public class EventoExcel implements ActionListener {
    private JProgressBar barra;
    
    public EventoExcel(JProgressBar b){
        barra=b;
    }
    
    public void generarExcel() throws FileNotFoundException, IOException {
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet pagina = libro.createSheet("Pagina");
        GeneradorDatos generadorDatos = new GeneradorDatos();
        ArrayList<Double> datos = generadorDatos.datos();
        
        barra.setMaximum( datos.size() );
                
        for(int i=0; i< datos.size(); i++){
            Row fila = pagina.createRow(i);
            Cell celda = fila.createCell(0);
            celda.setCellValue( datos.get(i));
            barra.setValue(i);
            System.out.println("Agregando elemento " + i);
        }
        
        try (FileOutputStream salida = new FileOutputStream(new File("eventoExcel.xlsx"))) {
            libro.write(salida);
        }        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            this.generarExcel();
        } catch (IOException ex) {
            Logger.getLogger(EventoExcel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
