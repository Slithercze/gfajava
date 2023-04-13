import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

// on first exercise - alt + enter, "add --module-..."
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * Graphics - (abstract) class that provide methods for drawing texts, figures, images on the screen
 * Coordinate system - starts at 0, ends at width/height, x / y-axis
 * Color - enumerated list (Color.YELLOW) or RGB setting 0-255 (level of red / green / blue)
 * Random - class that provides methods for generating random numbers - random.nextInt(7) - 0-6 - random colors etc.
 */

public class Drawing {
  // size of the window
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void drawMain(Graphics graphics) {
    drawRandom(graphics);
  }

  public static void drawRandom(Graphics graphics) {
    Random random = new Random();
    int caseValue = random.nextInt(7);
    switch (caseValue) {
      case 0:
        // LINE
        // x1/y1 - starting position of x/y, x2 / y2 - ending position of x/y
        graphics.drawLine(0, 0, WIDTH, HEIGHT);
        break;
      case 1:
        // RECTANGLE
        // starting position of x/y, width, height -> rectangle
        graphics.drawRect(100, 100, 100, 100);
        break;
      case 2:
        // POLYGON - use for drawing triangles, quadrilaterals, pentagons, hexagons, etc.
        // Polygons - xArray, yArray, one pair of coordinates at the same index.
        int[] xPoints = {200, 250, 300};
        int[] yPoints = {200, 100, 200};
        graphics.drawPolygon(xPoints, yPoints, xPoints.length);
        break;
      case 3:
        // OVAL
        // Different ways of creating a color - r-g-b values
        Color manualRandom = new Color(154, 120, 120);
        // How to set color? if drawSomething() function - colour of border, if fillSomething() function - colour of fill
        graphics.setColor(manualRandom);
        graphics.drawOval(100, 220, 100, 100);
        break;
      case 4:
        // RECTANGLE FILLED WITH COLOR
        // Different ways of creating a color - enum list
        Color red = Color.RED;
        // setColor() - always call before drawing itself.
        graphics.setColor(red);
        // same as drawRect, but filled by color (black or by setColor())
        graphics.fillRect(100, 100, 100, 100);
        break;
      case 5:
        // DIAGONAL
        graphics.drawLine(0, 0, WIDTH / 2, HEIGHT / 2); // black
        graphics.setColor(Color.BLUE);
        graphics.drawLine(WIDTH / 2, HEIGHT / 2, WIDTH, HEIGHT); // blue
        break;
      case 6:
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(100, 220, 100, 100);
        break;
      default:
        System.out.println("Something went wrong!");
    }
  }

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing"); // create frame
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE); // closing button / operation
    Drawing.ImagePanel panel = new Drawing.ImagePanel(); // creating new panel
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT)); // size
    jFrame.add(panel); // adds panel as a component to frame
    jFrame.setLocationRelativeTo(null); // not relative to anything else
    jFrame.setVisible(true); // visibility
    jFrame.pack(); // the pack method sizes the frame so that all its contents are at or above their preferred sizes
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      drawMain(graphics);
    }
  }
}
