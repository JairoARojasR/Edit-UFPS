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
public class ListaCD<T> implements Iterable<T> {

    private NodoD<T> cabecera;
    private int size;

    public ListaCD() {

        this.cabecera = new NodoD();
        this.cabecera.setInfo(null);
        this.cabecera.setSig(cabecera);
        this.cabecera.setAnt(cabecera);
        this.size = 0;
    }
//Logica de ListaS

    /**
     * Encuentra una incidencia en una listaCD dada otra listaCD
     *
     * @param l ListaCD a buscar
     * @return Numero de incidencias
     */
    public int buscar(ListaCD<T> l) {
        if (this.esVacia() || l.esVacia() || l.getSize() > this.size) {
            throw new RuntimeException("No hay incidencias");
        }

        NodoD<T> aux = this.cabecera.getSig();
        NodoD<T> aux2 = l.cabecera.getSig();
        int c = 0, pos = 0, incidencias = 0;

        while (aux != this.cabecera) {
            c = 0;
            if (!aux.getInfo().equals(aux2.getInfo())) {
                aux = aux.getSig();
                pos++;
            } else {
                while (aux != this.cabecera && aux2 != l.cabecera && aux.getInfo().equals(aux2.getInfo())) {
                    aux = aux.getSig();
                    aux2 = aux2.getSig();
                    c++;
                }
                if (c == l.size) {
                    incidencias++;
                }
                aux2 = l.cabecera.getSig();
            }
        }
        return incidencias;
    }

    /**
     * Método que cambia una listaCD origen por una listaCD nueva en this.
     *
     * @param origen ListaCD a sustituir
     * @param nueva ListaCD que sustituye
     * @return número de reemplazos realizados
     */
    public int reemplazar(ListaCD<T> origen, ListaCD<T> nueva) {
        if (nueva.esVacia() || origen.esVacia()) {
            throw new RuntimeException("Lista Vacía");
        }

        ListaCD<T> l1 = new ListaCD();
        ListaCD<T> l2 = new ListaCD();
        int reemplazos = 0;

        NodoD<T> aux1 = this.cabecera.getSig();
        NodoD<T> aux2 = origen.cabecera.getSig();
        NodoD<T> auxFinal = null;
        NodoD<T> auxInicial = null;
        int cont = 0;

        while (aux1 != this.cabecera) {
            if (!aux1.getInfo().equals(aux2.getInfo())) {
                aux1 = aux1.getSig();
            } else {
                auxInicial = aux1.getAnt();
                cont = 0;

                while (aux1 != this.cabecera && aux2 != origen.cabecera && aux1.getInfo().equals(aux2.getInfo())) {
                    aux1 = aux1.getSig();
                    aux2 = aux2.getSig();
                    auxFinal = aux1;
                    cont++;
                }
                if (cont == origen.size) {
                    l2 = l1.concatenar(nueva, l2);
                    l2.cabecera.getSig().setAnt(auxInicial);
                    l2.cabecera.getAnt().setSig(auxFinal);

                    auxInicial.setSig(l2.cabecera.getSig());
                    auxFinal.setAnt(l2.cabecera.getAnt());

                    l2.borrarTodo();
                    reemplazos++;
                }
                aux2 = origen.cabecera.getSig();
            }
        }
        if (nueva.size > this.size) {
            this.size = this.size + (nueva.size * reemplazos);
        } else {
            this.size = this.size - (nueva.size * reemplazos);
        }
        return reemplazos;
    }

    /**
     * Método que agrega un nodoD al principio de this.
     *
     * @param info, información del nodo
     */
    public void insertarInicio(T info) {
        NodoD<T> nuevo = new NodoD(info, this.cabecera.getSig(), this.cabecera);
        this.cabecera.setSig(nuevo);
        nuevo.getSig().setAnt(nuevo);
        this.size++;

    }

