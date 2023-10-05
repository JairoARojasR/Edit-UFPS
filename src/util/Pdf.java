/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Jairo Alexis Ramirez Rojas 1152142, Cristian Julian Lamus 1152139
 *
 */
package util;

import com.itextpdf.text.Chunk;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import java.io.FileNotFoundException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.DocumentException;

public class Pdf {

    /**
     * Crea un archivo .pdf
     *
     * @param mensaje Texto a convertir en PDF
     * @param nombreArchivo Nombre del archivo .pdf a crear
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    public void generarPdf(String mensaje, String nombreArchivo) throws FileNotFoundException, DocumentException {
        if (!(mensaje == null)) {
            FileOutputStream archivo = new FileOutputStream("src/PDF/" + nombreArchivo + ".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);

            documento.open();

            Paragraph titulo = new Paragraph(nombreArchivo);
            titulo.setAlignment(1);
            documento.add(titulo);

            documento.add(new Paragraph(mensaje));
            documento.close();

            JOptionPane.showMessageDialog(null, "El archivo PDF fue creado correctamente", "Informacion", 1);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede crear un documento vacío", "Atencion", 2);
        }
    }

    /**
     * Genera un archivo .pdf con una palabra a resaltar
     *
     * @param mensaje Texto a convertir en PDF
     * @param nombreArchivo Nombre del archivo .pdf a crear
     * @param palabraResaltar Palabra a buscar para resaltar
     * @throws FileNotFoundException
     * @throws DocumentException
     */
    public void generarPdfResaltado(String mensaje, String nombreArchivo, String palabraResaltar) throws FileNotFoundException, DocumentException {

        if (!(mensaje == null)) {
            FileOutputStream archivo = new FileOutputStream("src/PDF/" + nombreArchivo + ".pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);

            documento.open();
            Paragraph texto = new Paragraph();
            Chunk subrayado = new Chunk(palabraResaltar).setBackground(BaseColor.GREEN);
            
            Paragraph titulo = new Paragraph(nombreArchivo);
            titulo.setAlignment(1);
            documento.add(titulo);
            
            char array[] = mensaje.toCharArray();
            char subrayar[] = palabraResaltar.toCharArray();

            int contador = 0;
            String temporal = "";
            for (int i = 0; i < array.length; i++) {
                char x = array[i];
                char z = subrayar[contador];
                temporal += x;
                if (x == z) {
                    contador++;
                    if (contador == subrayar.length) {
                        texto.add(subrayado);
                        contador = 0;
                        temporal = "";
                    }
                } else {
                    texto.add(temporal);
                    temporal = "";
                    contador = 0;
                }

            }

            documento.add(texto);
            documento.close();
            JOptionPane.showMessageDialog(null, "El archivo PDF fue creado correctamente", "Informacion", 1);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede crear un documento vacío", "Atencion", 2);
        }

    }
}
