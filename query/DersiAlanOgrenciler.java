package query;

public class DersiAlanOgrenciler implements Query {
    public String defaultValue() { return "BPP 101"; }
    public String question() {
        return "Verilen id'ye sahip dersleri alan öðrenciler";
    }
    public String doQuery(Database db, String ders) {
        if (ders == null) ders = defaultValue();
        int n = 0;  String out = ders+"\n";
        for (Student s : db.std.values()){ 
	  for(int i=0;i<s.courses.length;i++){
		if (s.courses[i].equals(ders.toUpperCase())) {
                	out += s.id+"  "+s.name+"\n";  n++; 
            	}
	  }
	}
        System.out.println(n+" students: "+ders);
        return out;
    }
    public String author() { return "Nilay Þerif"; }
}
