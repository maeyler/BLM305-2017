package query;

public class BetterGpa implements Query {
    public String defaultValue() { return "0.00";}
    public String question() {
		return "How many students they have better GPA than input number";
	}
    public String doQuery(Database db, String input) {
        double refGPA;
	if(input == null){ input = defaultValue();}
	try{
            refGPA = Double.parseDouble(input);
	}catch(Exception e){
            refGPA = Double.parseDouble(defaultValue());
	}
        int count = 0;
        for (Student s : db.std.values()){
            if(s.gpa>refGPA){
                count++;
            }	
        }
	System.out.println(count+" students have better GPA than "+input);
	return String.valueOf(count);
        }
    public String author() { return "Furkan Sarihan"; }
}
