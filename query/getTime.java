/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

/**
 *
 * @author asusnb
 */
public class getTime implements Query{
       final static String DEFAULT = "ADP 101";
    public String defaultValue() { return DEFAULT; }
    public String question() {
        return "Girilen dersin tarihi ve saati";
    }
    public String doQuery(Database db, String name) {
        
        if (name == null) return name+" not found";
        int n=0;
        String out = "";
        for (Course c : db.crs.values()) {
            
                if (c.name.equals(name)) {
                     out += c.name+"\n"+c.date+"\n"+c.time+"\n";
                     n++;
                     break;
                }
                //System.out.println(name);
            
           
        }
        return out;

    }
    public String author() { return "Hatice Kubra Danis"; }
}
