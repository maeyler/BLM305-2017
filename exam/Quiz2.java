import java.io.*;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.imageio.ImageIO;

class Quiz2 extends JPanel {
    Image img;
    public Quiz2(Image i) { 
        img = i; setPreferredSize(new Dimension(200, 150));
    }
    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.drawString("Duke", 75, 12); 
        g.drawOval(10, 10, 100, 100);
        g.drawOval(11, 11, 98, 98);
        g.drawImage(img, 10, 10, 90, 90, null);
    }

    public static String fileToString(File f) throws IOException {
        InputStream in = new FileInputStream(f);
        byte[] b = new byte[in.available()];
        in.read(b);   //read the whole file into b
        return new String(b); //convert b to s    
    }
    public static void Q1(File f) throws IOException {
        String s = fileToString(f);
        System.out.printf("File:   %s bytes\n", f.length());
        System.out.printf("String: %s chars\n", s.length());
    }
    public static void Q2(File g) throws IOException {
        JFrame f = new JFrame("Quiz");
        f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
        f.add(new Quiz2(ImageIO.read(g)));
        f.pack(); f.setVisible(true);
    }
    public static void main(String[] args) throws IOException {
        Q1(new File("GitHub Kılavuzu.md")); 
        Q2(new File("images", "duke.png"));
    }
}
