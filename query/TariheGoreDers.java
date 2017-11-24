package query;

public class TariheGoreDers implements Query {
    public String defaultValue() { return "3.01.2017"; }
    public String question() {
        return "Tarihe göre dersleri sıralama";
    }
    public String doQuery(Database db, String date) {
        if (date== null) date = defaultValue();
        int n = 0;  String out = date+"\n";
        for (Course c : db.crs.values())
            if (c.date.equals(date.toUpperCase())) {
                out += c.id+"  ";  n++;
            }
        System.out.println(n+" Date: "+date);
        return out;
    }
    public String author() { return "Selim Tural"; }
}
