import javax.swing.JComponent;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
/*Purpose: Deals with the Line that is drawn
 * 1)sets the starting x and y positions for the line
 * 2)Sets the color of the line by a pop up
 * 3)moveX and moveY functions
 */
public class LineComponent extends JComponent{
    Rectangle2D line;
    int x,y,width,height;
    public LineComponent(int xPos, int yPos,int w, int h)
    {
        x = xPos;
        y = yPos;
        width = w;
        height = h;
    }

     public void paintComponent(Graphics g)
    //overriding paintComponent method with my own drawing instructions
    {
        line = new Rectangle2D.Double(x,y,width,height);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fill(line);
    }

    public void moveX(int dx)
    {
        x = x + dx;
        repaint();
    }
    
    public void moveY(int dy)
    {
        y = y + dy;
        repaint();
    }

}
