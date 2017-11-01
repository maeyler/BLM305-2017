public class Selam implements Runnable {
    static final int COUNT = 20;
    static final int DELAY = 5000;
    String str;
    public Selam(String s) {
        str = s;
    }
    public void run() {
        for (int i = 0; i < COUNT; i++) {
            System.out.println(i + " " + str);
            try {
                Thread.sleep((long)(Math.random() * DELAY));
            } catch (InterruptedException e) {
	    }
        }
        System.out.println("DONE! " + str);
    }
    public static void test(String s) {
        new Thread(new Selam(s)).start();
    }
    public static void main (String[] args) {
        test("Hi");
        test("Hello");
        test("Selam");
        
    }
}
