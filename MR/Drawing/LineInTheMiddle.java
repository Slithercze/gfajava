import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LineInTheMiddle {
    public static void drawImage(Graphics graphics){

        Graphics2D graphics2D = (Graphics2D) graphics;

        // draw a red horizontal line to the center of the canvas
        // draw a green vertical line to the center of the canvas

        graphics2D.setStroke(new BasicStroke(5));

        graphics.setColor(Color.RED);
        graphics.drawLine(0,HEIGHT/2,WIDTH/2,HEIGHT/2);


        graphics.setColor(Color.green);
        graphics.drawLine(WIDTH/2,0,WIDTH/2,HEIGHT/2);

        int ovalSizeX = 300;
        int ovalSizeY = 200;
        graphics.drawOval(WIDTH / 2 - ovalSizeX / 2, HEIGHT / 2 - ovalSizeY/2, ovalSizeX, ovalSizeY);

    }

    // Don't touch the code below ☠️
    static int WIDTH = 320;
    static int HEIGHT = 320;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImagePanel panel = new ImagePanel();
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        jFrame.add(panel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.pack();
    }

    static class ImagePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            drawImage(graphics);
        }
    }
}