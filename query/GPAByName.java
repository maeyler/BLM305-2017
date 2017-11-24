package query;

public class GPAByName implements Query {

    public String defaultValue() {
        return "CEREN";
    }

    public String question() {
        return "List of gpa with given name";
    }

    public String doQuery(Database db, String name) {
        if (name == null) {
            name = defaultValue();
        }
        int n = 0;
        String out = name + "\n";
        for (Student c : db.std.values()) {
            if (c.name.equals(name.toUpperCase())) {
                out += c.gpa + "  " + "\n";
                n++;
            }
        }
        System.out.println(n + " courses: " + name);
        return out;
    }

    public String author() {
        return "Ayşe Kocakır";
    }
}

