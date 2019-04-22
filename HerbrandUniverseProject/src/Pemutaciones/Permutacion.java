/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pemutaciones;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roman
 */
public class Permutacion {
    
public static String per="";

    public Permutacion() {
    }

    public static String getPer() {
        return per;
    }

    public static void setPer(String per) {
        Permutacion.per = per;
    }
    
    public static void main(String[] args) {
        String[] elementos = "a,b,f(a),f(b)".split(",");
        List<String> elementoss = new ArrayList<>();
        elementoss.add("a");
        elementoss.add("b");
        elementoss.add("c");
        int n = 2;                  //Tipos para escoger, (Argumentos funcion)
        //int r = elementos.length;   //Elementos elegidos
        int r = elementoss.size();
        perm1(elementoss,"", n, r,"f");
        System.out.println(per);
    }
    
    public static void perm1(List<String> elem, String act, int n, int r,String idenFunc) {
        if (n == 0) {
//            System.out.println(act);
            per+=idenFunc+"("+act+")&";
        } else {
            for (int i = 0; i < r; i++) {
                if(n-1==0){
                perm1(elem, act + elem.get(i) + "", n - 1, r,idenFunc);
                }else{
                perm1(elem, act + elem.get(i) + ",", n - 1, r,idenFunc);
                }       
            }
        }
    }
}
