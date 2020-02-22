/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author jkamg
 */
public class ExpresionesRegulares {
    private String nombre;
    private String expresionRegular;

    public ExpresionesRegulares(String nombre, String expresionRegular) {
        this.nombre = nombre;
        this.expresionRegular = expresionRegular;
    }
    
    public ExpresionesRegulares() {
    }

    /**
     * @return the expresionRegular
     */
    public String getExpresionRegular() {
        return expresionRegular;
    }

    /**
     * @param expresionRegular the expresionRegular to set
     */
    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
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
