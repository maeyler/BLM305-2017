/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

/**
 *
 * @author Tolga
 */
public class ClassLessonSchedule implements Query {


    public String defaultValue() {
       return "BZ014";
    }

    
    public String question() {
         return "Schedule of  Given Class // Verilen Sinifin Programi";
    }

    
    public String doQuery(Database db, String room) {
       if(room == null){
           room = defaultValue();
       } 
          String out = " ";
          //c.rooms.toString().equals(room)
          for(Course c : db.crs.values())
              for (int i = 0; i < c.rooms.length; i++) {
                  if(c.rooms[i].equals(room)){
                      out += c.date + " " + c.time + " " + c.name + "\n";
                  }
              }
          
          System.out.println(room + " Sinifinin programi ");
          return out;
    }

    
    public String author() {
        return "Tolga TEZEL";
    }
    
}
