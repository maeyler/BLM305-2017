/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

/**
 *
 * @author fsmblm0
 */
public class STudentByDersKodu implements Query {

    @Override
    public String defaultValue() {
        return "BPP 101";
    }

    @Override
    public String question() {
        return "List of students with given lecture Code";
    }

    public String doQuery(Database db, String dersKodu) {
        if (dersKodu == null) {
            dersKodu = defaultValue();
        }
        int n = 0;
        String out = dersKodu + "\n";
        for (Student s : db.std.values()) {
            for (int i = 0; i < s.courses.length; i++) {

                if (s.courses[i].equals(dersKodu.toUpperCase())) {
                    out += s.id + "  ";
                    n++;
                }
            }
        }
        System.out.println(n + " students: " + dersKodu);
        return out;
    }

    public String author() {
        return "Betül Ezgü";
    }

}

