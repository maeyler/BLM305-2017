package query;

public class DerslikteIslenenDersler implements Query {

    public String defaultValue() {
        return "B1006";
    }

    public String question() {
        return "derslikte işlenen dersler";
    }

    public String doQuery(Database db, String derslik) {
         if (derslik == null) derslik = defaultValue();
        int n = 0;
        String out = "";
        for (Course c : db.crs.values()) {
            for (String derslikler : c.rooms) {
                if (derslikler.contains(derslik)) {
                    out += c.name + " " + c.date + " " + c.time + "\n";
                    n++;
                    break;

                }

            }
        }
        return out;
    }

    public String author() {
        return "Seda Çağlar";
    }

}

