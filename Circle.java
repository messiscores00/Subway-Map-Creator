import javax.swing.JComponent;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class Circle extends JComponent
{
    Ellipse2D circle;
    private int xPos, yPos, radius;
    Color color;
    public Circle(int xPos, int yPos, int radius, Color c){
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
        this.color = c;
    }
    
    public void paintComponent(Graphics g)
    //overriding paintComponent method with my own drawing instructions
    {
        circle = new Ellipse2D.Double(xPos,yPos,radius, radius);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.fill(circle);
        g2.setColor(color);
        Ellipse2D insideCircle = new Ellipse2D.Double(xPos, yPos, radius * .7, radius * .7);
        g2.fill(insideCircle);
    }
    
    public void setColor(Color color){
        this.color = color;
    }
}
