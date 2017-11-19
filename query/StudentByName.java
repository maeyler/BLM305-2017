package query;

public class StudentByName implements Query {
    public String defaultValue() { return "mehmet"; }
    public String question() {
        return "List of students with given name";
    }
    public String doQuery(Database db, String name) {
        if (name == null) name = defaultValue();
        int n = 0;  String out = name+"\n";
        for (Student s : db.std.values()) 
            if (s.name.equals(name.toUpperCase())) {
                out += s.id+"  ";  n++; 
            }
        System.out.println(n+" students: "+name);
        return out;
    }
    public String author() { return "M Akif Eyler"; }
}
