package work;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

//Sample program by Muhammet Alkan -- Dec 2017
class ImageDisplay extends JPanel {

    BufferedImage image;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, null);
    }
    public void setImage(BufferedImage i) {
        this.image = i;
    }

    public static void main(String[] args) {
        File file1 = new File("images", "Kedi.png");
        File file2 = new File("images", "examples.PNG");

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
        f.setMinimumSize(new Dimension(1000, 500));

        f.setLayout(new GridLayout(1, 2));

        ImageDisplay p1 = new ImageDisplay();
        ImageDisplay p2 = new ImageDisplay();

        try {
            p1.setImage(ImageIO.read(file1));
            p2.setImage(ImageIO.read(file2));
            f.add(p1); f.add(p2);
            f.pack(); f.setVisible(true);
        } catch (IOException ex) {
            System.out.println(" hata !! " + ex);
        }
    }
}
