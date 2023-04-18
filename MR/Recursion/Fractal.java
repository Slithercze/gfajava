import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Fractal {
    public static void drawImage(Graphics g) {
        //drawCrossWithOriginBug(0, 0, WIDTH / 2, HEIGHT / 3, g);
        drawCrossFractal(0, 0, WIDTH, HEIGHT, g);
    }

    static void drawCrossFractal(int originX, int originY, int width, int height, Graphics g) {
        if (Math.min(width, height) < 10) return;

        //vertical lines
        g.drawLine(originX + width / 3, originY, originX + width / 3, originY + height);
        g.drawLine(originX + width * 2 / 3, originY, originX + width * 2 / 3, originY + height);

        //horizontal lines
        g.drawLine(originX, originY + height / 3, originX + width, originY + height / 3);
        g.drawLine(originX, originY + height * 2 / 3, originX + width, originY + height * 2 / 3);

        //top left
        drawCrossFractal(originX, originY, width / 3, height / 3, g);
        //top right
        drawCrossFractal(originX + (width * 2 / 3), originY, width / 3, height / 3, g);
        //bottom left
        drawCrossFractal(originX, originY + height * 2 / 3, width / 3, height / 3, g);
        //bottom right
        drawCrossFractal(originX + (width * 2 / 3), originY + height * 2 / 3, width / 3, height / 3, g);
        //center
        drawCrossFractal(originX + width / 3, originY + height / 3, width / 3, height / 3, g);
    }

    static void drawCrossWithOriginBug(int originX, int originY, int width, int height, Graphics g) {
        //vertical lines
        g.drawLine(width / 3, originY, width / 3, height);
        g.drawLine(width * 2 / 3, originY, width * 2 / 3, height);

        //horizontal lines
        g.drawLine(originX, height / 3, width, height / 3);
        g.drawLine(originX, height * 2 / 3, width, height * 2 / 3);
    }

    // Don't touch the code below
    static int WIDTH = 640;
    static int HEIGHT = 640;

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