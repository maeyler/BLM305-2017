package query;

public class RandomStudents implements Query {
    final static int MAX = 12,  DEFAULT = 6;
    public String defaultValue() { return ""+DEFAULT; }
    public String question() {
        return "List of random students -- max "+MAX;
    }
    public String doQuery(Database db, String num) {
        int n = DEFAULT;
        try {
            n = Integer.parseInt(num);
            if (n<1 || n>MAX) n = DEFAULT;
        } catch(Exception e) {
        }
        Student[] aa = db.std.values().toArray(new Student[0]);
        String out = "";
        while (n > 0) {
            Student s = aa[(int)(Math.random()*aa.length)];
            out += s.description()+"\n";  n--;  
        }
        return out;
    }
    public String author() { return "Small Simple"; }
}
