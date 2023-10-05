/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.colecciones_seed;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Auditorio
 */
public class ListaS<T> {

    private Nodo<T> cabeza = null;
    private int size; //en seed lo pueden encontrar como tamanio

    public ListaS() {
        cabeza = null;
    }

    public int getSize() {
        return size;
    }

    public void insertarInicio(T info) {
        this.cabeza = new Nodo(info, this.cabeza);
        this.size++;
    }

    public void insertarFin(T info) {
        if (this.esVacia()) {
            this.insertarInicio(info);
        } else {
            try {
                Nodo<T> ultimo = getPos(this.size - 1);
                Nodo<T> nuevo = new Nodo(info, null);
                //Uno:
                ultimo.setSig(nuevo);
                this.size++;
            } catch (Exception ex) {
                Logger.getLogger(ListaS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private Nodo<T> getPos(int i) throws Exception {
        if (this.esVacia() || i < 0 || i >= this.size) {
            throw new Exception("Índice ilegal");
        }

        Nodo<T> aux = this.cabeza;
        while (i > 0) {
            aux = aux.getSig();
            i--;
        }
        return aux;
    }

    public T eliminar(int i) {
        if (this.esVacia() || i < 0 || i >= this.size) {
            throw new RuntimeException("No se puede borrar la pos:" + i);
        }

        Nodo<T> nodoEliminar = null, nodoAnterior = null;
        //caso 1:
        if (i == 0) {
            nodoEliminar = this.cabeza;
            this.cabeza = this.cabeza.getSig();

        } else {
            try {
                //caso 2 y 3:
                nodoAnterior = this.getPos(i - 1);
                nodoEliminar = nodoAnterior.getSig();
                nodoAnterior.setSig(nodoEliminar.getSig());

            } catch (Exception ex) {
                System.out.println("Error inesperado");
            }

        }

        this.size--;
        nodoEliminar.setSig(null);
        return nodoEliminar.getInfo();

    }

    /**
     * Método que obtiene cuantas veces está l2 en l1
     *
     * PROHIBIDO !!!! USAR GETPOS
     *
     * Por ejemplo:
     *
     * Si L=<3,4,5,6,7,3,4,5>
     * L2 =<4,5>
     * L.getInicidencia(L2) : retornaría: 2
     *
     * Si L=<3,4,5,6,7,3,4,5>
     * L2 =<9>
     * L.getInicidencia(L2) : retornaría: 0
     *
     *
     * Si L=<3,4,5,6,7,3,4,5>
     * L2 =<4,5,5,6,7,8,9,0,0,5>
     * L.getInicidencia(L2) : retornaría: EXCEPCION
     *
     *
     * Si L=<3,4,5,6,7,3,4,5>
     * L2 =<>
     * L.getInicidencia(L2) : retornaría: EXCEPCION
     *
     *
     * @param l2 la lista de incidencia
     * @return un entero con la cantidad de incidencias
     */
    public int getIncidencias(ListaS<T> l2) {

        if (this.esVacia() || l2.esVacia() || l2.getSize() > this.size) {
            throw new RuntimeException("No hay incidencias");

        }
        Nodo<T> cab1, cab2;
        cab1 = this.cabeza;
        cab2 = l2.cabeza;
        int c = 0, incidencia = 0;
        while (cab1 != null) {
            if (cab1.getInfo().equals(cab2.getInfo())) {
                c=0;
                while (cab1 != null && cab2 != null && cab1.getInfo().equals(cab2.getInfo())) {
                    cab1 = cab1.getSig();
                    cab2 = cab2.getSig();
                    c++;
                }
                if (c == l2.size) {
                    incidencia++;
                }
                cab2 = l2.cabeza;
            } else {
                cab1 = cab1.getSig();
            }

        }

        return incidencia;
    }
    
    
    /**
     * 
     *  Encuentra l2 en lista original y reemplaza por l3
     * 
     * 
     * Por ejemplo:
     * L=<3,4,5,2,3,4,5>
     * L2=<3,4>
     * L3=<0,0,1>
     * 
     * L.getReemplazo(L2, L3)= 
     *  L=<0,0,1,5,2,0,0,1,5> retorna: 2
     * 
     * Tips: 
     *    * Deben crear lista l3 nueva
     *    * lógica igual igual igual igual igual a getIncidencia
     *    * crear el método concatenar , ir a seed2.ufps.edu.co o al gitlab
     *     * preveer no quedarse en loop.
     * @param l2 lista a buscar
     * @param l3 lista a reemplazar
     * @return  un entero con la cantidad de reemplazos que realizó
     */
    
    
    public int getReemplazo(ListaS<T> l2, ListaS<T> l3)
    {
    
        return 0;
    }
    
    

    public boolean esVacia() {
        return this.cabeza == null;
        //return this.size==0
    }

    @Override
    public String toString() {
        if (this.esVacia()) {
            return "Lista Vacía";
        }
        String msg = "Cab->";
        for (Nodo<T> x = this.cabeza; x != null; x = x.getSig()) {
            msg += x.getInfo().toString() + "-> ";
        }
        return msg + "-> null";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.cabeza);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListaS<T> other = (ListaS<T>) obj;
        //Invariantes:
        if (this.size != other.size) {
            return false;
        }
        Nodo<T> c1 = this.cabeza;
        Nodo<T> c2 = other.cabeza;
        while (c1 != null) {
            if (!c1.getInfo().equals(c2.getInfo())) {
                return false;
            }
            c1 = c1.getSig();
            c2 = c2.getSig();
        }

        return true;
    }

    public String getNombreClaseInfo() {
        return ((Object) this.cabeza.getInfo()).getClass().getName();
    }
}
