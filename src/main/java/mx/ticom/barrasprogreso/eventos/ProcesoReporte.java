/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ticom.barrasprogreso.eventos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.SwingWorker;
import mx.ticom.barrasprogreso.datos.GeneradorDatos;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author david
 */
public class ProcesoReporte extends SwingWorker<Void, Void>{    
    public ProcesoReporte() {
        this.setProgress(0);        
    }
    
    public void generarExcel() throws FileNotFoundException, IOException {
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet pagina = libro.createSheet("Pagina");
        GeneradorDatos generadorDatos = new GeneradorDatos();
        ArrayList<Double> datos = generadorDatos.datos();
                
        for(int i=0; i< datos.size(); i++){
            Row fila = pagina.createRow(i);
            Cell celda = fila.createCell(0);
            celda.setCellValue( datos.get(i));
            
            Double indice = Double.valueOf(i);
            Double total = Double.valueOf( datos.size() -1 );            

            System.out.println(indice / total);
            
            double avance = (indice / total) * 100.0;
            int progreso = (int) Math.round(avance);
            
            System.out.println("Progreso " + progreso);
            this.setProgress(progreso);
                        
            System.out.println("Agregando elemento " + i);
        }
        
        try (FileOutputStream salida = new FileOutputStream(new File("eventoExcel.xlsx"))) {
            libro.write(salida);
        }        
    }

    @Override
    protected Void doInBackground() throws Exception {
        this.generarExcel();
        
        return null;
    }
}
