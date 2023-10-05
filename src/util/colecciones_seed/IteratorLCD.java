/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util.colecciones_seed;

import java.util.Iterator;

/**
 *
 * @author docenteauditorio
 * @param <T>
 */
public class IteratorLCD<T> implements Iterator<T> {

    private NodoD<T> cab, pos;

    public IteratorLCD(NodoD<T> cab) {
        this.cab = cab;
        this.pos = this.cab.getSig();
    }

    @Override
    public boolean hasNext() {
        return this.pos != this.cab;
    }

    @Override
    public T next() {
        if (!this.hasNext()) {
            throw new RuntimeException("No hay más datos para recorrer");
        }
        T info = this.pos.getInfo();
        this.pos = this.pos.getSig();
        return info;
    }

}
