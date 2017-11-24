package query;

public class StudentRankingByGradeAverage implements Query {
    final static int MAX = 3,  DEFAULT = 1;
    public String defaultValue() { return "1"; }
    public String question() {
        return "Not ortalamasına göre öğrenci bilgileri listeleme 1(<2.00) 2(2.00<not<3.00) 3(>3.00)--Max:"+MAX;
    }
    public String doQuery(Database db, String num) {
        int n = DEFAULT;
        try {
            n = Integer.parseInt(num);
            if (n<1 || n>MAX) n = DEFAULT;
        } catch(Exception e) {
        }
        String out = "";
        for (Student s:db.std.values()) {
            if (n==1) {
             float max=2.0f;
                if (s.gpa<max) {
                    out += s.description()+"\n";
                }
            }else if(n==2){
            float min=2.0f;
            float max=3.0f;
                if (s.gpa<max&&s.gpa>min) {
                    out += s.description()+"\n";
                }
            }else if(n==3){
            float min=3.0f;
            if (s.gpa>min) {
                    out += s.description()+"\n";
                }
            }
        }
        return out;
    }
    public String author() { return "Burak Çalışkan"; }
}