    /**
     * Método que agrega un nodoD al final de this.
     *
     * @param info, información del nodo
     */
    public void insertarFin(T info) {
        NodoD<T> nuevo = new NodoD(info, this.cabecera, this.cabecera.getAnt());
        this.cabecera.setAnt(nuevo);
        nuevo.getAnt().setSig(nuevo);
        this.size++;

    }

    private NodoD<T> getPos(int i) throws Exception {
        if (this.esVacia() || i < 0 || i >= this.size) {
            throw new Exception("Índice ilegal");
        }

        NodoD<T> aux = this.cabecera.getSig();
        while (i > 0) {
            aux = aux.getSig();
            i--;
        }
        return aux;
    }

    /**
     * Método que obtiene la información del nodo según su posición
     *
     * @param i posicion del nodo
     * @return información del nodo
     */
    public T get(int i) {

        try {
            return this.getPos(i).getInfo();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    /**
     * Método que establece la informacion de un nodo dada su posicion
     *
     * @param i posicion del nodo
     * @param infoNuevo nueva información del nodo
     */
    public void set(int i, T infoNuevo) {
        try {
            this.getPos(i).setInfo(infoNuevo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    @Override
    public String toString() {
        if (this.esVacia()) {
            return "Lista Vacía";
        }
        String msg = "Cab->";
        for (NodoD<T> x = this.cabecera.getSig(); x != this.cabecera; x = x.getSig()) {
            msg += x.getInfo() + "<-> ";
        }
        return msg + "<-> Cab";
    }

    public String toString_Inverso() {
        if (this.esVacia()) {
            return "Lista Vacía";
        }
        String msg = "Cab->";
        for (NodoD<T> x = this.cabecera.getAnt(); x != this.cabecera; x = x.getAnt()) {
            msg += x.getInfo() + "<-> ";
        }
        return msg + "<-> Cab";
    }

    /**
     * Método que verifica que this. es vacia
     *
     * @return true si es vacia, false caso contrario.
     */
    public boolean esVacia() {
        return this.cabecera == this.cabecera.getSig();
    }

    /**
     * Método que obtiene el tamaño de this.
     *
     * @return tamaño
     */
    public int getSize() {
        return size;
    }

    private ListaCD<T> concatenar(ListaCD<T> l3, ListaCD<T> aux) {
        NodoD<T> cab = l3.cabecera.getSig();
        while (cab != l3.cabecera) {
            aux.insertarFin(cab.getInfo());
            cab = cab.getSig();
            l3.size++;
        }
        return aux;
    }

    /**
     * Une dos listas en la original, usando teoría de conjuntos. La lista l2 se
     * borra.
     *
     * @param l2 ListaCD a unir
     */
    public void unionLista(ListaCD<T> l2) {

        if (l2.esVacia() || this.esVacia()) {
            throw new RuntimeException("No se pueden unir las listas");
        }
        NodoD<T> nodo2 = l2.cabecera.getSig();
        boolean estaRepetido = false;
        while (nodo2 != l2.cabecera) {
            NodoD<T> nodo1 = this.cabecera.getSig();
            while (nodo1 != this.cabecera && !estaRepetido) {
                estaRepetido = nodo1.getInfo().equals(nodo2.getInfo());
                nodo1 = nodo1.getSig();
            }
            if (!estaRepetido) {
                this.insertarFin(nodo2.getInfo());
            }
            nodo2 = nodo2.getSig();
        }
        l2.vaciarLista();
        l2.size = 0;

    }

    private void vaciarLista() {
        this.cabecera.setInfo(null);
        this.cabecera.setSig(cabecera);
        this.cabecera.setAnt(cabecera);
        this.size = 0;
    }

    /**
     * Metodo que borra un nodo según su posición
     *
     * @param i posición del nodo
     * @return información del nodo borrado.
     */
    public T borrar(int i) {

        try {
            NodoD<T> borrar = this.getPos(i);
            borrar.getAnt().setSig(borrar.getSig());
            borrar.getSig().setAnt(borrar.getAnt());
            borrar.setSig(null);
            borrar.setAnt(null);
            this.size--;
            return borrar.getInfo();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Metodo que elimina una listaCD de this. mendiente incidencias completas
     *
     * @param borrar ListaCD con los elementos a borrar
     * @return numero de elementos borrados
     */
    public int eliminar(ListaCD<T> borrar) {
        if (borrar.esVacia()) {
            throw new RuntimeException("Lista Vacía");
        }
        NodoD<T> aux1 = this.cabecera.getSig();
        NodoD<T> aux2 = borrar.cabecera.getSig();
        NodoD<T> borrarAnterior = null, borrarSiguiente = null;
        int borrados = 0, tmp = 0;

        while (aux1 != this.cabecera) {
            tmp = 0;
            if (!aux1.getInfo().equals(aux2.getInfo())) {
                aux1 = aux1.getSig();
            } else {
                borrarAnterior = aux1.getAnt();
                while (aux1 != this.cabecera && aux2 != borrar.cabecera && aux1.getInfo().equals(aux2.getInfo())) {
                    aux1 = aux1.getSig();
                    aux2 = aux2.getSig();
                    borrarSiguiente = aux1;
                    tmp++;
                }
                if (tmp == borrar.size) {
                    NodoD<T> ant = aux1.getAnt();
                    borrarAnterior.setSig(borrarSiguiente);
                    borrarSiguiente.setAnt(borrarAnterior);
                    ant.setSig(null);
                    ant.setAnt(null);
                    borrados++;
                }
                aux2 = borrar.cabecera.getSig();
            }
        }
        this.size = this.size - (borrar.size * borrados);
        return borrados;
    }

    /**
     * Concatena una lista en la original. La lista concatenada se elimina.
     *
     * @param l2 ListaCD a unir
     */
    public void concat(ListaCD<T> l2) {
        if (this.esVacia() || l2.esVacia()) {
            return;
        }
        if (this.esVacia() && !l2.esVacia()) {
            this.cabecera.setAnt(l2.cabecera.getAnt());
            this.cabecera.setSig(l2.cabecera.getSig());
            l2.cabecera.getSig().setAnt(this.cabecera);
            l2.cabecera.getAnt().setSig(this.cabecera);
            this.size = l2.size;
            l2.size = 0;
            this.desUnir(l2.cabecera);
            return;
        }
        if (!this.esVacia() && !l2.esVacia()) {
            NodoD<T> l2Inicio = l2.cabecera.getSig();
            NodoD<T> l2Fin = l2.cabecera.getSig();
            this.cabecera.getAnt().setSig(l2Inicio);
            l2Inicio.setAnt(this.cabecera.getAnt());
            this.cabecera.setAnt(l2Fin);
            l2Fin.setSig(this.cabecera);
            this.size += l2.size;
            l2.size = 0;
            this.desUnir(l2.cabecera);
        }
    }

    /**
     * Concatena la lista l2 en la original a partir de la posición indicada por
     * i (después de i) l2 al final del proceso queda vacía
     *
     * @param i posición donde va a insertar l2
     * @param l2 lista a ser concatenadas
     */
    public void concat(int i, ListaCD<T> l2) {

        if (this.esVacia() || l2.esVacia()) {
            return;
        }
        try {
            NodoD<T> nodoConexion = this.getPos(i), finalL2 = l2.cabecera.getAnt(), inicialL2 = l2.cabecera.getSig();
            nodoConexion.getSig().setAnt(finalL2);
            finalL2.setSig(nodoConexion.getSig());
            nodoConexion.setSig(inicialL2);
            inicialL2.setAnt(nodoConexion);
            this.size += l2.size;
            l2.size = 0;
            this.desUnir(l2.cabecera);
            l2.vaciarLista();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void desUnir(NodoD<T> nodo) {
        nodo.setAnt(nodo);
        nodo.setSig(nodo);
    }

    /**
     *Elimina una ListaCD completamente.
     * 
     */
    public void borrarTodo() {
        this.cabecera.setInfo(null);
        this.cabecera.setSig(cabecera);
        this.cabecera.setAnt(cabecera);
        this.size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorLCD(this.cabecera);
    }
}
