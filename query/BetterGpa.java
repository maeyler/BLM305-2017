package query;
import java.util.Scanner;

public class BetterGpa implements Query {
    public String defaultValue() { return "0,00";}
    public String question() {
		return "How many students they have better GPA than input number";
	}
    public String doQuery(Database db, String input) {
		
		Scanner sc = new Scanner(input);
        double refGPA;
        if(sc.hasNextDouble()){
		refGPA = sc.nextDouble();
		}else{
			return "The program will be waiting for valid input\nNote that you must use comma!";}    
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
