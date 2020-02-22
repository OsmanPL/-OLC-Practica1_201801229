/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc.practica1_201801229;
import olc.practica1_201801229.Forms.*;
import Clases.*;
import java.util.ArrayList;
/**
 *
 * @author jkamg
 */
public class OLCPractica1_201801229 {

    public static ArrayList<ExpresionesRegulares> listaExpresiones = new ArrayList<ExpresionesRegulares>();
    public static ArrayList<LexemaEntrada> listaLexemas = new ArrayList<LexemaEntrada>();
    public static ArrayList<Nodo> listaNodos = new ArrayList<Nodo>();
    public static ArrayList<Conjunto> listaConjunto = new ArrayList<Conjunto>();
    public static boolean funciono = true;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        inicio();
    }
    
    public static void inicio(){
        Analizador_Lexico al = new Analizador_Lexico();
        al.setVisible(true);
    }
    
    public static void iniciarTDA(){
        
    }
    
}
