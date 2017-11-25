/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import java.util.ArrayList;

/**
 *
 * @author fsmblm0
 */
public class FindMinId  implements Query {
   String out="";
    @Override
    public String defaultValue() {
        return "value";
    }

    @Override
    public String question() {
         return "Numarası en küçük olan ögrenciyi bul.";
    }

    @Override
    public String doQuery(Database db, String input) {
        int count = 0;
        int min = 716363208;
        ArrayList students = new ArrayList();
        for (Student s : db.std.values()) {
            count = s.id;
            if (min > count) {
                min = count;
            }
        }
        for (Student s : db.std.values()) {
        
            if (s.id == min) {
               out += s.id+"  "; 
               System.out.println(s.name + " " + s.id + " " );
            } 
        }return out;
    }


    @Override
    public String author() {
    return "Saide Fatıma Başpehlivan";
}}
