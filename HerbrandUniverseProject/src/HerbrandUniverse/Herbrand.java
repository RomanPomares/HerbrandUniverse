/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerbrandUniverse;

import Pemutaciones.Permutacion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roman Pomares
 */
public class Herbrand {

    public ArrayList<String> listaTokens = new ArrayList();
    public ArrayList<String> listaFunciones = new ArrayList();
    public ArrayList<String> listaConstantes = new ArrayList();
    public ArrayList<String> listaVariables = new ArrayList();

    List<funcion> funcionesArg = new ArrayList<>();
    funcion f1 = new funcion("f");

    List<Object> recursive = new ArrayList<>();

    List<String> auxUniverso = new ArrayList<>();
    List<String> Universo = new ArrayList<>();

    public Herbrand(ArrayList<String> lt, ArrayList<String> lf, ArrayList<String> lc, ArrayList<String> lv) {
        this.listaTokens = lt;
        this.listaFunciones = lf;
        this.listaConstantes = lc;
        this.listaVariables = lv;
    }

    private void sliptFunction() {
        int contComas;

        for (String func : listaFunciones) {
            funcion f = new funcion(func);
            contComas = 0;
            for (int i = 0; i < listaTokens.size(); i++) {
                String token = listaTokens.get(i);
                if (func.equals(token)) {
                    int j = i;
                    while (!listaTokens.get(j).equals(")")) {
                        if (listaTokens.get(j).equals(",")) {
                            contComas++;
                        }
                        j++;
                    }
                }
            }
            for (int k = 0; k <= contComas; k++) {
                f.getParametros().add(new String("-"));
            }
            funcionesArg.add(f);
        }
        //imprimirLista(funcionesArg);
    }

    public DefaultTableModel HerbrandAlgorithm(int nivel) {
        sliptFunction();

        //Si no hay constantes, agrega 'a' por default al Universo
        if (listaConstantes.size() == 0) {
            listaConstantes.add(new String("a"));
        }

        //Si no hay funciones, devuelve las constantes, en numero veces deacuerdo al nivel seleccionado
        if (listaFunciones.size() == 0) {
            for (int i = 0; i < nivel; i++) {
                auxUniverso.clear();
                for (String strCons : listaConstantes) {
                    auxUniverso.add(new String(strCons));
                }
                Universo.add(auxUniverso.toString());
            }
        }

        //Si si hay funciones, hace todo el procesamiento!
        if (listaFunciones.size() != 0) {
            String toaddAuxUniverso = "";
            String totalPerm = "";
            auxUniverso.clear();
            //El proceso se repite n veces donde n el el numero de niveles
            for (int ni = 0; ni <= nivel; ni++) {
                if(ni==0){
                                for (String strCons : listaConstantes) {
                    auxUniverso.add(new String(strCons));
                    
                }Universo.add(auxUniverso.toString());
                }else{
                //Para cada nivel, se comienza agregando las constantes
                for (String strCons : listaConstantes) {
                    auxUniverso.add(new String(strCons));
                }
                for (funcion func : funcionesArg) {
                    //genera Permutaciones de la lista auxUniverso para cada funcione
                    Permutacion perm = new Permutacion();
                    perm.setPer("");
                    perm.perm1(auxUniverso, "", func.getParametros().size(), auxUniverso.size(), func.identificador);
                    //se concatena las salidas para cada funcion
                    totalPerm += perm.getPer();
                }
                //El string devuelto se splitea en una lista para agregar al Aux universo
                String str[] = totalPerm.split("&");
                List<String> al = new ArrayList<String>();
                al = Arrays.asList(str);
                auxUniverso = Stream.concat(auxUniverso.stream(), al.stream()).distinct().collect(Collectors.toList());
                Universo.add(auxUniverso.toString());
                }}

        }

        //codigo para rellenar la tabla, Universo.size = Nivel seleccionado
        String[] columnNames = {"Nivel:", "Universo:"};
        Object[][] data = new Object[Universo.size()][2];

        for (int n = 0; n < Universo.size(); n++) {
            data[n][0] = "H" + n;
            data[n][1] = Universo.get(n);
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }

    private String toStringNivel(List<Object> lista) {
        String strUniverse = "";
        //System.out.print("HU={");
        strUniverse += "HU={";
        for (Object i : lista) {
            if (i != lista.get(lista.size() - 1)) {
                if (i.getClass() == String.class) {
                    String c = (String) i;
                    //System.out.print("" + c + ",");
                    strUniverse += c + ",";
                }
                if (i.getClass() == funcion.class) {
                    funcion f = (funcion) i;
                    f.imprimirFuncion();
                    //System.out.print(",");
                    strUniverse += ",";
                }
            } else {
                if (i.getClass() == String.class) {
                    String c = (String) i;
                    //System.out.print("" + c);
                    strUniverse += c;
                }
                if (i.getClass() == funcion.class) {
                    funcion f = (funcion) i;
                    f.imprimirFuncion();
                }
            }
        }
        //System.out.println("}");
        strUniverse += "}";
        return strUniverse;
    }
}
