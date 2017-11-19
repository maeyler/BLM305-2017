package query;

public class ExamSchedule implements Query {
    final static int DEFAULT = 214002525;
    public String defaultValue() { return ""+DEFAULT; }
    public String question() {
        return "Exam schedule of a given student";
    }
    public String doQuery(Database db, String id) {
        int k = DEFAULT;
        try {
            k = Integer.parseInt(id);
        } catch(Exception e) {
        }
        Student s = db.findStudent(k);
        if (s == null) return id+" not found";
        String out = s.description()+"\n";
        for (String t : s.courses) {
            Course c = db.findCourse(t);
            out += c.description()+"\n";
        }
        return out;
    }
    public String author() { return "Small Simple Safe"; }
}
