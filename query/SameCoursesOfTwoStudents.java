package query;

public class SameCoursesOfTwoStudents implements Query {
    final static String DEFAULT = "215312001 215312034";
    public String defaultValue() { return ""+DEFAULT; }
    public String question() {
        return "Same Courses of two given students";
    }
    public String doQuery(Database db, String Two_id) {
        if (Two_id == null) Two_id = defaultValue();

        String[] a = Two_id.split(" ");
        int firstId = Integer.parseInt(a[0]);
        int secondId = Integer.parseInt(a[1]);
        
        Student s = db.findStudent(firstId);
        Student s2 = db.findStudent(secondId);
        String out = s.description()+ "\n"+ s2.description()+ "\n";
         
        for (int i = 0; i < s.courses.length; i++) {
            for (int j = 0; j<s2.courses.length; j++) {
                if(s.courses[i].equals(s2.courses[j])){
                   Course c = db.findCourse(s.courses[i]);
                   out += c.description()+"\n";
                   break;
                }
            }
        }

        return out;
    }
    public String author() { return "Merve Özdemir"; }
   
    
}
