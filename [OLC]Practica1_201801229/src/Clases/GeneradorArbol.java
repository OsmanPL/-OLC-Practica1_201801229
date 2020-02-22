/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import static olc.practica1_201801229.OLCPractica1_201801229.listaExpresiones;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/**
 *
 * @author jkamg
 */
public class GeneradorArbol {
    ArrayList<Nodo> listaNodos = new ArrayList<Nodo>();
    ArrayList<Nodo> arbol = new ArrayList<Nodo>();
    int n = 0;
    int u = 0;
    Nodo inicial = new Nodo();
    String grafica = "";
    String name = "";
    String otro = "";
    public GeneradorArbol() {
    }
    
    public void separadorNodos(String regular,String nombre){
        String expresion = regular;
        String lexema = "";
        name = nombre;
        grafica += "digraph " + nombre + " {\n";
        grafica += "node[shape = record, height=.1];\n";
        char ch;
        int estado = 1;
        for (int j = 0; j < expresion.length(); j++) {
            ch = expresion.charAt(j);
            switch(estado){
                case 1:
                    if (Character.isLetter(ch)) {
                        lexema+=ch;
                        estado=2;
                    }else if (ch=='+') {
                        Nodo nuevoNodo = new Nodo();
                        String valor = ""+ch;
                        nuevoNodo.setNodo(valor);
                        listaNodos.add(nuevoNodo);
                        grafica += "node" + n + " [label=\""+ ch + "\"];\n";
                        n++;
                    }else if (ch=='.'){
                        Nodo nuevoNodo = new Nodo();
                        String valor = ""+ch;
                        nuevoNodo.setNodo(valor);
                        listaNodos.add(nuevoNodo);
                        grafica += "node" + n + " [label=\""+ ch + "\"];\n";
                        n++;
                    }else if (ch=='|') {
                        Nodo nuevoNodo = new Nodo();
                        String valor = ""+ch;
                        nuevoNodo.setNodo(valor);
                        listaNodos.add(nuevoNodo);
                        grafica += "node" + n + " [label=\""+ ch + "\"];\n";
                        n++;
                    }else if (ch=='*') {
                        Nodo nuevoNodo = new Nodo();
                        String valor = ""+ch;
                        nuevoNodo.setNodo(valor);
                        listaNodos.add(nuevoNodo);
                        grafica += "node" + n + " [label=\""+ ch + "\"];\n";
                        n++;
                    }else if (ch=='?') {
                        Nodo nuevoNodo = new Nodo();
                        String valor = ""+ch;
                        nuevoNodo.setNodo(valor);
                        listaNodos.add(nuevoNodo);
                        grafica += "node" + n + " [label=\""+ ch + "\"];\n";
                        n++;
                    }else if (ch=='\u0022') {
                        estado = 3;
                        lexema+= "(";
                    }else{
                        
                    }
                    break;
                case 2:
                    if (Character.isJavaLetterOrDigit(ch)||ch=='_'||ch=='-') {
                        lexema+=ch;
                    }else{
                        Nodo nuevoNodo = new Nodo();
                        nuevoNodo.setNodo(lexema);
                        listaNodos.add(nuevoNodo);
                        grafica += "node" + n + " [label=\""+ lexema + "\"];\n";
                        n++;
                        estado = 1;
                        lexema = "";
                        j--;
                    }
                    break;
                case 3:
                    if (ch=='\u0022') {
                        lexema+=")";
                        Nodo nuevoNodo = new Nodo();
                        nuevoNodo.setNodo(lexema);
                        grafica += "node" + n + " [label=\""+ lexema + "\"];\n";
                        n++;
                        listaNodos.add(nuevoNodo);
                        lexema = "";
                        estado = 1;
                    }else{
                        lexema+= ch;
                    }
                    break;
            }
        }
        n=0;
        generador_arbol();
    }
    
    public void generador_arbol(){
        try{
              inicial = listaNodos.get(u);
            String valor = (String)inicial.getNodo();
        if (valor.equalsIgnoreCase("|")) {
            String node = "node"+u;
            u++;
            generador_or(node);
        }else if (valor.equalsIgnoreCase(".")) {
            String node = "node"+u;
            u++;
            generador_or(node);
        }else if (valor.equalsIgnoreCase("+")) {
            String node = "node"+u;
            u++;
            generador_cerradura(node);
        }else if (valor.equalsIgnoreCase("*")) {
            String node = "node"+u;
            u++;
            generador_cerradura(node);
        }else if (valor.equalsIgnoreCase("?")) {
            String node = "node"+u;
            u++;
            generador_cerradura(node);
        }else{
            grafica += " }";
        }
        }catch(Exception e){
            grafica += " }";
        }
          
        
    }
    
    public void generador_or(String node){
        for (int i = 0; i < 2; i++) {
            inicial = listaNodos.get(u);
            String valor = (String)inicial.getNodo();
            if (valor.equalsIgnoreCase("|")) {
            grafica += node + " -> node"+u +";\n";
            generador_arbol();
        }else if (valor.equalsIgnoreCase(".")) {
            grafica += node + " -> node"+u +";\n";
            generador_arbol();
        }else if (valor.equalsIgnoreCase("+")) {
            grafica += node + " -> node"+u +";\n";
            generador_arbol();
        }else if (valor.equalsIgnoreCase("*")) {
            grafica += node + " -> node"+u +";\n";
            generador_arbol();
        }else if (valor.equalsIgnoreCase("?")) {
            grafica += node + " -> node"+u +";\n";
            generador_arbol();
        }else{
            grafica += node + " -> node"+u +";\n";
                if (i==0) {
                    u++;
                }
        }
        }
        u++;
    }
    
     public void generador_cerradura(String node){
            inicial = listaNodos.get(u);
            String valor = (String)inicial.getNodo();
            if (valor.equalsIgnoreCase("|")) {
            grafica += node + " -> node"+u +";\n";
            generador_arbol();
        }else if (valor.equalsIgnoreCase(".")) {
            grafica += node + " -> node"+u +";\n";
            generador_arbol();
        }else if (valor.equalsIgnoreCase("+")) {
            grafica += node + " -> node"+u +";\n";
            generador_arbol();
        }else if (valor.equalsIgnoreCase("*")) {
            grafica += node + " -> node"+u +";\n";
            generador_arbol();
        }else if (valor.equalsIgnoreCase("?")) {
            grafica += node + " -> node"+u +";\n";
            generador_arbol();
        }else{
            grafica += node + " -> node"+u +";\n";
        }
        u++;
    }
     public void crearArchivodot(){
         try{
            String prueba = System.getProperty("user.home") + "\\Desktop\\";
            String ruta = prueba + name + ".txt";
            otro = ruta + "\n";
            File file = new File(ruta);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(grafica);
            bw.close();
         }catch(Exception e){
             e.printStackTrace();
         }
         
         
     }
    
    public String grafica(){
        for (ExpresionesRegulares er : listaExpresiones) {
            if (er!=null) {
                n=0;
                u=0;
                listaNodos = null;
                listaNodos = new ArrayList<Nodo>();
                separadorNodos(er.getExpresionRegular(),er.getNombre());
                crearArchivodot();
                grafica = "";
            }
        }
        return otro;
    }
}
