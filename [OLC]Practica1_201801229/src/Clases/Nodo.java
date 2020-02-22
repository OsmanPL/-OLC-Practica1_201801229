/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.util.ArrayList;
/**
 *
 * @author jkamg
 */
public class Nodo {
    
    private String nodo;
    private ArrayList<Object> nodos;

    public Nodo() {
    }

    public Nodo(String nodo, ArrayList<Object> nodos) {
        this.nodo = nodo;
        this.nodos = nodos;
    }

    /**
     * @return the nodo
     */

    /**
     * @return the nodos
     */
    public ArrayList<Object> getNodos() {
        return nodos;
    }

    /**
     * @param nodos the nodos to set
     */
    public void setNodos(ArrayList<Object> nodos) {
        this.nodos = nodos;
    }

    /**
     * @return the nodo
     */
    public String getNodo() {
        return nodo;
    }

    /**
     * @param nodo the nodo to set
     */
    public void setNodo(String nodo) {
        this.nodo = nodo;
    }
    
    
}
