/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.util.Iterator;
import util.colecciones_seed.ListaCD;

/**
 *
 * @author Jairo Alexis Ramirez Rojas 1152142, Cristian Julian Lamus 1152139
 */
public class EditUFPS {

    private ListaCD<Character> documento = new ListaCD();

    public EditUFPS() {
    }

    public EditUFPS(String texto) {
        this.documento = this.crearLista(texto);

    }

    private ListaCD<Character> crearLista(String texto) {
        char datos[] = texto.toCharArray();
        ListaCD<Character> l = new ListaCD();
        for (char x : datos) {
            l.insertarFin(x);
        }
        return l;
    }

    public String getCadena() {
        String texto = "";
        Iterator it = this.documento.iterator();
        while (it.hasNext()) {
            texto += it.next();
        }
        return texto;
    }

    /**
     * Método que retorna el numero de incidencias en la lista
     *
     * @param palabra, elemento a buscar en la lista
     * @return número de palabras encontradas en una lista.
     */
    public int buscar(String palabra) {

        return this.documento.buscar(this.crearLista(palabra));
    }

    /**
     * Método que elimina elementos segun las incidencias encontradas.
     *
     * @param palabra, elemento a eliminar en la lista.
     * @return cantidad de elementos eliminados.
     */
    public int eliminar(String palabra) {
        return this.documento.eliminar(this.crearLista(palabra));
    }

    /**
     * Metodo que obtiene el numero de reemplazos en una lista.
     *
     * @param palabra que se desea cambiar
     * @param palabraNueva palabra que remplaza la anterior
     * @return cantidad de cambios que se realizaron
     */
    public int reemplazar(String palabra, String palabraNueva) {

        return this.documento.reemplazar(this.crearLista(palabra), this.crearLista(palabraNueva));

    }

    /**
     * Metodo que retorna si el documento es vacio o no.
     *
     * @return true si es vacio y false en caso contrario.
     */
    public boolean documentoVacio() {
        return this.documento.esVacia() && this != null;
    }

}
