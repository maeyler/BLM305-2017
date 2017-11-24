package query;

public class ListStudentsGivenGPA implements Query{
    public String defaultValue() { return "3.0"; }
    public String question() {return "Girilen GPA'ya sahip ogrenciler";}
    
    public String doQuery(Database db, String gno) {
        if (gno == null) gno = defaultValue();
	String out = gno+" ortalamalý ogrenciler \n";
        for (Student s : db.std.values()) {
	    if (s.gpa == Float.parseFloat(gno)) {
                out += s.id+"  "+s.name+"\n"; 
		}
	}
	return out;
    }
    public String author() { return "Ahmet Fýrat ÞÜPHESÝZ"; }
}
