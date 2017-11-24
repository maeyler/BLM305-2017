package query; 
import java.util.*; 
 
public class ClassesOfAStudentName implements Query { 
    public String defaultValue() { return "mehmet"; } 
    public String question() { 
        return "List of classes with given student name"; 
    } 
    public String doQuery(Database db, String name) { 
        Set<String>courses = new TreeSet<>(); 
        if (name == null) name = defaultValue(); 
        String result = name+"\n"; 
        for (Student s : db.std.values()) 
            if (s.name.equals(name.toUpperCase())) { 
                for (String crs: s.courses){ 
                    courses.addAll(Arrays.asList(db.findCourse(crs).rooms)); 
                } 
            } 
        for (String s: courses){ 
            result += (s + " "); 
        } 
        
        System.out.println(courses.size()+" classes: "+name); 
        courses = null; 
        return result; 
    } 
    public String author() { return "Salim Şahin"; } 
} 