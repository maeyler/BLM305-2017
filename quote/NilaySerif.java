package quote;

public class NilaySerif implements Quotation {
    public int year() {
        return 0;
    }
    public String text() {
	String text = new String("Her þeyin ölçüsü insandýr"," "Cp1254");
        return text;
    }
    public String author() {
        return "Pythagoras";
    }
    public String reference() {
        return "http://www.meshursozler.com/meshur-sozleri/687-pisagor-sozleri.html";
    }
}
