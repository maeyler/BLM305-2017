package query;

public class CoursesById_EceAygul implements Query {
    final static int DEFAULT = 116690070;
    public String defaultValue() { return ""+DEFAULT; }
    public String question() {
        return "List of courses with given student id";
    }
    public String doQuery(Database db, String id) {
        int k = DEFAULT;
        try {
            k = Integer.parseInt(id);
        } catch(Exception e) {
        }
        Student s = db.findStudent(k);
        String out = s.name+"\n";
        for (String t : s.courses) {
            Course c = db.findCourse(t);
            out += c.name+"\n";
        }
        return out;
    }
    public String author() { return "Ece AYGÜL"; }
}

