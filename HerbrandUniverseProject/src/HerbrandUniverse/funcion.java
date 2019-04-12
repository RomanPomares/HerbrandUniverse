/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerbrandUniverse;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roman Pomares
 */
public class funcion {

    String identificador;
    List<Object> parametros = new ArrayList<>();

    public funcion(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public List<Object> getParametros() {
        return parametros;
    }

    public void setParametros(List<Object> parametros) {
        this.parametros = parametros;
    }

    public void imprimirFuncion() {
        System.out.print("" + identificador + "(");

        for (Object i : parametros) {
            if (i!=parametros.get(parametros.size() - 1)) {
                if (i.getClass() == String.class) {
                    String c = (String) i;
                    System.out.print("" + c + ",");
                }
                if (i.getClass() == funcion.class) {
                    funcion f = (funcion) i;
                    f.imprimirFuncion();
                    System.out.print(",");
                }

            } else {
                if (i.getClass() == String.class) {
                    String c = (String) i;
                    System.out.print("" + c);
                }
                if (i.getClass() == funcion.class) {
                    funcion f = (funcion) i;
                    f.imprimirFuncion();
                }
            }
        }
        System.out.print(")");
    }
}
