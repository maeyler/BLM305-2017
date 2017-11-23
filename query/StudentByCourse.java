package query;

public class StudentByCourse implements Query{
     
    public String defaultValue() { return "BIL 101"; }
    
    
    public String question() {
        return "List of students with given course";
    }
    
    public String doQuery(Database db, String course) {
    
       
        if (course == null) course = defaultValue();
       
           String out = course+"\n";
           
        for (Student s : db.std.values()) {
           for (int i = 0; i < s.courses.length; i++) {
                 if (s.courses[i].equals(course)) {
                out += s.id+"  "; 
            }
        
                
            }
          
        }
          
                 return out;
            
    }
    
    public String author() { return "Y. Mert Donmez"; }
    
}
