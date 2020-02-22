/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import static olc.practica1_201801229.OLCPractica1_201801229.listaExpresiones;
import static olc.practica1_201801229.OLCPractica1_201801229.listaLexemas;
import static olc.practica1_201801229.OLCPractica1_201801229.listaNodos;
import static olc.practica1_201801229.OLCPractica1_201801229.listaConjunto;
import static olc.practica1_201801229.OLCPractica1_201801229.funciono;
import java.util.ArrayList;
/**
 *
 * @author jkamg
 */
public class AnalizadorLexico {

    int guardar = 0;
    int antes = 1;
    int conj = 1;
    boolean tipoConjunto = false;
    String id = "";
    boolean tipo = false;
    ExpresionesRegulares nuevaExpresion = new ExpresionesRegulares();
    LexemaEntrada nuevoLexema = new LexemaEntrada();
    Conjunto nuevoConjunto = new Conjunto();
    ArrayList<Object> elementos = new ArrayList<Object>();
    
    public AnalizadorLexico() {
    }
    
    
    public void analizar(String texto){
        String lexema = "";
        char ch;
        int estado = 1;
        for (int i = 0; i < texto.length(); i++) {
            ch = texto.charAt(i);
            switch(estado){
                case 1:
                    if(Character.isLetter(ch)){
                        lexema+= ch;
                        estado = 2;
                    }
                    else if (ch=='\u0020') {
                        
                    }
                    else if (ch == '\n') {
                        
                    }
                    else if (ch == '{') {
                        
                    }
                    else if (ch == '}') {
                        
                    }
                    else if (ch=='\u0022') {
                        estado = 3;
                    }
                    else if (ch==';') {
                        
                        if (guardar == 0) {
                            listaConjunto.add(nuevoConjunto);
                            nuevoConjunto = null;
                            nuevoConjunto = new Conjunto();
                            elementos = null;
                            elementos = new ArrayList <Object>();
                        }
                        else if (guardar == 1) {
                            if (tipo == false) {
                                listaLexemas.add(nuevoLexema);
                                nuevoLexema = null;
                                nuevoLexema = new LexemaEntrada();
                            }
                            else if (tipo == true) {
                                listaExpresiones.add(nuevaExpresion);
                                nuevaExpresion = null;
                                nuevaExpresion = new ExpresionesRegulares();
                            }
                        }
                    }
                    else if (ch=='>') {
                        if (antes == 0) {
                           
                        if (conj == 0) {
                            nuevoConjunto.setNombre(id);
                            antes = 1;
                            conj = 1;
                            estado = 6;
                        }else{
                            nuevaExpresion.setNombre(id);
                            tipo = true;
                            antes = 1;
                            estado = 5;
                        } 
                        }else{
                            
                        }
                    }
                    else if (ch==':') {
                        if (guardar == 1) {
                            nuevoLexema.setNombre(id);
                            tipo = false;
                        }
                    }
                    else if (ch=='-') {
                        
                    }
                    else if (ch=='<') {
                        
                    }
                    else if (ch=='!') {
                        estado = 7;
                    }
                    else if (ch=='/') {
                        estado = 4;
                    }
                    else if (ch=='%') {
                        
                    }
                    else{
                        funciono = false;
                    }
                    break;
                case 2:
                    if(Character.isLetterOrDigit(ch)||ch=='_'||ch=='-'){
                        lexema+=ch;
                    }
                    else{
                        estado = 1;
                        palabraReservada(lexema,ch);
                        lexema = "";
                        i--;
                    }
                    break;
                case 3:
                    if (ch=='\u0022') {
                        nuevoLexema.setLexema(lexema);
                        lexema = "";
                        estado = 1;
                    }else{
                        lexema+= ch;
                    }
                    break;
                case 4:
                    if (ch=='\n') {
                        estado = 1;
                    }else{
                        
                    }
                    break;
                case 5:
                    if (ch==';') {
                        nuevaExpresion.setExpresionRegular(lexema);
                        lexema ="";
                        i--;
                        estado = 1;
                    }else{
                        lexema+=ch;
                    }
                    break;
                case 6:
                    if (ch==';') {
                        ArrayList<Object> lo = new ArrayList<Object>();
                        for (int j = 0; j < elementos.size(); j++) {
                            lo.add(elementos.get(j));
                        }
                        nuevoConjunto.setElementos(lo);
                        i--;
                        estado = 1;
                    }else if (ch==',') {
                        nuevoConjunto.setEstado(true);
                    }else if (ch==' '){
                        
                    }else if (ch=='~') {
                        nuevoConjunto.setEstado(false);
                    }  else{
                        elementos.add(ch);
                    }
                    break;
                case 7:
                    if(ch=='!'){
                        estado = 1;
                    }else{
                        
                    }
                    break;
            }
        }
    }
    
    public void palabraReservada(String lexema, char c){
        if (lexema.equals("CONJ")) {
            guardar = 0;
            antes = 0;
            conj = 0;
        }else{
            id = lexema;
            if (conj == 0) {
                
            guardar = 0;
            }else{
                
            guardar = 1;
            }
            antes = 0;
        }
    }
}
