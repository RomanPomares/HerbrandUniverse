/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pemutaciones;

import java.util.LinkedList;

/**
 *
 * @author Roman Pomares
 */
public class Permutaciones2 {
     public static void main(String[] args) {
        LinkedList<Character> conjunto =new LinkedList<Character>();
        conjunto.add('1');
        conjunto.add('2');
        conjunto.add('3');
        conjunto.add('4');
        conjunto.add('5');
        
        escribe ("", conjunto);
    }

    public static void escribe(String a, LinkedList<Character> conjunto) {
        if (conjunto.size()==1)
        {
            System.out.println(a+conjunto.get(0));
        }
        for (int i=0;i<conjunto.size();i++)
        {
            Character b = conjunto.remove(i);
            escribe (a+b, conjunto);
            conjunto.add(i,b);
        }
    }

}
