package query;
public class FindCourseName implements Query{
     public String defaultValue() { return "MATH 205"; }
    public String question() {
        return "List of courses with given date";
    }
    public String doQuery(Database db, String name) {
        if (name == null) name = defaultValue();
        int n = 0;  String out = name+"\n";
        for (Course c : db.crs.values()) 
            if (c.name.equals(name.toUpperCase())) {
                out += c.name+"  "+"ders var"+"\n";  n++; 
            } 
        System.out.println(n+" courses: "+name);
        return out;
    }
    public String author() { return "Omer Yazici"; }
}

