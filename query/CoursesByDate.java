/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

/**
 *
 * @author Merve
 */
public class CoursesByDate implements Query{
    public String defaultValue() { return "15.01.2017"; }
    public String question() {
        return "List of courses with given date";
    }
    public String doQuery(Database db, String date) {
        if (date == null) date = defaultValue();
        int n = 0;  String out = date+"\n";
        for (Course c : db.crs.values()) 
            if (c.date.equals(date.toUpperCase())) {
                out += c.name+"  "+"\n";  n++; 
            }
        System.out.println(n+" courses: "+date);
        return out;
    }
    public String author() { return "Merve Kurun"; }
}
