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
public class Conjunto {
    private String conjunto;
    private String nombre;
    private ArrayList<Object> elementos; 
    private boolean estado;

    public Conjunto(String conjunto, String nombre, ArrayList<Object> elementos, boolean estado) {
        this.conjunto = conjunto;
        this.nombre = nombre;
        this.elementos = elementos;
        this.estado = estado;
    }
    
    public Conjunto() {
    }

    /**
     * @return the conjunto
     */
    public String getConjunto() {
        return conjunto;
    }

    /**
     * @param conjunto the conjunto to set
     */
    public void setConjunto(String conjunto) {
        this.conjunto = conjunto;
    }

    /**
     * @return the elementos
     */
    public ArrayList<Object> getElementos() {
        return elementos;
    }

    /**
     * @param elementos the elementos to set
     */
    public void setElementos(ArrayList<Object> elementos) {
        this.elementos = elementos;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
